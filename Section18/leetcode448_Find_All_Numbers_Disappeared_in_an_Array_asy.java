package easy;

import java.util.ArrayList;
import java.util.List;
/*
 * 1. 풀이시간 : 14분
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 	(1) nums 배열의 값을 check 배열의 인덱스로 하여, 존재하면 true
 * 	(2) check 배열을 탐색하며 false인 것들을 answer 리스트에 넣기

 */
public class leetcode448_Find_All_Numbers_Disappeared_in_an_Array {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        List<Integer> answer = new ArrayList<Integer>();
        boolean[] check = new boolean[length+1];
        
        for(int i=0; i<length; i++){
            int idx = nums[i];
            check[idx] = true;
        }
        
        for(int i=1; i<length+1; i++){
            if(!check[i]){
                answer.add(i);
            }
        }
        
        return answer;
    }
}
