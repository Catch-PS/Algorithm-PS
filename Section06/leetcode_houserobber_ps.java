package week2;

/*
 * 1. 풀이시간 : 25분
 * 
 * 2. 풀이 방법 : DP 문제 . memoization을 통해 두수의 큰수를 트래킹하며 값을 찾는다.  
 * 				hint: Math.max(memo[i-2] + nums[i], memo[i-1]); 
 * 				// 전전집과 현재 집의 합을 그전 집과 비교한다. 
 * 
 * time complexity: O(N)
 * 
 */


public class leetcode_houserobber_ps {
	public static void main(String[] args) {
        int[] nums = {1,2,3,1,5,4,23,1,23,43,3,2,1,4,21};
        
        System.out.println(rob(nums));
    }
    
    public static int rob(int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    if(nums.length==1)
	        return nums[0];
	 
	    int[] dp = new int[nums.length];
	    dp[0]=nums[0];
	    dp[1]=Math.max(nums[0], nums[1]);
	 
	    for(int i=2; i<nums.length; i++){
	        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
	    }
	 
	    return dp[nums.length-1];
   }

}
