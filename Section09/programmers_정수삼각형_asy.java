/*
 * 1. 풀이시간 : 1시간 초과
 * 2. 풀이방법
 *    Bottom-Up의 dp 방식으로 품
 *    1. 새로운 배열에 가장자리부터 합을 구해서 저장해놓음
 *    2. 중간에 있는 값들은 현재 위치에 올 수 있는 값 2개 중 더 큰 것을 골라서 더함
 *    3. 복사한 배열의 마지막 행에 있는 값들 중 가장 큰 값을 출력
 * 3. 예상 시간복잡도 : O(n^2)
 */
class Solution {
    public int solution(int[][] triangle) {
        int[][] copy = new int[triangle.length][triangle.length];
        
        copy[0][0] = triangle[0][0];
        // 가장자리의 값들을 먼저 더함
        for(int i=1; i<triangle.length; i++){
            copy[i][0] = copy[i-1][0] + triangle[i][0];
            copy[i][i] = copy[i-1][i-1] + triangle[i][i];
        }
        
        // 전의 두 수를 비교 중 큰 것과 현재 값을 더함(중간에 있는 값들)
        for(int i=2; i<triangle.length; i++){
            for(int j=1; j<i; j++){
                copy[i][j] = Math.max(copy[i-1][j-1], copy[i-1][j]) + triangle[i][j];
            }
        }
        
        int maxVal = copy[copy.length-1][0];
        // 제일 아래에 있는 값들 중 최대값 찾기
        for(int i=1; i<triangle.length; i++){
            int targetVal = copy[copy.length-1][i];
            if(targetVal > maxVal){
                maxVal = targetVal;
            }
        }
        
        return maxVal;
    }
}