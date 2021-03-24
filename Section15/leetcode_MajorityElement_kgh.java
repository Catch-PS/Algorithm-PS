package 스터디.스터디_SNU.Section15;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제풀이시간: 15분
 * 2. 컴퓨팅사고
 * (1) map을 이용하여 해당되는 요소들의 개수를 증감시킨다.
 * (2) 증감시키고 난후 num의 길이 / 2의 길이를 넘어가게 된다면 해당되는 키값을 반환시킨다.
 * 3. 시간복잡도
 * O(N) -> O(1)로 처리하라고 하였는데, 어떻게..?
 */
public class leetcode_MajorityElement_kgh {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{3,3,4}));
    }
    static int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> m = new HashMap<>();
        int answer = -1;
        for(int i=0; i<nums.length; i++){
            int cnt = m.compute(nums[i], (k,v) -> v == null ? 1 : v+1);
            System.out.println("cnt = " + cnt);
            // more than n/2 times
            if(cnt > n){
                answer = nums[i];
            }
        }
        return answer;
    }
}
