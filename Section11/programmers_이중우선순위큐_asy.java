import java.util.*;
/*
 * 1. 풀이시간 : 30분
 * 2. 풀이방법
        - "I 숫자"가 왔을 경우, replace 사요해서 "I "를 제거하고 숫자만 list에 넣음.
        숫자를 넣을 때마다 list를 오름차순 정렬해줌.(이후 최댓값, 최솟값을 삭제하기 편리하게 하기 위해)
        - "D 1"이 오면 list의 가장 마지막에 있는 값을 삭제
        - "D -1"이 오면 list의 가장 앞에 있는 값을 삭제
 * 3. 예상 시간복잡도 : O(n)
 */
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        String MAXMINUS_DELETE = "D 1";
        String MINMINUS_DELETE = "D -1";
        String PREFIX_NUMBER = "I ";
        
        //값을 넣을 list 생성
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<operations.length; i++){
            if(operations[i].contains(PREFIX_NUMBER)){
                //"I 7"에서 "I "를 제거하고 7만 남김
                String str = operations[i].replace(PREFIX_NUMBER,"");
                //String형의 숫자를 int형으로 변환
                int num = Integer.parseInt(str);
                list.add(num);
                //숫자를 list에 넣을때마다 오름차순 정렬 실행
                Collections.sort(list);
            } else if(!list.isEmpty() && operations[i].contains(MAXMINUS_DELETE)){
                list.remove(list.size()-1); //리스트의 가장 마지막 값을 삭제
            } else if(!list.isEmpty() && operations[i].contains(MINMINUS_DELETE)){
                list.remove(0); //리스트의 첫번째 값을 삭제
            }
        }
        
        if(list.isEmpty()){
            answer = new int[] {0, 0};
        } else {
            answer = new int[] {list.get(list.size()-1), list.get(0)};
        }
        
        return answer;
    }
}