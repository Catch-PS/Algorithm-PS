package Section18;

import java.util.Arrays;


/**
 * 풀이 시간 : 5분
 *
 * 풀이 방식 : 배열을 sorting 하고, k번째 수를 찾습니다.
 * (코드를 간단히 하기 위해 오름차순 상태에서 k번째 수를 찾았습니다.)
 *
 * 시간 복잡도 : O(nlogn)
 */
public class leetcode_Kth_Largest_Element_in_an_Array_oht {

  public int findKthLargest(int[] nums, int k) {

    Arrays.sort(nums);

    return nums[nums.length - k];
  }
}
