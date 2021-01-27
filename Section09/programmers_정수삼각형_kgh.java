package 스터디.스터디_SNU.Section09;

/**
 * 1. 문제풀이시간: 20분
 * 2. 컴퓨팅 사고
 * 전형적인 DP문제라고 생각을 하였던 이유가 누적된 값을 가지고 처리해야한다고 생각을헀습니다.
 * 따라서, 현재자신의값과 왼쪽과 오른쪽의 누적합을 구하는 규칙을 찾아야합니다.
 *
 * [7]
 * [3, 8]
 * [8, 1, 0]
 * [2, 7, 4, 4]
 * [4, 5, 2, 6, 5]
 * 다음과 같이 입력이 주어졌을때 누적되는 숫자의 최댓값을 dp로 처리해였습니다.
 * 맨 처음에 있는 값을 기준으로 DP bottom-up방식으로 순차적으로 증가해나갔습니다.
 * 7
 * 7+3 7+8      (중복되는 값이 있기때문에 둘중에 더 큰값을 기준으로 더해나갑니다) 7+3, 7+8에서 한개만 선택해야하므로
 * 7+3+8 7+8+1 7+8
 * ..... 이런형식으로 더해나가면 다음과 같은 결과를 볼 수 있습니다.
 * [7, 0, 0, 0, 0]
 * [10, 15, 0, 0, 0]
 * [18, 16, 15, 0, 0]
 * [20, 25, 20, 19, 0]
 * [24, 30, 27, 26, 24]
 *
 * 마지막행에 있는 값을 for문을 다시사용하여 비교하려했지만 하나의 for문내에서 max값을 비교하여 바로 결과를 도출할 수 있도록 하였습니다.
 *
 * 3. 시간복잡도
 * O(N)
 *
 */
public class programmers_정수삼각형_kgh {
    public static void main(String[] args) {
        solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }
    static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        int answer = 0;
        for(int i=1; i<triangle.length; i++){
            for(int j=1; j<triangle[i].length; j++){
                // Left
                dp[i][j-1] = Math.max(dp[i-1][j-1] + triangle[i][j-1],dp[i][j-1]);
                answer = Math.max(dp[i][j-1],answer);

                // Right
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i][j]);
                answer = Math.max(dp[i][j-1],answer);
            }
        }
        System.out.println(answer);
        return 0;
    }
}
