package Study;
import java.util.*;

/*
소요시간 30분
 */

/* 실제풀이 */
public class leetcode_ValidParentheses_kgh {
    public static void main(String[] args) {
        System.out.println(isValidStack("([)]"));
        //System.out.println(isValidHash("((()))"));
    }
    /* Stack으로 푸는 방식 */
    static boolean isValidStack(String s) {

        Stack<Character> s1 = new Stack<>();
        boolean tf = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('|| s.charAt(i) == '[' || s.charAt(i) == '{'){
                s1.push(s.charAt(i));
            }

            if(s.charAt(i) == ')'){
                if(!s1.isEmpty() && s1.peek() == '('){
                    s1.pop();
                }else {
                    tf = false;
                    break;
                }
            }else if(s.charAt(i) == '}'){
                if(!s1.isEmpty() && s1.peek() == '{'){
                    s1.pop();
                }else {
                    tf = false;
                    break;
                }

            }else if(s.charAt(i) == ']'){
                if(!s1.isEmpty() && s1.peek() == '['){
                    s1.pop();
                }else {
                    tf = false;
                    break;
                }

            }
        }
        // '[' 한문자 오는 경우 처리 해주기
        if(s1.size() != 0){
            tf = false;
        }

        return tf;
    }
}