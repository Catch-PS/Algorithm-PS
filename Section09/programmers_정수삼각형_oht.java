package Section09;

/**
 * 풀이시간 : 40분
 *
 * 풀이방식 : Top-down 방식의 dp를 활용해서 풀었습니다.
 *
 * f(x, y) = Math.max(f(x - 1, y - 1), f(x, y - 1)) + g(x, y)
 * 점화식을 합을 구하고, dp[y][x]에 값을 저장합니다.
 *
 * 이전에 확인했던 값의 경우, dp[y][x]를 반환하여 중복되는 연산을 줄였습니다.
 *
 * 최종적으로 탐색이 끝나면 가장 큰 합이 반환됩니다.
 *
 * 시간 복잡도 : O(N^2)?
 */
public class programmers_정수삼각형_oht {

  public int solution(int[][] triangle) {

    int answer = 0;
    int[][] dp = new int[triangle.length][triangle.length];

    for (int i = 0; i< triangle.length; i++) {

      answer = Math.max(answer, dfs(triangle, dp, triangle.length - 1, i));
    }

    return answer;
  }

  private int dfs(final int[][] triangle, int[][] dp, int y, int x) {

    if (y < 0 || x < 0 || x >= triangle[y].length) {

      return 0;
    }

    if (dp[y][x] != 0) {

      return dp[y][x];
    }

    dp[y][x] += Math.max(dfs(triangle, dp, y - 1,x),
            dfs(triangle, dp, y - 1,x - 1)) + triangle[y][x];

    return dp[y][x];
  }
}
