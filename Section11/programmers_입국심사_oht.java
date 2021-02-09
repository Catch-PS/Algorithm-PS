package Section11;

import java.util.Arrays;

/**
 * 풀이시간 : 30분
 *
 * 풀이방식 : binarySearch 를 사용하여 모든 사람이 검사하는데 걸리는 최소 시간을 찾았습니다.
 *
 * 시간 복잡도 : O(logn)
 */
public class programmers_입국심사_oht {

  public long solution(int n, int[] times) {

    Arrays.sort(times);
    int max = times[times.length - 1]; //가장 오래 걸리는 심사위원의 심사시간

    return binarySearch(times, n, max);
  }

  private long binarySearch(int[] times, int n, int max) {

    long time = (long) max * (long) n;
    long left = 1;
    long right = time;

    while(left<=right) {

      long mid = (left + right) / 2;

      if(isChecked(times, n, mid)) {

        if(time > mid) {
          time = mid;
        }
        right = mid - 1;

      } else {

        left = mid + 1;
      }

    }

    return time;
  }

  private boolean isChecked(int[] times, int n, long mid) {

    long done = 0;
    for (int time : times) {

      done += mid / time; // 현재 시간값 / 각 심사시간 = 심사받은 인원 수
    }

    return done >= n; //현재 인원 수를 기준으로 값을 반환합니다.
  }
}
