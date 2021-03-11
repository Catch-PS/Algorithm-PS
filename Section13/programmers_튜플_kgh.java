package 스터디.스터디_SNU.Section13;

import java.util.*;

/**
 * 1. 문제풀이시간: 50분
 * 2. 컴퓨팅사고
 * (1) 괄호안에 있는 문자들을 하나의 리스트에 담습니다. '{' 나왔을시에 '}'가 나올때까지 값을 더해주면서넣어줍니다.
 * (2) 문자열길이가 더 작은순으로 정렬(작은순서대로 n개의 요소 튜플)
 * (3) Set을 사용하여 나온값을 체크(포함되어있지 않는 경우)
 *
 * 3. 시간복잡도
 * O(N^2)
 */

public class programmers_튜플_kgh {
    public static void main(String[] args) {
        //solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }
    static List<Integer> solution(String s){
        Set<Integer> hs = new HashSet<>();
        List<String> arrList = new ArrayList<>();

        for(int i=1; i<s.length()-1; i++){
            String tmpStr = "";
            if(s.charAt(i) == '{'){
                i++;
                while(s.charAt(i) != '}'){
                    tmpStr += s.charAt(i);
                    i++;
                }
                arrList.add(tmpStr);
            }
        }
        for (String s1 : arrList) {
            System.out.println("s1 = " + s1);
        }
        // 길이가 작은순으로 정렬
        arrList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String s1 : arrList) {
            System.out.println("s1 = " + s1);
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<arrList.size(); i++){
            String[] tmp = arrList.get(i).split(",");
            for(String s1 :tmp){
                if (!hs.contains(Integer.parseInt(s1))) {
                    hs.add(Integer.parseInt(s1));
                    answer.add(Integer.parseInt(s1));
                }
            }
        }
        return answer;
    }
}
