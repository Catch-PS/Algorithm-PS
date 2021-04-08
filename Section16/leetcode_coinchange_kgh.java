package 스터디.스터디_SNU.Section16;

/**
 * 1.문제 풀이 시간
 * 초과
 * 2. 컴퓨팅 사고
 * (1) DFS+DP를 이용한 최소 동전의 개수를 찾는 문제
 * 동전이 1,2,5 라고 가정하면 11로 만들수 있는 최소 동전 개수는 총 3개가 됩니다.
 * 5+5+1 = 11
 * (2) dp[0] = 1, dp[1] = 2, dp[2] = dp[0]+dp[1]
 * 피보나치수열과 비슷하다.
 * (3) 최솟값 + 1 을 해주어서 자기자신을 제외한 개수를 가져온다.
 * (4) 최종적으로 answer값이 amount값보다 크다면 도달하지 못한것이므로 -1, 그게 아니면 answer를 리턴한다.
 *
 * 3. 시간복잡도
 * O(DP+RECURSIVE)
 */


public class leetcode_coinchange_kgh {
    static int[] dp;
    public static void main(String[] args) {
        coinChange(new int[]{1, 2, 5}, 11);
//        coinChange(new int[]{1}, 0);
//        coinChange(new int[]{1}, 2147483647);
//        coinChange(new int[]{1}, 0);
    }

     public static int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        int answer = dfs(coins, dp, amount);
        System.out.println(answer > amount ? -1 : answer);
        return answer > amount ? -1 : answer;
    }

    public static int dfs(int[] coins, int[] dp, int amount) {
        if (amount < 0){
            return Integer.MAX_VALUE-1;
        }
        if (amount == 0){
            return 0;
        }
        // dp
        if (dp[amount] > 0){
            return dp[amount];
        }
        int min = Integer.MAX_VALUE - 1;

        for (int i = 0; i < coins.length; i++) {
            int num = dfs(coins, dp, amount - coins[i]);
            min = Math.min(min, num+1);
        }
        return dp[amount] = min;
    }
}

//status: Memory Limit Exceeded
/*
public class leetcode_coinchange_kgh {
    static List<Integer> arrList;
    static List<List<Integer>> totalList;
    static int answer;
    public static void main(String[] args) {
        coinChange(new int[] {1,2,5}, 11);
        coinChange(new int[] {1}, 0);
        coinChange(new int[] {1}, 2147483647);
        coinChange(new int[] {1}, 0);
        arrList.clear();
        totalList.clear();
    }
    static int coinChange(int[] coins, int amount) {
        arrList = new ArrayList<>();
        totalList = new ArrayList<>();
        answer = -1;
        dfs(coins, amount);
        if(answer== 0) answer = -1;
        if(totalList.size() == 0) return -1;
        answer = totalList.get(0).size();
        for(int i=0; i<totalList.size(); i++){
            answer = Math.min(answer, totalList.get(i).size());
        }
        System.out.println(answer);
        return answer;
    }
    private static void dfs(int[] coins, int amount) {
        if(amount < 0){
            return;
        } else if(amount == 0){
            totalList.add(new ArrayList<>(arrList));
            return;
        }
        for(int i=0; i<coins.length; i++){
            arrList.add(coins[i]);
            dfs(coins,amount-coins[i]);
            arrList.remove(arrList.size()-1);
        }
    }
}
*/
