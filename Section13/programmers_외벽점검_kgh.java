package 스터디.스터디_SNU.Section13;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 문제풀이시간
 * 시간초과
 * 2. 컴퓨팅사고
 * (1) 취약점의 출발지를 설정하고 취약지점을 평면으로 생각하여 해당 N범위를 넘어갈 것을 대비하여 취약지점+N까지 값들을 넣어줍니다.
 * (2) 출발점과 다음 취약점의 거리가 사용 가능한 친구의 시간보다 크면 더이상 진행할 수 없는것이므로 다음값으로 갱신하여 진행
 * 즉, 현재 친구의 시간으로 모든 외벽을 점검할 수 없다는 뜻이 됩니다.
 * (3) 만약 친구의 시간이 더 클 경우
 * 점검이 가능하기 때문에 다음취약점으로 다시 점검을 체크합니다.
 * (4) 만약 모든 친구를 사용하지 않고도 투입이 가능하다면 최솟값을 갱신하여 진행합니다.
 * (5) 친구를 모두 투입했지만 성공하지 못하였으면 -1을 리턴해줍니다. 즉, 최솟값을 구하기 위해 설정한 Integer.MAX_VALUE 값과 같은지를 확인합니다.
 *
 * 3. 시간복잡도:
 * O(DFS + N^2)
 *
 */
public class programmers_외벽점검_kgh {
    static boolean[] check;
    static List<Integer> circleWeakList = new ArrayList<>();
    static LinkedList<Integer> friendDistList = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        solution(12, new int[]{1,5,6,10},new int[]{1,2,3,4});
    }
    static int solution(int n, int[] weak, int[] dist) {
        check = new boolean[dist.length];

        // 취약지점 넣어주기
        for(int i=0; i<weak.length; i++){
            circleWeakList.add(weak[i]);
        }
        // 원형을 평면으로 생각하여 +n만큼 더 진행
        for(int i=0; i<weak.length; i++){
            circleWeakList.add(weak[i]+n);
        }
        dfs(0,weak,dist);
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
        // System.out.println("answer => " + answer);
        return answer;
    }

    private static void dfs(int cnt, int[] weak, int[] dist) {
        if(cnt == dist.length){
            distCheck(weak);
            return;
        }
        // 친구가 투입되는 거리의 조합 예: 1,2,3,4 -> 2,3,4,1 ... 해당거리만큼을 먼저 방문해야하는지를 체크를 진행
        for(int i=0; i<dist.length; i++){
            if(check[i]){
                continue;
            }
            check[i] = true;
            friendDistList.add(dist[i]);
            dfs(cnt+1, weak, dist);
            friendDistList.removeLast();
            check[i] = false;
        }
    }
    private static void distCheck(int[] weak) {
        for(int i=0; i<weak.length; i++){
            int idx = 0;
            boolean friendSizeCheck = false;
            int startPoint = circleWeakList.get(i);
            // 들어가있는 취약지점을 하나씩 밀면서 처리하기 예: 123456
            // 123456 -> 23456 -> 3456 -> 456 ....
            for(int j=i; j<i+weak.length; j++){
                // 두점 사이의 거리가 검사 가능한 친구거리보다 크다면 더이상 진행이 불가능하므로 갱신
                if(friendDistList.get(idx) < circleWeakList.get(j) - startPoint){
                    startPoint = circleWeakList.get(j);
                    idx++;
                    // 모든친구를 방문하였을 경
                    if(idx == friendDistList.size()){
                        friendSizeCheck = true;
                        break;
                    }
                }
            }
            // 모든 친구를 사용하지 않고도 투입이 가능한 경우
            if(!friendSizeCheck){
                answer = Math.min(answer, idx+1);
            }
        }
    }
}
