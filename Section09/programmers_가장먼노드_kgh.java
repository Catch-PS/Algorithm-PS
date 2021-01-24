package 스터디.스터디_SNU.Section09;
import java.util.*;

/**
 * 1. 문제풀이시간: 15분
 * 2. 컴퓨팅 사고
 * (1) 인접리스트를 활용한 BFS
 * (2) 가장끝에 있는지점을 어떻게 찾을까가 가장 중요한 포인트
 * BFS의 특성상 해당 노드에 연결된 모든지점을 탐색을 진행하기 때문에 하나의 체크변수를 두어서
 * (다음지점 = 현재지점+1)을 통하여 하나의 값들을 누적합을 계속 구해줍니다. 이때, 가장 max 값에 대한 정보를 알고 있어야
 * 모든 탐색이 끝나고 해당 값을 가지고 있는 노드가 몇개인지 체크를 할 수 있습니다.
 * dfs로 풀려고했지만 재귀에서 처리하는게 꼬이는 느낌이여서 바로 bfs로 바꾸어서 풀이를 진행하였습니다.
 * 3. 인접리스트를 활용한 시간복잡도 O(V+E), 인접행렬로 구현할 경우 O(V^2)
 *
 */

public class programmers_가장먼노드_kgh {
    static int[] check;
    static List<List<Integer>> arr = new ArrayList<>();
    static int maxValue = 0;
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}}));
    }
    static int solution(int n, int[][] edge) {
        check = new int[n+1];
        // Init
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }
        // graph
        for(int i=0; i<edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        bfs(1);
        int answer = 0;
        for(int i=0; i<check.length; i++){
            if(check[i] == maxValue){
                answer++;
            }
        }
        return answer;
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        check[node] = 1;
        q.add(node);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<arr.get(x).size(); i++){
                int y = arr.get(x).get(i);
                if(check[y] == 0){
                    check[y] = check[x]+1;
                    q.add(y);
                    maxValue = Math.max(check[y],maxValue);
                }
            }
        }
    }
}
