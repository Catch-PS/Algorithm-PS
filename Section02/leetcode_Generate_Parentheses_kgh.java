package Study.Section02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class leetcode_Generate_Parentheses_kgh {
    static char[] arr;
    static int[] check;
    static HashSet<String> hs = new HashSet<>();
    static ArrayList<Character> v = new ArrayList<>();
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) {
        generateParenthesis(1);
        //System.out.println(validString("(()())"));
    }

    static List<String> generateParenthesis(int n) {
        arr = new char[n*2];
        check = new int[n*2];
        for(int i=0; i<n*2; i++){
            if(i < n){
                arr[i] = '(';
            }else {
                arr[i] = ')';
            }
        }
        dfs(0, n);
        for(String s : hs){
            answer.add(s);
            System.out.println(s);
        }
        return answer;

    }

    private static void dfs(int cnt, int n) {

        if(cnt == n*2){
            StringBuilder str = new StringBuilder();
            for(int i=0; i<v.size(); i++) {
                str.append(v.get(i));
            }
            if(validString(str.toString())){
                hs.add(str.toString());
            }
            return;
        }

        for(int i=0; i<n*2; i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            v.add(arr[i]);
            dfs(cnt+1, n);
            v.remove(v.size()-1);
            check[i] = 0;
        }
    }

    private static boolean validString(String sb) {
        Stack<Character> s = new Stack();
        boolean tf = false;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '('){
                s.add(sb.charAt(i));
            }
            if(sb.charAt(i) == ')'){
                if(!s.isEmpty() && s.peek() == '('){
                    s.pop();
                    tf = true;
                }else {
                    tf = false;
                    break;
                }
            }
        }
        if(s.size() > 0){
            tf = false;
        }
        return tf;
    }
}
