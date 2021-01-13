package Section07;

/**
 * 풀이시간 : 시간초과
 * 풀이방식 : Bottom-Up Memorization으로 풀었습니다.
 * 만약, 현재 위치한 matrix[i][j]가 1이라면,
 * dp[i][j] = dp[i][j-1], dp[i-1][j], dp[i-1][j-1]의 최솟값 + 1이 성립하여 전체 배열을 순회한 결과 최댓값을 도출할 수 있었습니다.
 * {00, 01  {01, 02
 *  10, 11}  11, 12}
 * {10, 11
 *  20, 21}
 *
 *  이전 1이 채워진 정사각형의 크기 중 최소값의 크기 + 1만큼 면적을 산출할 수 있습니다.
 *
 *  시간 복잡도 : O(N*M)
 */
public class leetcode_Maximal_Square_oht {

  public int maximalSquare(char[][] matrix) {

    if (matrix.length == 1 && matrix[0].length == 1) {

      return matrix[0][0] - '0';
    }

    int[][] dp = new int[matrix.length+1][matrix[0].length+1];
    int max = 0;

    for (int i=0; i<matrix.length; i++) {

      for (int j=0; j<matrix[i].length; j++) {

        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j] - '0';
          int area = dp[i][j] * dp[i][j];
          max = Math.max(max, area);
          continue;
        }

        if (matrix[i][j] == '1') {

          dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1]) + 1;
          int area = dp[i][j] * dp[i][j];
          max = Math.max(max, area);
        }
      }
    }

    return max;
  }
}
