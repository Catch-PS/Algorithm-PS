package 스터디.스터디_SNU.Section09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1.문제풀이시간: 25분
 * 2. 인접행렬 BFS,DFS 로 푼 문제
 * 인접한 점들의 정보가 주어져있고 1인 경우가 인접한것이므로 모든 정점을 돌면서 연결된 하나의 집합의 개수를 구해주면 되는문제였습니다.
 *
 * (1) 체크 배열 변수를 하나 선언하여 해당정점을 지금 방문했는지 안헀는지 여부를 체크해줍니다.
 * (2) DFS, BFS Queue를 활용한 인접행렬을 이용하여 해당 정점기준으로 연결된 모든 요소들을 찾고 체크하여줍니다.
 * DFS를 활용하여 인접행렬로 구현할 수 있습니다.
 * (3) 하나의 정점에서 모든연결요소를 방문하기때문에 -> 결국 하나의 정점에서 모든 요소를 방문한 큰 집합은 하나의 네트워크를 구성한다고 생각하면 됩니다.
 *
 * 3. 시간복잡도
 * O(V^2)
 */
public class programmers_네트워크_kgh {
    static boolean[] check;
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0},{1, 1, 1},{0, 1, 1}}));
    }
    static int solution(int n, int[][] computers) {
        check = new boolean[n];
        Arrays.fill(check,false);
        int answer = 0;
        for(int i=0; i<computers.length; i++){
            if(!check[i]){
                //bfs(i,n,computers);
                dfs(i,n,computers);
                answer++;
            }
        }
        return answer;
    }

    private static void bfs(int node,int n, int[][] computers) {
        check[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<n; i++){
                if(!check[i] && computers[x][i] == 1){
                    check[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    private static void dfs(int node,int n, int[][] computers){
        check[node] = true;

        for(int i=0; i<n; i++){
            int x = computers[node][i];
            if(!check[i] && x == 1){
                dfs(i, n, computers);
            }
        }
    }


}
