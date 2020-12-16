package 스터디_SNU.Section03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* 연속되는 문자열 찾기
1. 풀이 시간 체크: 25분
2. 컴퓨팅사고:
재귀함수를 통해서 만들수 있는 (, ) 의 조합의 경우의 수를 모두 구해줍니다. 그리고 basement 조건은 n*2의 만큼까지 진행하여 올바른 괄호인지를 validString()함수를 이용하여 처리합니다.
3. 자신이 생각하는 시간복잡도
validString함수 - O(N), 재귀함수 O(N*2 + N*2) 두번호출하므로 (, ) => 즉, 시간복잡도 O(N)?
*/

public class leetcode_Generate_Parentheses_recursive_kgh {
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) {
        generateParenthesis(1);
    }
    static List<String> generateParenthesis(int n) {

        dfs(0, n, "");

        answer.forEach(value ->{
            System.out.println(value);
        });

        return answer;
    }
    private static void dfs(int cnt, int n, String str) {
        if(cnt == n*2){
            if(validString(str)){
                answer.add(str);
            }
            return;
        }
        dfs(cnt+1, n, str+"(");
        dfs(cnt+1, n, str+")");
    }

    private static boolean validString(String str) {
        Stack<Character> stack = new Stack<>();
        boolean tf = true;
        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) == '('){
                stack.add(str.charAt(i));
            }
            if(str.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    tf = true;
                }else {
                    tf = false;
                    break;
                }
            }
        }
        if(stack.size() > 0){
            tf = false;
        }
        return tf;
    }
}
