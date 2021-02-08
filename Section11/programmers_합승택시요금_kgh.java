package 스터디.스터디_SNU.Section11;

import java.util.Arrays;

/**
 * 1. 문제풀이시간: 34분
 * 2. 플로이드워셜알고리즘을 이용한 최단경로 문제
 *
 * (1) 모든 맵에 지점의 개수 * 택시비용의 최댓값인 (100 * 200000)으로 값을 초기화해줍니다.
 * (2) 자기자신을 바라보는것들은 0으로 초기화합니다
 * (3) 배열값을 복사하여 배열들의 값을 재 세팅을 해줍니다.
 * (4) 플로이드워셜알고리즘의 점화식을 도출해냅니다. graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j])
 * (5) 점화식으로 도출해낸 모든 비용의 배열에서 출발지점 -> (모든지점을 탐색의 비용 + 모든지점의 탐색 -> A의 도착의 비용 + 모든지점의 탐색 -> B의 도착의 비용)의 최솟값을 구해줍니다.
 * (6) 결국, 시작점에서 출발하여 거쳐간 지점중에 + A도착점 + B도착점의 최솟값을 탐색을 하게 되면 모든 최단 경로의 비용을 구할 수 있게 됩니다.
 */
public class programmers_합승택시요금_kgh {
    static int[][] graph;
    static int INF = 200 * 100000;      // 지점의 개수 * 택시비용 최댓

    public static void main(String[] args) {
        solution(6,4,6,2,new int[][]{
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}});
    }

    /**
     *
     * @param n 노드의 개수
     * @param s 출발지점
     * @param a A 도착지점
     * @param b B 도착 지점
     * @param fares
     * @return
     */
    static int solution(int n, int s, int a, int b, int[][] fares){
        graph = new int[201][201];
        int answer = INF;

        // 1. 무한으로 초기화
        for(int i=0; i<201; i++){
            Arrays.fill(graph[i], INF);
        }
        // 2. 자기 자신 0 초기화
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j){
                    graph[i][j] = 0;
                }
            }
        }
        // 3.배열값 복사
        for(int i=0; i<fares.length; i++){
            int x = fares[i][0];
            int y = fares[i][1];
            int w = fares[i][2];
            graph[x][y] = w;
            graph[y][x] = w;

        }
        // 4. 플로이드 워셜: 모든 경우에서 거쳐가는경로의 최소비용을 구합니다.
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // 5. 거쳐가는 경로를 모두 합한값의 최솟값을 구해줍니다.
        for(int i=1; i<=n; i++){
            answer = Math.min(answer,graph[s][i] + graph[i][a] + graph[i][b]);
        }
        System.out.println(answer);
        return 0;
    }
}
