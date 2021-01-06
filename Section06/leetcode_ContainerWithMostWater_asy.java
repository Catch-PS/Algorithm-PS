/*
 * 1. 풀이시간 : 43분
 * 2. 풀이방법 : 모든 케이스를 나누는 완전탐색으로 풀었습니다.
                기둥이 2개 있을 때, 기둥이 2개 이상 있을 때를 큰 범주로 봤습니다.
                첫번째 for문으로 기준이 되는 기둥을 잡고, 두번째 for문으로 비교 대상 기둥을 잡았습니다.
                "기준이 되는 기둥 >= 비교 대상 기둥", "기준이 되는 기둥 < 비교 대상 기둥" 케이스에 따라 넓이를 각각 구해서
                max값 보다 클 경우 max값을 최신화하는 방법을 사용했습니다.
 * 3. 예상 시간복잡도 : O(n^2)
 */
class Solution {
    public int maxArea(int[] height) {
        int num = height.length;
        int area = 0;
        int max = 0;
        
        for(int i=0; i<num; i++){
            for(int j=i+1; j<num; j++){
                //기둥의 개수가 2개밖에 없을 경우
                if(num==2){
                    //기둥의 개수 2개 중 하나가 0이면
                    if(height[i]==0 || height[j]==0)
                        area = 0;
                    //둘 다 0이 아닐 경우
                    else if(height[i]!=0 || height[j]!=0){
                        //왼쪽 기둥 길이 < 오른쪽 기둥 길이
                        if(height[i] < height[j])
                            area = (height[j] - height[i]) * 1;
                        //왼쪽 기둥 길이 > 오른쪽 기둥 길이
                        else if(height[i] > height[j])
                            area = (height[i] - height[j]) * 1;
                        //왼쪽 기둥 길이 = 오른쪽 기둥 길이
                        else
                            area = height[j] * 1;
                    }
                }
                //기둥의 개수가 2개 이상인 경우
                else{
                    //왼쪽 기둥 길이 >= 오른쪽 기둥 길이
                    if(height[i]>=height[j])
                        area = (j-i) * height[j];   // 넓이 = 가로 * 세로
                    //왼쪽 기둥 길이 < 오른쪽 기둥 길이
                    else if(height[i]<height[j])
                        area = (j-i) * height[i];
                }
                
                //가장 큰 넓이 찾기
                if(area > max)
                        max = area;
            }
        }
        
        return max;
    }
}