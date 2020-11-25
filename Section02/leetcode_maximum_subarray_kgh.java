package Study.Section02;

import java.util.Arrays;

/*
#1 풀이 시간
30분

#2 접근방식
- 값 나열시 하나의 규칙을 처음에 찾아보면서 dp를 사용하면 되겠다 생각하였습니다.
- 완전탐색의 경우 2중 포문을 사용하여 모든 경우 탐색하였는데 O(N)의 경우 시간초과
- DP의 경우 작은부분을 점차 늘려가면서 부분집합의 최댓값을 찾아주면 최종적으로 dp[length-1]에는 최적화된 값을 찾을 수 있습니다.(Bottom up)

#3 시간복잡도
완전탐색 O(N^2), DP(O(N))
 */
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
