package level3;
/*
 * 1. 풀이시간 : 시간초과
 * 2. 예상 시간복잡도 : O(N)
 * 3. 풀이방법
 * 	- dp문제 -> 점화식 찾기
 *  - n = 1 -> 경우의 수 1 / n = 2 -> 경우의 수 2 / n = 3 -> 경우의 수 3 / n = 4 -> 경우의 수 5
 *    => dp[n] = dp[n-1] + dp[n-2]
 */	
public class programmers_2xn타일링 {

	public static void main(String[] args) {
		int n = 4;
		int result = 0;
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 1000000007;
		}
		
		result = dp[n];
		System.out.println(result);
	}

}
