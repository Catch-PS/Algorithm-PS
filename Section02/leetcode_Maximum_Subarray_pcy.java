package week2;

import java.util.Arrays;



/*
 * #1 소요시간 대략 4시간 30분.
 * 
 * #2-1 첫 번째 에 세운 식은 
 * 앞에서 부터 차례대로 더한 값을 dp1 에 저장
 * 뒤에서 부터 차례대로 더한 값을 dp2 에 저장
 * 후에 각각의 최대값의 idx 를 가져오는 형식으로 풀이 but 오류....
 * 
 * #2-2 greedy 알고리즘 체택 각 상태마다 가장 최적의 해만 구함.
 * 각 상태에서 최대 값을 계속 저장후 가장 큰값을 가져옴.
 * 
 * 
 * #3 시간복잡도
 * O(N)
 */


public class leetcode_Maximum_Subarray_pcy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		// 값을 더한 dp1 배열을 생성.
		int[] dp1 = new int[nums.length];
		
		
		
		// 가장 처음값을 더할게 없으므로 nums[0]로 설정...
		dp1[0]=nums[0];
		
		// 첫 최대값은 dp1[0]=nums[o] 로 설정....
		int max_value = dp1[0];
		
		for(int i=1 ; i<nums.length ; i++) {
			//dp[i]의 값은 전값과 현재 값을 더해서 구함.
			dp1[i]=dp1[i-1]+nums[i];
			
			// 만약에 더한값이 nums[i] 보다 작으면 nums[i] 로 초기화
			if(dp1[i]<=nums[i]) {
				dp1[i]=nums[i];
				
			}
			// 큰값을 max value 에 저장...
			max_value=Math.max(max_value, dp1[i]);
		}


        
        
		
		
		
		
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(dp1));
		
		System.out.println(max_value);
		
		

		
		
		

	}
	


}
