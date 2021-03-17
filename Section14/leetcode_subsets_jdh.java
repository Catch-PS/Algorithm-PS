/*
  풀이 시간: 10분
  시간 복잡도: ..?
  풀이 방법: DFS로 조합 생성
*/

class Solution {
    public static List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        
        result = new LinkedList<>();
        dfs(0, nums, new LinkedList<>());
        
        return result;
    }

    private void dfs(int idx, int[] nums, List<Integer> list) {
        result.add(list);
        
        for (int i = idx; i < nums.length; i++) {
            List<Integer> tmp = new LinkedList<>(list);
            tmp.add(nums[i]);
            dfs(i + 1, nums, tmp);
        }
    }
}
