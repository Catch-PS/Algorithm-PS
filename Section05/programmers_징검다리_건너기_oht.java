package Section05;

/**
 * 풀이 시간 : 초과
 * 풀이 방식 : 징검다리를 건널 수 있는 인원 수를 binarySearch로 대입해보면서 돌과의 거리가 k랑 일치할 때, 인원 수를 반환합니다.
 * 시간 복잡도 : O(nlogn)? 서치 logn * 거리판단 n
 */
public class programmers_징검다리_건너기_oht {
  public int solution(int[] stones, int k) {

    int max = 0;
    int min = stones[0];
    for (int stone : stones) {

      max = Math.max(stone, max);
      min = Math.min(stone, min);
    }
    return binarySearch(stones, k, min, max);
  }

  private int binarySearch(int[] stones, int k, int start, int end) {

    int answer=0;
    while (start <= end) {

      int cnt = 0;
      int half = (start + end)/2;

      boolean jumpPossible = true;
      for (int stone : stones) {

        int value = stone - half;
        if (value < 0) {

          cnt++;
        } else {
          cnt = 0;
        }

        if (cnt >= k) {
          jumpPossible = false;
          break;
        }
      }

      if(!jumpPossible){
        end=half-1;
      }
      else{
        start=half+1;
        answer = Math.max(answer, half);
      }
    }

    return answer;
  }
}
