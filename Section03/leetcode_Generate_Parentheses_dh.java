/*
    풀이 시간: 20분
    예상 시간복잡도:
    풀이 방법: 브루트포스 방식으로 접근
            순열을 통해서 가능한 케이스들을 구한 다음, 스택을 이용해서 만들어진 String이 제대로 된 괄호열인지 확인
*/
public class leetcode_Generate_Parentheses_dh {
    public static List<String> result;
    public static Stack<Character> st;
    public static int end;

    public static List<String> generateParenthesis(int n) {
        st = new Stack<Character>();
        result = new LinkedList<String>();
        end = n * 2;
        make("(", 1);

        return result;
    }

    public static void make(String str, int size){
        if(size == end){
            char arr[] = str.toCharArray();

            st.clear();
            for(int i = 0; i < arr.length; i++){
                char ch = arr[i];

                if(!st.empty()){
                    char open = st.peek();

                    if(open == '(' && ch == ')') {
                        st.pop();
                    } else {
                        st.push(ch);
                    }
                } else st.push(ch);
            }

            if(st.size() == 0) result.add(str);
            return;
        }

        make(str + "(", size + 1);
        make(str + ")", size + 1);
    }

    public static void main(String args[]){
        List<String> result = generateParenthesis(3);

        for(String str : result){
            System.out.println(str);
        }
    }
}
