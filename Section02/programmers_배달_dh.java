import java.util.*;

/*
  풀이 시간: 25분
  풀이 방법: 다익스트라로 접근하여 해결, 시작 정점을 기준으로 각 정점마다 갈 수 있는 최단 경로를 구한 후 최단 경로 중 K안에 드는 경로는 카운팅
  시간 복잡도: while과 for문의 중첩 사용으로 인해 대략적으로 O(n^2) 예상, N제한이 50이하이므로 시간 안에 통과 가능
*/

class Solution {
    public static class Vertex implements Comparable<Vertex> {
        int v, weight;

        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public static int solution(int N, int[][] road, int K) {
        int result = 0;
        // int end = N - 1;

        int adj[][] = new int[N][N];
        int d[] = new int[N];
        boolean visited[] = new boolean[N];


        for(int i = 0; i < road.length; i++){
            int a = road[i][0] - 1;
            int b = road[i][1] - 1;
            int dis = road[i][2];

            if(adj[a][b] != 0 && adj[a][b] < dis) continue;
            adj[a][b] = dis;
            adj[b][a] = dis;
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        d[0] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.offer(new Vertex(0, d[0]));

        while(!pq.isEmpty()){
            Vertex cur = pq.poll();

            if(visited[cur.v]) continue;
            visited[cur.v] = true;
            // if(cur.v == end) break;

            for(int i = 0; i < N; i++){
                if(!visited[i] && adj[cur.v][i] != 0 && cur.weight + adj[cur.v][i] < d[i]){
                    d[i] = cur.weight + adj[cur.v][i];
                    pq.offer(new Vertex(i, d[i]));
                }
            }
        }

        for(int i = 0; i < d.length; i++){
            if(d[i] <= K) result++;
        }

        return result;
    }
}
