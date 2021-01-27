/*
    풀이 시간: 30분
    예상 시간복잡도: ... O(n^2)....?
    풀이 방법: DP로 접근했습니다. 왼쪽 가쪽에 있는 원소의 경우와 오른쪽 가쪽에 있는 원소는 max 값을 찾을 필요없이 바로 위 부모의 합에 자신의 수를 더해주면 되고,
            가운데에 있는 원소들의 경우 바로 위 부모 두개의 원소 중 큰 값에 본인의 수를 더해나가면 됩니다.
 */

public class programmers_정수삼각형_jdh {
    public static int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int dp[] = new int[(n * (n + 1)) / 2];

        dp[0] = triangle[0][0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j < triangle[i].length; j++){
                int l = (i * (i + 1)) / 2 + j;
                if(j == 0) dp[l] = dp[l - i] + triangle[i][j];
                else if(j == triangle[i].length - 1) dp[l] = dp[l - i - 1] + triangle[i][j];
                else dp[l] = Math.max(dp[l - i - 1], dp[l - i]) + triangle[i][j];

                if(answer < dp[l]) answer = dp[l];
             }
        }
        return answer;
    }

    public static void main(String args[]){
        int triangle[][] = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
}
