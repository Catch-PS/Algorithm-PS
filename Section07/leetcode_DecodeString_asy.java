/*
 * 1. 풀이시간 : 1시간 초과
 * 2. 풀이방법 : 반복횟수를 넣는 스택, 반복 문자열을 넣는 스택을 따로 두고 품
                숫자, "[", "]", 문자의 경우를 다 나눠서 처리
                숫자가 들어오면 반복횟수만 계산
                "["가 들어오면 반복횟수를 나중에 사용하기 위해 스택에 넣고, 반복해야할 문자열을 저장
                "]"가 들어오면 반복횟수를 꺼내와서 대괄호 안에 있는 문자열을 반복. 그리고 그 반복한 문자 앞에 스택에서 꺼내온 문자열을 붙이고 다시 횟수만큼 반복
 * 3. 예상 시간복잡도 : O(n)
 */
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();  //반복횟수를 저장하는 스택
        Stack<String> stringStack = new Stack<>();  //문자를 저장하는 스택
        
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        // 문자열의 크기만큼 반복
        for(char c : s.toCharArray()){
            //숫자일 경우
            if('0'<=c && c<='9'){
                count = count * 10 + Integer.parseInt(c+"");
            }
            //"["일 경우
            else if(c=='['){
                countStack.push(count);     //반복횟수를 countStack 스택에 넣음
                stringStack.push(result.toString());    //반복해야할 문자를 stringStack 스택에 넣음
                count = 0;      //반복 횟수를 초기화
                result = new StringBuilder();    //반복 문자를 초기화
            }
            //"]"일 경우
            else if(c==']'){
                StringBuilder temp = new StringBuilder();
                int curCount = countStack.pop();    //반복 횟수를 뽑아옴
                for(int i=0; i<curCount; i++){
                    temp.append(result);
                }
                result = new StringBuilder(stringStack.pop() + temp);   //stringStack에서 가져온 문자열+지금 반복한 문자열
            }
            //문자일 경우
            else{
                result.append(c);
            }
        }
        
        return result.toString();
    }
}