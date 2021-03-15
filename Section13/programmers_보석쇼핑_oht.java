package Section13;

import java.util.*;

/**
 * 풀이시간 : 초과
 *
 * 풀이 방식 : 투 포인트 알고리즘을 사용해서 풀었습니다.
 *
 * 1. start 와 end 포인트를 0, 0 에 맞추고 시작합니다.
 * 2. end를 늘려가면서 현재 보석의 종류의 개수를 파악합니다.
 *
 * 총 필요한 보석 갯수가 3개라는 가정 하에 탐색을 위해 end 포인터를 움직입니다.
 *
 * 1      1      2      3      1
 * start
 * end
 *
 * 1      1      2      3      1
 * start  end
 *
 * 1      1      2      3      1
 * start         end
 *
 * 1      1      2      3      1
 * start                end
 *
 * 종류의 갯수가 일치하면 start 포인터를 움직입니다.
 * 이 때, start to end의 길이가 min값 보다 작으면 answer 배열을 start, end의 값으로 초기화합니다.
 *
 * 1      1      2      3      1
 *        start         end
 *
 * start 를 움직인 상태에서 보석의 개수가 다시 맞지 않는다면 그때부터 다시 end 포인터를 움직입니다.
 * end 포인터가 최종적으로 가장 마지막 인덱스에 위치하면 그때부터는 start 포인터만 증가시킵니다.
 *
 * 1      1      2      3      1
 *               start  end
 *
 * 시간 복잡도 : O(N + M)
 * N은 start 포인터가 0 -> gems.length - 1까지 가는 이동 수
 * M은 end 포인터가 0 -> gems.length - 1까지 가는 이동 수
 *
 */
public class programmers_보석쇼핑_oht {
  public int[] solution(String[] gems) {

    return search(gems, new HashSet<>(Arrays.asList(gems)));
  }

  private int[] search(String[] gems, Set<String> gemSet) {

    int[] answer = new int[2];

    int start = 0;
    int end = 0;
    int min = Integer.MAX_VALUE;

    //반복문을 진행하면서 각 보석 종류별 갯수 저장
    Map<String, Integer> check = new HashMap<>();
    gemSet.forEach(s -> check.put(s, 0));

    //반복을 돌면서 보석의 종류를 체크할 Set
    Set<String> tmp = new HashSet<>();

    while (start <= end) {

      if (tmp.size() == gemSet.size()) {

        if (min > end - start) {

          answer[0] = start + 1;
          answer[1] = end;
          min = end - start;
        }

        //현재까지 탐색한 보석 종류의 갯수와 보석의 종류가 일치하면
        //현 상태에서 제일 앞의 보석을 제거합니다.
        //이 때, 해당 보석의 갯수가 0이 되면 현재 탐색한 보석 종류 Set 에서 해당 보석을 제거합니다.
        int count = check.get(gems[start]) - 1;
        if (count == 0) {

          tmp.remove(gems[start]);
        }
        check.put(gems[start], count);

        start++;
      } else {

        if (end == gems.length) {

          start++;
          continue;
        }

        //현재 종류별 키의 개수 저장
        check.put(gems[end], check.get(gems[end]) + 1);
        tmp.add(gems[end++]);
      }

    }

    return answer;
  }
}
