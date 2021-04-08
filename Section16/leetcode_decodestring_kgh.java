package 스터디.스터디_SNU.Section16;

/**
 * 1. 문제풀이시간: 초과
 * 2. 컴퓨팅 사고
 *
 * (1) 모든 디코드 문자열값을 s의 길이 범위에 만족할때 while문을 진행합니다.
 * (2) 현재 문자가 숫자일 경우 value값을 업데이트 시켜줍니다. 단 자리수는 k가 양의 정수이기 때문에 2자리이상도 가능하나는 것입니다. 2자리이상의 값도 구해주기위해서 (value * 10 + c-‘0’)식을 통해 문자의 값들을 하나씩 정수로 구해주게 됩니다.
 * (3) 문자가 '['일 경우
 * 재귀 함수를 호출하여 ']'를 만날때 까지 진행해줍니다. 즉, ‘[’ ‘]’ 의 값사이에 존재하는 값을 찾아서 반환시켜준다음 괄호앞에 존재하는 숫자의 개수 곱의수만큼을 추가하면서 진행을 합니다.
 * 테스트케이스 예시
 * 3[a]2[bc] -> return ‘aaa’ -> aaa2[bc] -> ‘bcbc’ return -> aaabcbc 의 형태로 값을 반환시킬 수 있게 됩니다.
 *
 * 릿코드 자체에서 주어진 함수를 dfs를 돌리니까 memory limit exceeded가 발생하였습니다.
 * 따라서 하나의 함수를 선언하여 dfs를 수행시 해당 에러를 피할 수 있었습니다.
 *
 * 3. 시간복잡도
 * O(DFS)
 *
 */
public class leetcode_decodestring_kgh {
    static int idx = 0;
    public static void main(String[] args) {
//        decodeString("3a2bc");
//        decodeString("3[a]2[bc]");
        System.out.println(decodeString("3[a2[c]]"));
    }
    static String decodeString(String s) {
        idx = 0;
        return dfs(s);
    }

    private static String dfs(String s) {
        StringBuilder sb = new StringBuilder();
        int value = 0;
        while(idx < s.length()){
            char c = s.charAt(idx++);
            // 숫자 일 경우
            if(Character.isDigit(c)){
                // 32[]일 경우
                value = (value * 10) + (c -'0');
            }else if(c == '['){
                String subStr = dfs(s);
                for (int i = 0; i < value; i++) {
                    sb.append(subStr);
                }
                value = 0;
            }else if(c == ']'){
                break;
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
