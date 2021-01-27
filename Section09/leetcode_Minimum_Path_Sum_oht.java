package Section09;

/**
 * 풀이 시간 : 1시간
 *
 * 풀이 방식 : Top-down 방식을 사용하여 풀었습니다.
 *
 * 1. 깊이 탐색을 통해 f(y, x) = min(f(y - 1, x), f(y, x - 1)) + g(y, x) 점화식을 반복합니다.
 *
 * 2. x 와 y 중 0 이하가 되면 최솟값 비교를 해야하기 때문에
 *    MAX_VALUE를 저장하여 트리 반대쪽 값만 더해질 수 있게 합니다.
 *
 * 3. x, y 가 동시에 0, 0이 되면 깊이 탐색을 종료하고 값을 반환합니다.
 *
 * 시간복잡도 :
 */
public class leetcode_Minimum_Path_Sum_oht {

  private static final int MAX_VALUE = 200;

  public int minPathSum(int[][] grid) {

    int[][] dp = new int[grid.length][grid[0].length];

    return dfs(grid, dp, grid[0].length - 1, grid.length - 1);

  }


  private int dfs(int[][] grid, int[][] dp, int x, int y) {

    if (x == 0 && y == 0) {

      return grid[0][0];
    }

    if (x < 0 || y < 0) {

      return MAX_VALUE;
    }

    if (dp[y][x] != 0) {

      return dp[y][x];
    }

    dp[y][x] += grid[y][x] + Math.min(dfs(grid, dp, x - 1, y),
            dfs(grid, dp, x, y - 1)) ;

    return dp[y][x];
  }
}
