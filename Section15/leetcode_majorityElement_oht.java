package Section15;

import java.util.Arrays;

/**
 * 풀이 시간 : 20분
 *
 * 풀이 방식 : 정렬 뒤 선형탐색을 통해 이전 값을 저장하고 변형이 생길 때마다 값을 기록했습니다.
 *
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(1)
 */
public class leetcode_majorityElement_oht {

  public static void main(String[] args) {

    System.out.println(majorityElement(new int[]{3, 2, 3}));

  }

  public static int majorityElement(int[] nums) {

    Arrays.sort(nums);

    int answer = nums[0];
    int prev = 0;
    int current = 1;

    for (int i = 1; i < nums.length; i++) {

      if (nums[i] != nums[i - 1]) {

        if (current > prev) {

          prev = current;
          answer = nums[i - 1];
        }

        current = 1;
      }
      current++;
    }

    if (current > prev) {
      answer = nums[nums.length - 1];
    }

    return answer;
  }
}
