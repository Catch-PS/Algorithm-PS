package week2;

import java.util.Arrays;



/*
 * #1 �ҿ�ð� �뷫 4�ð� 30��.
 * 
 * #2-1 ù ��° �� ���� ���� 
 * �տ��� ���� ���ʴ�� ���� ���� dp1 �� ����
 * �ڿ��� ���� ���ʴ�� ���� ���� dp2 �� ����
 * �Ŀ� ������ �ִ밪�� idx �� �������� �������� Ǯ�� but ����....
 * 
 * #2-2 greedy �˰��� ü�� �� ���¸��� ���� ������ �ظ� ����.
 * �� ���¿��� �ִ� ���� ��� ������ ���� ū���� ������.
 * 
 * 
 * #3 �ð����⵵
 * O(N)
 */


public class leetcode_Maximum_Subarray_pcy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		// ���� ���� dp1 �迭�� ����.
		int[] dp1 = new int[nums.length];
		
		
		
		// ���� ó������ ���Ұ� �����Ƿ� nums[0]�� ����...
		dp1[0]=nums[0];
		
		// ù �ִ밪�� dp1[0]=nums[o] �� ����....
		int max_value = dp1[0];
		
		for(int i=1 ; i<nums.length ; i++) {
			//dp[i]�� ���� ������ ���� ���� ���ؼ� ����.
			dp1[i]=dp1[i-1]+nums[i];
			
			// ���࿡ ���Ѱ��� nums[i] ���� ������ nums[i] �� �ʱ�ȭ
			if(dp1[i]<=nums[i]) {
				dp1[i]=nums[i];
				
			}
			// ū���� max value �� ����...
			max_value=Math.max(max_value, dp1[i]);
		}


        
        
		
		
		
		
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(dp1));
		
		System.out.println(max_value);
		
		

		
		
		

	}
	


}
