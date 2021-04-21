package Section18;
/**
 * 풀이 시간 : 5분
 * 시간복잡도 : O(N) - space O(N)
 * 풀이 과정 :
 *   count 의 index 를 숫자로 보고 index의 값을 반복되는 count 수로 놓아
 *   한번도 숫자가 나오지 않았으면 == count[index0 = 0 일 경우 answer 에 담는다.
 *
 *   하지만 이럴경우 O(1) runtime 은 만족하지만 extra space 를 썼으므로
 *   nums에서 직접 관리할 수 있는 방법을 찾아야 하는데
 *   nums 에서 만약 숫자가 나왔을경우 negative 으로 만들어 버리면
 *   nums 공간 하나만으로 숫자가 나왔는지 안나왔는지를 +/- 등호로 구분하여 쉽게 풀 수 있다.
 */

import java.util.LinkedList;
import java.util.List;

public class leetcode_find_all_numbers_disappeared_in_an_array_ps {
  public static List<Integer> findDisappearedNumbers(int[] nums) {
    int[] count = new int[nums.length];
    List<Integer> answer = new LinkedList<>();

    for(int i = 0; i < nums.length; i++) {
      count[nums[i]-1]++;
    }

    for(int i = 0; i < count.length; i++) {
      if(count[i] == 0) {
        answer.add(i+1);
      }
    }
    //Follow up: Could you do it without extra space and in O(n) runtime?
    /**
     * for(int i = 0; i < nums.length; i++) {
     *             int index = Math.abs(nums[i])-1;
     *             if(nums[index] > 0) {
     *                 nums[index] = -nums[index];
     *             }
     *         }
     *
     *         for(int i = 0; i < nums.length; i++) {
     *             if(nums[i] > 0) {
     *                 answer.add(i+1);
     *             }
     *         }
     */

    return answer;
  }

  public static void main(String[] args) {
    int[] nums = {4,3,2,7,8,2,3,1};
    findDisappearedNumbers(nums);
  }

}
