package 스터디.스터디_SNU.Section18;

import java.util.Arrays;

/**
 * 1. 문제풀이시간: 5분
 * 2. 컴퓨팅사고
 * (1) 정렬후 len - k의 Index에 해당하는 배열값을 리턴시켜줍니다.
 */
public class leetcode_Kth_Largest_Element_in_an_Array_kgh {
    public static void main(String[] args) {
//        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }
    static int findKthLargest(int[] nums, int k) {

        int numsSize = nums.length;
        Arrays.sort(nums);
        System.out.println(nums[numsSize-k]);

        return 0;
    }
}
