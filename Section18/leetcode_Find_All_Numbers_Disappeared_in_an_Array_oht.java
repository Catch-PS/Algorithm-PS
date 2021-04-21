package Section18;

import java.util.ArrayList;
import java.util.List;

/**
 * 풀이 시간 : 15분
 *
 * 풀이 방식 :
 * 1. cmp 배열의 인덱스에 해당하는 값이 등장하면 true로 체크합니다.
 * 2. cmp 배열에 체크되지 않은 변수를 answer 리스트에 담아서 반환합니다.
 *
 * 시간 복잡도 : O(N)
 *
 */
public class leetcode_Find_All_Numbers_Disappeared_in_an_Array_oht {

  public List<Integer> findDisappearedNumbers(int[] nums) {

    List<Integer> answer = new ArrayList<>();
    boolean[] cmp = new boolean[nums.length + 1];


    for (int num : nums) {

      if (num <= nums.length) {
        cmp[num] = true;
      }
    }

    for (int i = 1; i < cmp.length; i++) {

      if (!cmp[i]) {

        answer.add(i);
      }
    }

    return answer;
  }
}
