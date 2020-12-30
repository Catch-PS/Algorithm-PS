package Section05;

/**
 * 풀이 시간 : 20분
 * 풀이 방식 : 배열의 인덱스가 변경된 matrix와의 관계를 찾고, 인덱스에 값을 재배치 시켰습니다.
 * 시간 복잡도 : O(MN) M = 매트릭스 가로 수 N = " 세로 수
 */
public class leetcode_rotate_image_oht {

  /* y=0일때, x=0, 1, 2 순서로 늘어남    x=0일때, y는 2, 1, 0 순서로 줄어듬
     {00, 01, 02},                    {20, 10, 00}
     {10, 11, 12},         ->         {21, 11, 01}
     {20, 21, 22}                     {22, 12, 02}
     즉 origin[y][x]  change[length-x-1][y]
   */
  public void rotate(int[][] matrix) {

    int[][] cp = new int[matrix.length][matrix[0].length];

    for (int i=0; i<matrix.length; i++) {
      for (int j=0; j<matrix[i].length; j++) {

        cp[j][i] = matrix[matrix.length-i-1][j];
      }
    }

    copyArrays(matrix, cp);
  }

  private void copyArrays(int[][] origin, int[][] target) {

    for (int i=0; i< origin.length; i++) {

      for (int j=0; j< origin[i].length; j++) {

        origin[i][j] = target[i][j];
      }
    }
  }
}
