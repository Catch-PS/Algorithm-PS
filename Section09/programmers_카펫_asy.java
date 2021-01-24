/*
 * 1. 풀이시간 : 40분
 * 2. 풀이방법
 *      brown + yellow = 전체 블록의 개수
        가운데에 블록이 들어가려면 적어도 width나 height가 모두 3이상이 되어야 함
        따라서 인덱스를 3 이상부터 "brown + yellow"까지 반복하며 height의 길이를 찾음
        구한 width, height의 값으로 "(width - 2) x (height - 2)"를 하여 yellow의 크기와 일치하는지 확인
 * 3. 예상 시간복잡도 : O(N)
 */
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int area = brown + yellow;
        
        //가능한 가로, 세로 길이를 모두 구해서 조건에 부합하는지 확인
        for(int i=3; i<=area; i++){
            //한 변의 길이 기준으로 넓이를 구할때 나누어 떨어지는 경우만 고려
            if(area % i == 0){
                int brwonWidth = i;              //가로
                int brwonHeight = area/brwonWidth;     //세로
                
                int yellowWidth = brwonWidth - 2;
                int yellowHeight = brwonHeight - 2;
                
                //"(width - 2) x (height - 2)" 했을 때 실제 yellow의 크기와 같으면 정답
                if(yellowWidth*yellowHeight == yellow && brwonWidth>=brwonHeight){
                    return new int[]{brwonWidth, brwonHeight};
                }
            }
        }
        
        return answer;
    }
}