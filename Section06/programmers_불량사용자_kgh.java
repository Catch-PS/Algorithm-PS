package 스터디.스터디_SNU.Section06;
import java.util.*;
/**
 * 1. 풀이시간 50분
 * 2. 컴퓨팅사고
 * 정규표현식을 이용하면 매우 쉽게 풀리는 문제이다. 해당 유저 값들에 대한 모든 경우의 수를 DFS 완전탐색을 통하여 가능한 모든 경우의 수를 구한다.
 * 모든 경우의 수 Basement조건은 제제아이디 목록의 개수까지 진행합니다. 정규표현식에서 "."은 어떤 문자 1개를 의미(어떤 값이든 가능하다)
 * 따라서, 하나의 예시 "*" -> 표현식을 -> "."으로 변경하면 fr*d* -> fr.d.x 처럼 변경이 됩니다.
 * 따라서 .으로 표현된 regex Match의 값을 유저의 아이디 값으로 경우의 수를 진행하게 되면 현재 제제 사용자인지 아닌지를 체크할 수 있게됩니다.
 * 해당 유저의 목록들을 하나의 셋의 목록으로 만들어주어 경우의 수가 몇개인지 체크할 수 있습니다.(중복되는 경우가 생길 수 있기때문에)
 *
 * 정규표현식 참고 사이트 https://codechacha.com/ko/java-regex/
 * 3. 시간복잡도 재귀함수..모든 조합의 경우 O(N^2)?
 */
public class programmers_불량사용자_kgh{

    static boolean[] check;
    static HashSet<String> hs;
    public static void main(String[] args) {
        System.out.print(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**"}));
    }
    static int solution(String[] user_id, String[] banned_id) {
        check = new boolean[user_id.length];
        hs = new HashSet<>();
        dfs(user_id, banned_id, 0);
        return hs.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, int idx) {
        // basement
        if(idx == banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<user_id.length; i++){
                if(check[i]){
                    sb.append(i);
                }
            }
            if(!hs.contains(sb.toString())){
                hs.add(sb.toString());
            }
            return;
        }
        for(int i=0; i<user_id.length; i++){
            if(check[i]){
                continue;
            }
            String rex = banned_id[idx].replace("*", ".");
            if(user_id[i].matches(rex)){
                check[i] = true;
                dfs(user_id, banned_id, idx+1);
                check[i] = false;
            }
        }
    }
}
