/*
    풀이 시간: 10분
    예상 시간복잡도:
    풀이 방법: 네트워크 하나하나를 정점으로 보고 DFS를 수행합니다. 하나의 정점에 이어진 정점이 있다면 계속해서 재귀적으로 이어진 다른 정점을 찾으며 탐색합니다.
            따라서 solution 함수에서 방문하지 않은 정점인 경우만 DFS를 수행하기 때문에 DFS 수행 횟수가 곧 네트워크의 수가 됩니다.
 */
public class programmers_네트워크_dfs_jdh {
    public static int N;
    public static boolean visited[];

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            dfs(i, computers);
            answer++;
        }
        return answer;
    }

    public static void dfs(int n, int computers[][]){
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            if(computers[n][i] == 1) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }

    public static void main(String args[]){
        int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3, computers));
    }
}
