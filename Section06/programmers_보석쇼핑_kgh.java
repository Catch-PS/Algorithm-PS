package 스터디.스터디_SNU.Section06;

import java.util.*;

/**
 * 1. 풀이시간: 초과
 * 2. 컴퓨팅사고
 * 특정구간의 범위의 조건을 확인할 수 있는 투포인터기법을 사용하였습니다.
 * 중복되지 않는 보석들을 Set으로 처리해서 최소 나와야하는 값의 사이즈를 구해주었습니다.
 * 그리고, 투포인터 알고리즘을 적용하여 start,end점을 확인하여 모든종류의 보석이 포함되었는지, 구간에 맞지않는지 여부를 확인합니다.
 * 만약 모든 종류의 보석이 포함되어 있다면 값을 하나씩 줄여가면서 최적의 해를 찾는 과정이 진행됩니다. (start 포인트점을 증가시켜 앞에서부터 확인을 진행하는 과정)
 * 그렇지않다면, 뒤에서부터 범위를 줄여나가면서 마지막포인터의 값을 증가시켜줍니다.
 * 최종적으로 end-start의 값이 최소범위를 만족할 경우 start+1은 시작점, end점은 끝점이 되면서 값을 반환시켜주게됩니다.
 * 매우 어려웠던 문제...
 *
 * 3. 시간 복잡도 O(N)
 */
public class programmers_보석쇼핑_kgh {
    public static void main(String[] args) {

        //System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
        solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    }

    private static int[] solution(String[] gems) {

        // 투포인트 기법
        int[] answer = {0,0};
        Set<String> s = new HashSet<>();
        // 중복되지 않는 보석들을 넣어줍니다.
        for(String gem : gems){
            s.add(gem);
        }

        int gemsKind = s.size();
        Map<String,Integer> m = new HashMap<>();

        int start = 0;
        int end = 0;
        int minDist = Integer.MAX_VALUE;

        while(true){
            // 모든 종류의 보석을 포함하게 된다면 (현재 구간이 조건에 맞는다면)
            if(m.size() >= gemsKind){
                // 구간 줄이기(맨 앞보석제거)
                m.merge(gems[start],1, (currValue, cal) -> (currValue - cal));
                if(m.get(gems[start]) == 0){
                    m.remove(gems[start]);
                }
                start++;
            }
            // 현재 구간에 맞지 않고, 마지막 포인터가 범위를 초과하면 종료한다.
            else if(end == gems.length){
                break;
            }
            // 현재 구간이 조건에 맞지 않는다면, 마지막 포인터를 증가시켜본다.
            else {
                m.merge(gems[end],1, Integer::sum);
                end++;
            }
            // 현재 구간이 조건에 맞는지 확인합니다. 모든 종류의 보석을 포함하고 있는지 여부를 확인합니다
            if(m.size() == gemsKind){
                // 조건을 만족하는 최소의 구간을 구해줍니다.
                if(Math.abs(end-start) < minDist){
                    minDist = Math.abs(end-start);
                    answer[0] = start + 1;
                    answer[1] = end;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }


}
