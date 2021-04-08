package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * 1. 풀이시간 : 시간초과
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 조합(dfs)를 사용한 백트래킹
 * candidate < target 이면 temp 리스트에 넣은 뒤 다음 target을 "target - candidate" 해서 계속 호출해줌
 * target = 0 이 되면 temp에 있는 값들의 합이 target 이라는 뜻이므로 result 리스트에 넣어주면서 돌면 됨
 * 
 * candidate[0] 부터 시작하며 candidate[1] 부터 시작할 때는 이전 값인 candidate[0] 값을 볼 필요가 없음
 * 	-> 백트래킹 함수에 index를 같이 넘김
 */
public class letcode_CombinationSum {
	static List<List<Integer>> result;

	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 8;
		
		result = new ArrayList<List<Integer>>();
		for(int i=0; i<candidates.length; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(candidates[i]);
			backtraking(candidates, i, 1, target - candidates[i], temp);
		}
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static void backtraking(int[] candidates, int index, int tempSize, int target, List<Integer> temp) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		
		int leng = candidates.length;
		// 이전값은 볼 필요가 없으므로 인자로 넘어온 index 이후부터 수행
		// candidates에서 뽑은 수(candidate[i]) > 더해야할 남은 수(target) 이면 무시하고 candidate 배열에서 다음 값을 가져옴
		for(int i = index; i<leng; i++) {
			if(candidates[i] <= target) {
				temp.add(candidates[i]);
				backtraking(candidates, i, tempSize+1, target-candidates[i], temp);
				temp.remove(tempSize);	//맨 처음(27 line)에 크기를 1로 넘겼으므로
			}
		}
	}

}
