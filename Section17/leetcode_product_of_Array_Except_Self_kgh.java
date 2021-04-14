package 스터디.스터디_SNU.Section17;

/**
 * 1. 문제풀이 시간: 초과
 * 2. 컴퓨팅 사고
 * (1) 임시의 곱셈의 결과를 두방향으로 저장하고 sum의 값을 갱신해나갑니다.
 * 이렇게 진행하다보면 Result에는 자기 자신을 제외한 값의 곱을 구해나갈 수 있습니다.
 * 3. 시간복잡도
 * O(N)
 * 다른 경우로 O(N^2)으로 풀었는 경우에 시간초과
 */
public class leetcode_product_of_Array_Except_Self_kgh {
    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(sum);
            result[i] = sum;
            sum *= nums[i];
        }
        sum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(sum);
            result[i] *= sum;
            sum *= nums[i];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println("result[i] = " + result[i]);
        }
        return result;
    }
    /*
    시간초과풀이
    class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int sum = 1;
            if(i != 0){
                sum = nums[0];
            }
            for(int j=1; j<nums.length; j++){
                if(i == j) continue;
                sum *= nums[j];
            }
            answer[i] = sum;
        }
        return answer;
    }
}
     */
}
