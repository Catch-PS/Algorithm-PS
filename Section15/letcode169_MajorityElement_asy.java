package easy;

import java.util.HashMap;
/*
 * 1. 풀이시간 : 
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * - nums 배열을 돌면서 나온 숫자를 key로 map에 삽입 -> key : 나온 숫자, value : 해당 숫자가 나온 횟수
 * - key가 숫자이므로 해당 숫자를 key로 숫자가 나온 횟수를 뽑아옴
 * - 그 횟수를 비교하며 가장 큰 값을 얻을 수 있고, 가장 큰 값의 index 값도 얻을 수 있음 -> index 값이 
 */
public class letcode169_MajorityElement_Sol {
	
	public static void main(String[] args) {
		int[] nums = {3,3,4};
//		int[] nums = {2,2,1,1,1,2,2};
		int halfCnt = nums.length/2;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// 전체 돌면서 map에 넣어줌
		for(int i : nums) {
			// map에 해당 숫자가 있으면 -> 가져와서 1을 더하고 삽입
			// map에 해당 숫자가 없으면 -> 디폴트값으로 설정한 0을 삽입
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int maxNum = Integer.MIN_VALUE;
		int resultIdx = 0;
		
		for(int i : nums) {
			if(map.get(i) > maxNum) {
				if(map.get(i) >= halfCnt)
				{
					maxNum = map.get(i);
					resultIdx = i;
				}
			}
		}
		
		System.out.println(resultIdx);
	}
}
