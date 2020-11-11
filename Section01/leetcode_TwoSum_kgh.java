package Study;

// comment: 1주차 알고리즘 leetcode 1.Two Sum 문제
// comment: https://leetcode.com/problems/two-sum/

/*
풀이시간: 10분
 */
public class leetcode_TwoSum_kgh {
        public static void main(String[] args) {
            solution(new int[]{2, 7, 11, 15}, 9);
        }
        static void solution(int[] nums, int target) {
        int[] answer = {0,0};
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i+1; j<nums.length; j++){
                sum = nums[i] + nums[j];
                if(sum == target){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        System.out.println(answer[0] +""+ answer[1]);
    }
}
