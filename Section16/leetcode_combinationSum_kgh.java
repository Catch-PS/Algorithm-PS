package 스터디.스터디_SNU.Section16;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 풀이시간: 20분
 * 2. 컴퓨팅 사고
 * 중복이 허용되고, 갯수의 제한도 없는 조합을 구하는 문제입니다.
 *
 * (1) 종료조건은 sum > target을 넘어가게되면 조건에 위배되므로 종료
 * (2) sum == target과 같다는것은 해당되는 sum값을 찾은것이므로 정답을 리스트에 넣어주고 종료
 * (3) 하나의 idx값을 선언하여 현재까지 선택된 위치에서부터 다시 시작하도록 설정 idx = i
 *
 * 3. 시간복잡도
 * O(DFS)
 */
public class leetcode_combinationSum_kgh {
    static List<List<Integer>> answer;
    static List<Integer> arrList;
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5}, 8);
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        arrList = new ArrayList<>();
        dfs(candidates, target, 0, 0);
        for (List<Integer> integers : answer) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
        return answer;
    }

    private static void dfs(int[] candidates, int target, int sum, int idx) {
        if(sum > target){
            return;
        }
        if(sum == target){
            answer.add(new ArrayList(arrList));
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            arrList.add(candidates[i]);
            dfs(candidates,target,sum+candidates[i], i);
            arrList.remove(arrList.size()-1);
        }
    }
}
