package 스터디.스터디_SNU.Section18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1. 문제풀이시간: 5분
 * 2. 컴퓨팅 사고
 * (1) set을 활용하여 중복되는 값을 걸러준다.
 * (2) 1-range의 범위중 존재하지 않는값을 넣어주고 리턴시켜준다. 여기서 Range는 nums의 길이를 뜻한다.
 * 3. 시간복잡도
 * O(N)
 */
public class leetcode_findallnumbersdisappearedinanarray_kgh {
    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        findDisappearedNumbers(new int[]{1,1});
    }
    static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> answer = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        int range = nums.length;
        for(int i=0; i<nums.length; i++){
            s.add(nums[i]);
        }

        for(int i=1; i<=range; i++){
            if(!s.contains(i)){
                answer.add(i);
            }
        }
        for (Integer value : answer) {
            System.out.println("value = " + value);
        }



        return new ArrayList<>();
    }
}
