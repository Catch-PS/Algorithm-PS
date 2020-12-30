package 스터디.스터디_SNU.Section05;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. 풀이시간: 40분
 * 2. 컴퓨팅 사고
 * #1 올바른 끝말잇기를 진행하기 위해서는 두 가지가 공통으로 성립되어야 합니다.
 * (1) 문자열의 끝 문자와 그 다음에오는 문자열의 첫 문자가 같아야 합니다.
 * (2) set을 사용하여 포함이 된 문자열인지 체크를 해서 포함된 문자열이 아닐경우에만 끝말잇기가 진행이 가능합니다.
 * 해당 두 사항이 만족하는 경우 중복을 체크해주기 위해 set에 값을 add시켜줍니다.
 *
 * #2 몇번째 사람인지 값을 갱신
 * (i+1) % n이 0일 경우는 현재 끝말잇기를 진행하는 사람의 개수가 되어야 하고, 그게 아닐 경우 (i+1) % n) 값을 갱신시켜줍니다.
 * +1을 처리해준 이유는 현재 기준이 1번 부터 진행되기 때문입니다.
 * 예) 2 % 3 = 2, 3 % 3 = 0 -> 3으로 변환, 4 % 3 = 1 ....식으로 진행됩니다.
 *
 * #3 몇번째 순서인지 값을 갱신
 * 현재 사람의 몇번째 순서로 진행되는지 체크해주기 위해서는 (i / n) + 1 다음과 같은식이 성립해야합니다. +1 처리 해준 이유도 위와 같습니다.
 *
 * 기존 풀이에서 90% 에서 정답률이 나왔는데 반례 17,19번 케이스에서 처리를 못해주게 되었습니다.
 * 기존에 값을 갱신하는 부분을 if문 안에서 처리해버려서 거치지 못한 케이스를 발견하여서 해결하였습니다.
 * Test Case17, 19 반례: N=2, {"land", "dream", "mom", "mom", "ror"}
 *
 * 3. 시간복잡도
 * N = words의 길이이므로 O(N)으로 처리가 가능합니다.
 */
public class programmers_영어_끝말잇기_kgh {
    public static void main(String[] args) {
        solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
        solution(4, new String[]{"a","aba","aba","a"});

        // 반례 test case 17, 19
        solution(2, new String[]{"land", "dream", "mom", "mom", "ror"});
        solution(2, new String[]{"land","dream","mom","mom"});
    }
    static int[] solution(int n, String[] words) {
        Set<String> s = new HashSet<>();
        s.add(words[0]);
        String start = words[0].substring(words[0].length()-1);
        int[] answer = {0,0};
        int currPeople = 1;
        int currOrder = 1;
        for(int i=1; i<words.length; i++){
            // 마지막 글자를 가져옴
            String end = Character.toString(words[i].charAt(0));
            // 현재 몇번째 사람인지
            currPeople = (((i+1) % n == 0) ? n : ((i+1) % n));
            // 현재 몇번째 순서인지
            currOrder = (i / n) + 1;

            // 나온 문자열이 아니고 끝점과 시작점 문자가 같을 경우
            if(!s.contains(words[i]) && start.equals(end)){
                s.add(words[i]);
            } else {
                answer[0] = currPeople;
                answer[1] = currOrder;
                break;
            }
            start = words[i].substring(words[i].length()-1);
        }
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
}
