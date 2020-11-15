package Study.Section02;

import java.util.Arrays;
public class leetcode_maximum_subarray_kgh {

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        maxSubArrayBruteforce(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        maxSubArrayBruteforce(new int[]{-2147483647});
    }
    static int maxSubArray(int[] nums) {
        for(int i=1; i<nums.length; i++){
            nums[i] = Math.max(nums[i], nums[i]+ nums[i-1]);
        }
        Arrays.sort(nums);
        return nums[nums.length-1];
    }
    static int maxSubArrayBruteforce(int[] nums) {
        int max = -2147483647;      // 기존에 -1 넣었는데 입력이 -2147483647 예외 처리해주기 위해서 초기화
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];

                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
}
