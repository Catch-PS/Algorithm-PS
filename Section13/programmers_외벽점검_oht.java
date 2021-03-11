package Section13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 풀이 시간 : 초과
 *
 * 풀이 방식 :
 * 1. 원형의 취약점을 선형으로 변형합니다.
 * 2. 친구들이 순회하는 순서의 순열을 구합니다.
 * 3. 각 취약점을 시작점으로 해서 각 순열당 최소 투입 인원 수를 찾습니다.
 *
 * 시간 복잡도 : O(N^3)
 */
public class programmers_외벽점검_oht {

  public int solution(int n, int[] weak, int[] dist) {

    int length = weak.length;
    List<Integer> linearWeak = new ArrayList<>();

    //원형으로 된 영역을 처리하기 쉽게 선형으로 변환합니다. 배열에 각 원소 + n을 추가해줍니다.
    Arrays.stream(weak).forEach(linearWeak::add);
    Arrays.stream(weak).forEach(i -> linearWeak.add(i + n));

    Permutation perm = new Permutation(dist.length, dist.length);
    perm.permutation(dist, 0);
    ArrayList<ArrayList<Integer>> permutations = perm.getResult();

    int answer = dist.length + 1;


    // 1  3  4  9  10 배열이 존재한다면 i는 각각 어느 지점부터 출발할 것인지를 가리킵니다.
    for (int i = 0; i < length; i++) {

      // 친구들의 작업 처리 순서의 모든 순열을 비교합니다.
      for (ArrayList<Integer> permutation : permutations) {

        // cnt 는 작업에 투입된 인원 수를 추적합니다.
        int cnt = 1;
        //position 은 현 위치에서 해당 인원이 처리할 수 있는 범위를 나타냅니다.
        int position = linearWeak.get(i) + permutation.get(0);

        //k는 현재 처리되고 있는 취약점의 위치를 나타냅니다. 출발 지점이 i 이므로 k = i로 초기화합니다.
        // i + length 의 의미는 i 번째부터 출발해서 전체 취약점을 다 처리할 때까지를 의미합니다.
        for (int k = i; k < i + length; k++) {

          // 처리 범위를 확인하고 이를 넘어가면 인원을 투입합니다. 작업 범위도 이에 따라 더 증가합니다.
          // 단, 투입 인원이 가용 인원 보다 많을 경우, 모든 작업을 처리할 수 없으므로 반복을 빠져 나옵니다.
          if (position < linearWeak.get(k)) {

            cnt++;
            if (cnt > dist.length) {

              break;
            }

            position = linearWeak.get(k) + permutation.get(cnt-1);
          }
        }

        answer = Math.min(answer, cnt);
      }
    }

    // 모든 순열에서 투입 인원보다 가용 인원이 더 많으면 -1을 반환합니다.
    if (answer > dist.length) {

      return -1;
    }

    return answer;
  }
}

class Permutation {

  private final int n; // 총 n개의 수열
  private final int r; // r 개를 선택
  private final int[] now; // 현재 순열
  private final ArrayList<ArrayList<Integer>> result; // 모든 순열

  public ArrayList<ArrayList<Integer>> getResult() {

    return result;
  }

  //nPr 을 구합니다.
  public Permutation(int n, int r) {

    this.n = n;
    this.r = r;
    this.now = new int[r];
    this.result = new ArrayList<>();
  }

  public void swap(int[] arr, int i, int j) {

    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public void permutation(int[] arr, int depth) {

    // 현재 순열의 길이가 r과 일치할 때, result 배열에 결과를 저장합니다.
    if (depth == r) {

      ArrayList<Integer> tmp = new ArrayList<>();
      Arrays.stream(now).forEach(tmp::add);
      result.add(tmp);
      return;
    }

   /*
   3, 5, 7 의 경우,
   3  5  7
   3  7  5
   5  3  7
   5  7  3
   7  5  3
   7  3  5
   순서로 순열이 배치됩니다.
    */
    for (int i = depth; i < n; i++) {
      swap(arr, i, depth);
      now[depth] = arr[depth];
      permutation(arr, depth + 1);
      swap(arr, i, depth);
    }
  }
}
