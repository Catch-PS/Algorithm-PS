package Section05;

/**
 * 풀이시간: 1시간
 * 풀이방식 : Path[m][n] = Path[m-1][n] + Path[m][n-1] 이라는 공식을 재귀적으로 dfs 방식으로 풀었습니다.
 * 단, 풀 스캔을 하면 2^n 정도? 연산이 반복되기 때문에
 * Timeout이 발생하므로 Memorization 방식으로 기존의 계산한 값은 저장해두고 꺼내서 쓰는 DP형태로 풀었습니다.
 * 시간복잡도 :
 */
public class leetcode_unique_path_oht {

  public int uniquePaths(int m, int n) {

    int[][] path = new int[m][n];
    path[0][0] = 1;
    count(path, m-1, n-1);

    return path[m-1][n-1];
  }

  private int count(int[][] path, int m, int n) {


    if(m < 0 || n < 0) {

      return 0;
    }

    if(path[m][n] != 0) {

      return path[m][n];
    }

    int result = count(path, m-1, n) + count(path, m, n-1);
    path[m][n] = result;

    return result;
  }
}
