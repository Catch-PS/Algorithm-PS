package Section16;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 풀이 시간 : 20분
 *
 * 풀이 방식 :
 * 1. priorityQueue 에 정렬된 상태로 저장하고 가져올 수 있도록 합니다.
 * 2. queue의 크기가 2보다 작으면 성립하지 않기 때문에 -1을 반환합니다.
 * 3. queue의 첫 번째 원소가 K보다 커지면 반복을 종료하고 합성 횟수를 반환합니다.
 *
 * 시간 복잡도 : O(nlogn) ?
 */
public class programmers_더맵게_oht {

  public int solution(int[] scoville, int K) {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    Arrays.stream(scoville).forEach(queue::add);

    int cnt = 0;

    while (queue.peek() < K) {

      if (queue.size() < 2) {
        return -1;
      }

      int first = queue.poll();
      int second = queue.poll();

      int cmp = first + (second * 2);
      queue.add(cmp);
      cnt++;
    }

    return cnt;
  }
}
