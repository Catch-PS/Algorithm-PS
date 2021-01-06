package week2;

/*
 * 1. 풀이시간 : 35분
 * 
 * 2. 풀이 방법 : 뒤에서 부터 값을 확인하여 마지막에 도달할수있다면 true else false
 * 
 * time complexity: O(N)
 *
 */


public class leetcode_jumpgame_ps {
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(canJump(nums));
	}
	
	public static boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
            	last = i;
            }
        }
        return last == 0;
    }
}
