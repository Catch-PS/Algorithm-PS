/*
    풀이 시간: 20분
    풀이 방법: dp 배열을 만들고, dp 값을 계산하면서 max 값을 update
    ex)  nums : -2 1 -3 4 -1 2 1 -5 4
         dp   : -2 1 -2 4  3 5 6  1 5
         dp는 해당 인덱스까지의 서브 어레이의 합을 계산
    시간 복잡도: O(N)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i-1];
            }
            max = dp[i] > max ? dp[i] : max;
        }

        return max;
    }
}
