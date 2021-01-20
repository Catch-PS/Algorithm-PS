/*
 * 1. 풀이시간 : 1시간 초과
 * 2. 풀이방법
 *      왼쪽 기준으로 가장 높은 높이를 저장하는 배열, 오른쪽 기준으로 가장 높은 높이를 저장하는 배열을 둠
        해당 위치에서 넣을 수 있는 물의 양은 "(왼쪽 기준 가장 높은 높이의 값, 오른쪽 기준 가장 높은 높이의 값의 최소값) - 현재 높이"
        heights =                                       {0,1,0,2,1,0,1,3,2,1,2,1}
        왼쪽 기준 가장 높은 높이를 저장하는 배열 =       {0,1,1,2,2,2,2,3,3,3,3,3}
        오른쪽 기준 가장 높은 높이를 저장하는 배열 =     {3,3,3,3,3,3,3,3,2,2,2,1}
 * 3. 예상 시간복잡도 : O(n)
 */
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        
        int[] leftMaxArray = new int[length];   //왼쪽 기준 가장 높은 고도를 저장하는 배열
        int[] rightMaxArray = new int[length];  //오른쪽 기준 가장 높은 고도를 저장하는 배열
        
        int leftTmp = 0, rightTmp = 0;
        for(int i=0; i<length; i++){
            //왼쪽 기준 가장 높은 고도를 저장하는 배열 안에 값 넣기
            leftTmp = Math.max(leftTmp, height[i]);     //"현재 인덱스의 고도"와 "왼쪽 기준 지금까지의 최대고도를 비교"해서 큰 값을 저장
            leftMaxArray[i] = leftTmp;
            
            //오른쪽 기준 가장 높은 고도를 저장하는 배열 안에 값 넣기
            rightTmp = Math.max(rightTmp, height[length-1-i]);  //"현재 인덱스의 고도"와 "오른쪽 기준 지금까지의 최대고도를 비교"해서 큰 값을 저장
            rightMaxArray[i] = rightTmp;
        }
        
        int result = 0;
        int leftMax = 0, rightMax = 0;
        int heightVal = 0;
        //인덱스마다 채울수 있는 물의 양을 구함
        for(int i=0; i<length; i++){
            leftMax = leftMaxArray[i];
            rightMax = rightMaxArray[i];
            heightVal = height[i];
            int betweenMin = Math.min(leftMax, rightMax);
            result += (betweenMin - heightVal);
        }
        
        return result;
    }
}