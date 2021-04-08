/*
    풀이 시간: 풀이 시간 초과
    예상 시간복잡도: O(n^2)
    풀이 방법: 한 자리씩 살펴보면서 숫자, 괄호([, ]), 알파벳을 따로 처리해 주었습니다. 숫자를 담을 스택 num과 String을 담을 스택 두 개를 사용해서
            [ 기호일 때 숫자와 여태까지 합쳐진 글자를 각각의 스택에 넣고 초기화를 해줍니다. 그런 후에 기호가 아니라면 글자를 계속 더해주고
            ] 기호일 때 두 개의 스택에서 원소를 뽑아 곱해주고 더해줍니다.
 */

public class leetcode_Decode_String_jdh {

    public static String decodeString(String s) {
        String result = "";

        Stack<String> num = new Stack<String>();
        Stack<String> st = new Stack<String>();

        String n = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                int endIdx = i;
                while (endIdx < s.length()) {
                    if (!Character.isDigit(s.charAt(endIdx))) break;
                    endIdx++;
                }

                n = s.substring(i, endIdx);
                i = endIdx - 1;
            }
            else if (s.charAt(i) == '[') {
                st.push(result);
                num.push(n);
                result = "";
                n = "";
            }
            else if(s.charAt(i) == ']'){
                String str = st.pop();
                String tmp2 = String.join("", Collections.nCopies(Integer.parseInt(num.pop()), result));
                result = str + tmp2;
            }
            else {
                result += s.charAt(i);
            }
        }

        return result;
    }

    public static void main(String args[]){
        System.out.println(decodeString("100[leetcode]"));
    }
}
