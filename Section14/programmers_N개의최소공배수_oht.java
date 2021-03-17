package Section14;

/**
 * 풀이시간 : 50분
 *
 * 풀이 방식 : 주어진 배열에서 2개씩 최소공배수를 구합니다.
 *
 * 시간복잡도 : O(N^2)
 */

public class programmers_N개의최소공배수_oht {

  public int solution(int[] arr) {

    int lcm = arr[0];

    for (int i = 1; i < arr.length; i++) {

      int gcd = calculateGcd(lcm, arr[i]);
      lcm = gcd * (lcm / gcd) * (arr[i] / gcd);
    }

    return lcm;
  }

  private int calculateGcd(int a, int b) {

    int min = Math.min(a, b);
    int gcd = 1;

    for (int i = min; i >= 1; i--) {

      if (a % i == 0 && b % i == 0) {

        gcd = i;
        break;
      }
    }

    return gcd;
  }
}
