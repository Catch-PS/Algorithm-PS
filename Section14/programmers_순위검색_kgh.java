package 스터디.스터디_SNU.Section14;
import java.util.*;

/**
 * 1. 풀이시간: 초과
 * 2. 컴퓨팅사고
 * 생각보다 너무 어려웠던 문제.
 * 총 16가지의 경우의 수에 대한 고정값을 정해놓고, 모든 경우를 처리합니다.
 * 참고 블로그: https://howtolivelikehuman.tistory.com/181
 * https://howtolivelikehuman.tistory.com/181
 *
 */

public class programmers_순위검색_kgh {
    static String language[] = {"cpp","java","python","-"};
    static String position[] = {"backend", "frontend","-"};
    static String career[] = {"junior","senior","-"};
    static String soulfood[] = {"chicken","pizza","-"};
    static String joker = "-";

    public static void main(String[] args) {
        solution(new String[]{ "java backend junior pizza 150",
                        "python frontend senior chicken 210"
                        , "python frontend senior chicken 150"
                        , "cpp backend senior pizza 260"
                        , "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{"cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"});
    }

    public static void setMap(HashMap<String, ArrayList<Integer>> map) {
        for(int a=0; a<language.length; a++) {
            for(int b=0; b<position.length; b++) {
                for(int c=0; c<career.length; c++) {
                    for(int d=0; d<soulfood.length; d++) {
                        map.put(language[a]+position[b]+career[c]+soulfood[d], new ArrayList<Integer>());
                    }
                }
            }
        }
    }
    //모든 16가지 경우 전부 다
    public static void inputVal(HashMap<String, ArrayList<Integer>> map, String info, int cutPoint, int value) {
        String[] token = (info.substring(0, cutPoint-1)).split(" ");
        map.get(token[0] + token[1] + token[2]+ token[3]).add(value);
        map.get(token[0] + token[1] + token[2]+ joker).add(value);
        map.get(token[0] + token[1] + joker+ token[3]).add(value);
        map.get(token[0] + joker + token[2]+ token[3]).add(value);
        map.get(joker + token[1] + token[2]+ token[3]).add(value);
        map.get(token[0] + token[1] + joker+ joker).add(value);
        map.get(token[0] + joker + token[2]+ joker).add(value);
        map.get(joker + token[1] + token[2]+ joker).add(value);
        map.get(token[0] + joker + joker+ token[3]).add(value);
        map.get(joker + token[1] + joker+ token[3]).add(value);
        map.get(joker + joker + token[2]+ token[3]).add(value);
        map.get(token[0] +joker + joker+ joker).add(value);
        map.get(joker + joker + token[2]+ joker).add(value);
        map.get(joker + token[1] + joker+ joker).add(value);
        map.get(joker + joker + joker+ token[3]).add(value);
        map.get(joker + joker + joker+ joker).add(value);
    }


    public static int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];
        HashMap<String, ArrayList<Integer>> infoMap = new HashMap<>();
        setMap(infoMap);

        for(int i = 0; i<info.length; i++) {
            int cutPoint = info[i].lastIndexOf(" ")+1;
            int value = Integer.parseInt(info[i].substring(cutPoint));
            inputVal(infoMap, info[i], cutPoint, value);
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : infoMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        for (int i=0; i < query.length; i++) {
            int cutPoint = query[i].lastIndexOf(" ")+1;
            int value = Integer.parseInt(query[i].substring(cutPoint));
            String key = query[i].substring(0,cutPoint-1).replaceAll(" and ", "");

            ArrayList<Integer> output = infoMap.get(key);
            int idx = Collections.binarySearch(output, value);
            if(idx >= 0) {
                for(int a=idx-1; a>=0; a--) {
                    if(output.get(idx) - output.get(a) > 0) break;
                    else idx = a;
                }
                answer[i] = output.size()-idx;
            }else {
                answer[i] = output.size()+idx+1;
            }
            System.out.println(answer[i]);
        }
        return answer;
    }
}

