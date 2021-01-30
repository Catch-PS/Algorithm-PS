package 스터디.스터디_SNU.Section10;

import java.util.Arrays;

/**
 * 1. 문제풀이시간 45분
 * 2. 해당문제는 플로이드와샬알고리즘을 사용하였습니다.
 *
 * 플로이트 와샬 알고리즘에 대해 간략히 설명하자면 다음과 같습니다.
 * 플로이드 와샬 알고리즘에 들어가기 앞서 다익스트라와의 차이점을 알아야합니다.
 * 다익스트라 같은 경우는 한지점에서 다른 특정지점까지 최단 경로를 구하는 알고리즘이고
 * 플로이드와샬은 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구하는 경우에 사용하는 알고리즘입니다.
 *
 * 플로이드 워셜알고리즘은 2차원 리스트에 "최단거리" 정보를 저장시키면서 노드를 거치는 모든 경우의 최단 경로를 찾아냅니다.
 * (1)현재 확인하고 있는 노드를 제외하고 N-1개의 노드중에서 서로 다른 노드를 선택쌍 (A,B)를 선택한다고 가정하겠습니다.
 * 이것이 무슨말일까 잘 생각해보면 현재 1번노드를 현재 확인하고 있다고 가정하면 현재 확인하고 있는노드를 제외한다고 하였으니 저희가 찾아야되는 경로는
 * A -> 1번노드 -> B의 경로를 찾아야합니다. 즉, 1번노드를 제외한 나머지 (A->1번노드, 1번노드 ->B)의 노드로 가는 비용의 최소를 찾아주는 것이됩니다.
 * 이것을 점화식으로 나타내면 D[x][y] = Math.min(D[x][y], d[x][k]+d[k][y]) 로 나타낼 수 있습니다.
 * 결론적으로 A에서 B로 가는 최소비용과 A에서 K(거쳐가는 노드)를 거쳐 B로 가는 비용을 비교하여 더 작은 값으로 갱신한다는 말이 됩니다.
 *
 * 순위 문제에서 구하고자하는것은 정확하게 순위를 매길 수 있는 선수의 수를 return하라는 조건입니다.
 * 결국, 플로이드 워셜 알고리즘을 사용하여 모든지점에서 다른 모든노드의 최단경로를 찾는것이기때문에 최단경로에서 i->j, j->i로 가는 경우가 모두 가능한 경우가 있으면 k지점을 거쳐갈 수 있는 노드가 됩니다.
 * k지점을 거쳐서 노드를 모두 방문할 수 있다면(INF무한대)값이 아니라면 순위를 매길 수 있는 경우를 체크하게 됩니다. 여기에서 중요한 점은 자기자신도 출발점이라고 생각하여야합니다.
 * 자기자신을 출발점이라고 생각하는것은 자기자신의 노드에서부터 자기자신노드까지 올수있다라는 의미가 됩니다.(INF가 아닌 0,1의 값일때도 최단경로를 카운팅해주게 됩니다)
 *
 * 3. 시간복잡도
 * O(N^3) = 플로이드 워셜 알고리즘 시간복잡
 */

public class programmers_순위_kgh {
    static int[][] graph;
    static int INF = (int)1e9;
    public static void main(String[] args) {
        solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}});
    }
    static int solution(int n, int[][] results) {
        graph = new int[n+1][n+1];
        // 그래프의 모든값을 INF 무한으로 초기화(1e9)
        for(int i=1; i<=n; i++){
            Arrays.fill(graph[i],INF);
        }

        // 자기자신은 0으로 초기화
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) graph[i][j] = 0;
            }
        }
        // 간선간 비용 1로 초기화
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
        }
        // 몇번노드부터 출발비교를 진행할지
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        int answer = 0;

        // 1번노드부터 노드를 거치는 경우를 모두 구해줍니다.
        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                // 거쳐가는 노드가 INF가 아닐 경우 즉, A에서 B로 도달가능하거나 B에서 A로 도달가능하다는것은 시합의 순위를 비교할 수 있습니다.
                if (graph[i][j] != INF || graph[j][i] != INF){
                    cnt++;
                }
            }
            // 모든 정점에서 도달이 가능한 경우 순위를 매길 수 있습니다.
            if(cnt == n){
                answer++;
            }
        }
        // 결과 출력
        System.out.println(answer);
        return answer;
    }
}
