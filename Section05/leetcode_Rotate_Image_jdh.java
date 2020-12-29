/*
    풀이 시간: 30분
    예상 시간복잡도: O(n^2)
    풀이 방법: 새로 배열을 할당하지 않아야 하기 때문에 rotation할 때 값이 덮어씌워 지는 것을 주의해야 합니다.
            사각형이기 때문에 네 변에 하나씩 원소를 잡아서 rotation 해주었습니다.
            즉 첫번재 행, 마지막 열, 마지막 행, 첫번째 열에 원소를 하나씩 잡아서 이들끼리 rotation 했습니다.
 */
public class leetcode_Rotate_Image_jdh {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - i - 1; ++j) {
                int tmp = matrix[i][j]; // 위에 있는 원소 tmp에 임시 저장
                matrix[i][j] = matrix[n - j - 1][i]; // 오른쪽 원소를 위로
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]; // 아래 원소를 오른쪽으로
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]; // 왼쪽 원소를 아래쪽으로
                matrix[j][n - i - 1] = tmp; // 왼쪽 원소를 tmp에 저장했던 위 원소로
            }
        }
    }
}
