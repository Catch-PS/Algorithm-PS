package 스터디.스터디_SNU.Section12;

import java.util.HashSet;
import java.util.Set;
/**
 * 1. 문제풀이시간: 25분
 * 2. 컴퓨팅사고
 * (1) 현재 몇번째 사람인지 (i / n) + 1
 * (2) 현재 몇번째 차례인지 (i % n) + 1
 * 해당 조건을 잘 찾아내면 쉽게 풀리는 문제이다. 차례구할때 순간 헷갈려서 삽질을 했따.
 * 3. 컴퓨팅 사고
 * O(N)
 */
public class programmers_영어끝말잇기_kgh {
    public static void main(String[] args) {
        solution(3, new String[]{"tank", "kick", "know", "wheel","land", "dream", "mother", "robot", "tank"});
    }
    static int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Set<String> s = new HashSet<>();
        s.add(words[0]);
        for(int i=1; i<words.length; i++){
            char currWord = words[i-1].charAt(words[i-1].length()-1);
            char nextWord = words[i].charAt(0);
            if(currWord == nextWord) {
                // 이미존재한 단어로 끝말잇기를 진행할 수 없습니다.
                if (s.contains(words[i])) {
                    answer[0] = (i / n) + 1;
                    answer[1] = (i % n) + 1;
                    System.out.println(answer[0] + " " + answer[1]);
                    return answer;
                } else {
                    s.add(words[i]);
                }
            }else {
                answer[0] = (i / n) + 1;
                answer[1] = (i % n) + 1;
                return answer;
            }
        }
        return answer;
    }
}
