/*
    풀이 시간: 10분
    예상 시간복잡도 : O(n)
    풀이 방법: 세로의 길이가 2로 고정되어 있으므로 가로에 올 수 있는 경우의 수를 구하면 규칙을 발견할 수 있습니다.
            구하려는 n의 (n - 1)의 경우의 수와 (n - 2)의 경우의 수를 더하면 n의 경우의 수를 구할 수 있습니다.
 */

public class programmers_2xn타일링_jdh {

    public static int solution(int n) {
        int answer = 0;

        int dp[] = new int[60000];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String args[]){
        System.out.println(solution(5));
    }
}
