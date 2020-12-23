package 스터디.스터디_SNU.Section04;

/**
 * 1. 초과
 * 2. 문제 풀이 방법
 * 처음에 재귀로 모든 조합을 구하려고 하였지만 (2,3,1)의 경우는 찾을 수 없었다고 판단하여 또 다른 방식이 필요할 것이라 생각하였습니다.
 * root node기준으로 sub problem으로 두고 메모이제이션을 처리하면 값을 구할 수 있습니다.
 * N: 4 일 경우 root node 1~4까지의 값을 가지고 있고, left * right형식으로 모든 경우의 수를 더해나가면 값을 도출시킬 수 있습니다.
 * 3. 시간복잡도: O(N^2) -> O(N^2)
 */
public class leetcode_unique_binary_search_tree_kgh {
    static int[] dp;
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    static int numTrees(int n) {
        dp = new int[n+1];
        dp[0] = 1; // node number of empty
        dp[1] = 1; // node number of one

        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

}
