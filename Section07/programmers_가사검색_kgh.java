package 스터디.스터디_SNU.Section07;

import java.util.*;

/**
 * 1. 풀이시간: 10분(시간초과 3개ㅠㅠ)
 * 2. 컴퓨팅사고
 * (1) 정규표현식을 사용하여 '?' -> '.' 변경하여 모든 매칭되는 문자열을 서칭
 * (2) 매칭되는 문자열을 발견하면 카운팅하여 배열로 반환
 *
 */
public class programmers_가사검색_kgh {
    public static void main(String[] args) {
        solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
    }
    static int[] solution(String[] words, String[] queries) {
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(words);
        for(int i=0; i<queries.length; i++){
            int cnt = 0;
            queries[i] = queries[i].replace("?", ".");
            for (String word : words) if (word.matches(queries[i])) cnt++;
            arr.add(cnt);
        }
        int[] answer = arr.stream().mapToInt(integer -> integer).toArray();
        return answer;
    }
}