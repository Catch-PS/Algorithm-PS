package 스터디.스터디_SNU.Section15;

import java.util.*;

/**
 * 1. 문제 풀이 시간: 초과
 * 2. 컴퓨팅 사고
 * (1) 자르는 문자열값을 i값까지 값을 잘라줍니다.
 * (2) 현재 set에 있는값과 비교하여 해당 dp값을 true처리해줍니다.
 * j 값이 0 이거나 dp[j-1]의 값일 경우 해당값을 계속체크하면서 넘어가줍니다.
 * (3) 최종적으로 dp[n-1]의 값에 있는 값을 리턴하면 최종적으로 올바른 문자열을 만들 수 있는지 없는지를 확인할 수 있습니다.
 * 3. 시간복잡도
 * O(N^2)
 *
 * l
 * le
 * e
 * lee
 * ee
 * e
 * leet
 * leetc
 * eetc
 * etc
 * tc
 * c
 * leetco
 * eetco
 * etco
 * tco
 * co
 * o
 * leetcod
 * eetcod
 * etcod
 * tcod
 * cod
 * od
 * d
 * leetcode
 * eetcode
 * etcode
 * tcode
 * code
 */
public class leetcode_wordbreak_kgh {
    public static void main(String[] args) {
//        wordBreak("bb",Arrays.asList(new String[]{"a", "b","bbb","bbbb"}));
        wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code" }));
//        wordBreak("applepenapple",Arrays.asList(new String[]{"apple", "pen" }));
    }
    static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return false;
        }
        boolean[] dp = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);

        for(int i=0; i<s.length(); i++){
            for(int j=0; j<=i; j++){
                String subStr = s.substring(j, i+1);
                System.out.println(subStr);
                // j==0인 경우는 첫번째 부분문자열은 존재하지 않기떄문에
                if(set.contains(subStr) && (j == 0 || dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
