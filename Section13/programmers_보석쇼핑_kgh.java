package 스터디.스터디_SNU.Section13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1. 풀이시간: 초과
 * 2. 컴퓨팅사고
 * 특정구간의 범위의 조건을 확인할 수 있는 투포인터기법을 사용하였습니다.
 * 중복되지 않는 보석들을 Set으로 처리해서 최소 나와야하는 값의 사이즈를 구해주었습니다.
 * 그리고, 투포인터 알고리즘을 적용하여 start,end점을 확인하여 모든종류의 보석이 포함되었는지, 구간에 맞지않는지 여부를 확인합니다.
 * 만약 모든 종류의 보석이 포함되어 있다면 값을 하나씩 줄여가면서 최적의 해를 찾는 과정이 진행됩니다. (start 포인트점을 증가시켜 앞에서부터 확인을 진행하는 과정)
 * 그렇지않다면, 뒤에서부터 범위를 줄여나가면서 마지막포인터의 값을 증가시켜줍니다.
 * 최종적으로 end-start의 값이 최소범위를 만족할 경우 start+1은 시작점, end점은 끝점이 되면서 값을 반환시켜주게됩니다.
 * end-start 절대값 넣어줬다가 95퍼에서 터졌는데 없애니까 정답
 *
 * 3. 시간 복잡도 O(N)
 */
public class programmers_보석쇼핑_kgh {
    public static void main(String[] args) {
        //System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
        //solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        solution(new String[]{"DIA", "EM", "EM", "RUBY","DIA"});
//        solution(new String[]{"DIA","DIV"});
    }

    private static int[] solution(String[] gems) {
        Set<String> s = new HashSet<>();
        Map<String,Integer> m = new HashMap<>();
        // 1.몇가지 종류가 있는지 체크하기 위한 set
        for(int i=0; i<gems.length; i++){
            s.add(gems[i]);
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int[] answer = {0,0};
        while(true){
            if(m.size() >= s.size()){
                m.merge(gems[start], 1, (currValue, value) -> currValue - value);
                if(m.get(gems[start]) == 0){
                    m.remove(gems[start]);
                }
                start++;
            }else if(end == gems.length){
                break;
            } else{
                m.merge(gems[end], 1, (currValue,value) -> currValue + value);
                end++;
            }

            if(m.size() == s.size()){
                if(end-start <= min){
                    min = Math.min(end-start, min);
                    answer[0] = start+1;
                    answer[1] = end;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
}
