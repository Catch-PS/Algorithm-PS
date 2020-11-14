/*
    풀이 시간: 5분
    풀이 방법: for문을 돌면서 i번째에 해당하는 수와 연속해서 더해져 온 수 중 큰 수를 채택하여 계속 반복, 
              그리고 기존에 max값으로 저장된 값과 비교하여 더 큰 수를 채택
    시간 복잡도: 라이브러리 사용 제외하고 for문 하나이므로 O(n) 예상
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            result = Math.max(result, sum);
        }
        
        return result;
    }
}
