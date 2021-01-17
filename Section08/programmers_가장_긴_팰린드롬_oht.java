package Section08;

/**
 * 풀이시간 : 40분
 *
 * 풀이 방식 : memorization 방식으로 풀었습니다.
 *
 * 문자열 전체를 순환하고, start와 end 포인터를 움직이면서 팰린드롬 여부를 검사했습니다.
 * 1. 문자열 순회 방식
 * ex) 0 1 2 3 4 5
 *     a b a c d e
 *
 * 00
 * 0-1 11
 * 0-2 1-2 22
 * 0-3 1-3 2-3 33
 * 0-4 1-4 2-4 3-4 44
 * 0-5 1-5 2-5 3-5 4-5 55
 *
 * 순서로 전체를 순회합니다.
 *
 * 2. 팰린드롬 여부 검사
 * ex) 0 1 2 3 4 5
 *     a d d a b c
 *
 * 위와 같은 경우, 0-3을 검사하기 전, 0 to 2를 반복할 때, 결과를 dp에 memorization 해놓습니다.
 * 즉, 이전 반복문에서 1-2는 이미 검사된 상태이기 때문에 dp[2][1]이 참이고, 0, 3의 문자가 참이면 팰린드롬입니다.
 *
 * 3. 팰린드롬이면 Max값을 갱신합니다.
 *
 * 시간 복잡도 : O(N^2)
 * 공간 복잡도 : O(N^2)
 *
 */
public class programmers_가장_긴_팰린드롬_oht {

  public int solution(String s) {

    boolean[][] dp = new boolean[s.length()][s.length()];
    int max = 0;

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j <= i; j++) {

        char start = s.charAt(j);
        char end = s.charAt(i);

        if (start == end) {

          if (i - j < 2 || dp[j + 1][i - 1]) {

            dp[j][i] = true;
            int length = i - j + 1;

            max = Math.max(length, max);
          }
        }
      }
    }

    return max;
  }
}
