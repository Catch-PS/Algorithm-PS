package 스터디.스터디_SNU.Section07;
import java.util.ArrayList;
import java.util.List;
/**
 * 1. 풀이시간: 40분
 * 2. 컴퓨팅 사고
 * 패드에서 누를 수 있는 모든 번호의 패드리스트를 하나 생성시킵니다.
 * 해당 주어진 패드의 정보를 가지고 DFS를 수행합니다. 예를 들어 23이 들어왔다면
 * 2->3번을 누를시에 갈수 있는 모든 경우를 찾아줍니다.
 * 예를 들면 abc / def가 있다고 가정할때
 * a -> d, a -> e, a -> f
 * b -> d, b -> e, b -> f
 * c -> d, c -> e, c -> f
 * 의 형식으로 방문하고 체크합니다.
 * DFS의 Basement조건은 digits 길이만큼 선택될 수 있기때문에 해당 조건일때 해당 값까지 쌓인 문자열을 answer 리스트에 넣어주고 DFS를 수행하던것을 종료시킵니다.
 *
 * 3. 시간복잡도 재귀?
 *
 */
public class leetcode_letter_combinations_of_a_phone_number_kgh {
    static String[] padList = {"abc","def","ghi","jki","mno","pqrs","tuv","wxyz"};
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) {
        letterCombinations("23");
    }
    static void letterCombinations(String digits) {
        if(digits.length() == 0){
            System.out.println(answer);
        }
        dfs(digits,0, "");
        answer.forEach(v-> System.out.println(v));
    }
    private static void dfs(String digits, int cnt, String str) {
        if(cnt == digits.length()){
            answer.add(str);
            return;
        }
        String padArr = padList[(digits.charAt(cnt)-'0')-2];
        System.out.println(padArr);
        for(char c : padArr.toCharArray()){
            System.out.println("dfs("+digits+","+(cnt+1)+","+(str+c)+")");
            dfs(digits, cnt+1,str+c);
        }
    }
}