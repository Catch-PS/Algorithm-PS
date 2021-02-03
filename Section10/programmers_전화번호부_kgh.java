package 스터디.스터디_SNU.Section10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.문제풀이시간:25분
 * 2.컴퓨팅사고
 * set을 활용한 접두사 찾기 문제
 * sort를 진행한이유는 효율성에서 실패가 나왔기때문에 가장 문자열이 작은순서대로 정렬하여주었습니다.
 * 3. 시간복잡도
 * O(N^2)
 */
public class programmers_전화번호부_kgh {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"234234119", "111", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }
    static boolean solution(String[] phone_book) {
        Set<String> hs = new HashSet<>();
        Arrays.sort(phone_book);
        hs.add(phone_book[0]);
        for(int i=1; i<phone_book.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<phone_book[i].length(); j++){
                sb.append(phone_book[i].charAt(j));
                if(hs.contains(sb.toString())){
                    return false;
                }
            }
        }
        return true;
    }
}
