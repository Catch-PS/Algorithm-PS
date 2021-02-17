package 스터디.스터디_SNU.Section12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제풀이시간: 58분
 * check변수만들어서 처리할라다가 삽질
 * 2. 컴퓨팅 사고
 * (1) 0,0지점에서 (n-1,n-1)지점까지 도달하는 모든 경우를 구해주었습니다.
 * 일반 bfs와는 다르게 check변수를 선언하지 않았는데 그 이유는 n-1,n-1지점으로 도달하는 경우가 여러개일수 있기 때문입니다.
 * (2) 4가지 방향을 이용하여 모든 보드를 탐색하였고, 최초로 진입시에는 0,0지점에서 시작점을 잡고 가중치는 0, 방향을 -1로 잡아를 수행하였습니다.
 * (3) 직선의 경우 비용이 100, 곡선이 포함된 경우 (곡선+직선)의 비용을 더해주어야지 해당되는 비용을 모두 구할 수 있습니다.
 * (4) 만약에 현재 보드에값보다 직선,곡선을 돌고 더 작은값이 있다면 값을 갱신하면서 bfs를 수행하는 형식으로 모든지점을 탐색할 수 있도록하였습니다.
 *
 * 3. 시간복잡도
 * 인접리스트 BFS -> O(V+E)
 */
public class programmers_경주로건설_kgh {
    static int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
    static int n;
    static int answer;
    public static void main(String[] args) {
        solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}});
    }
    static int solution(int[][] board) {
        n = board.length;
        answer = Integer.MAX_VALUE;
        bfs(0,0,-1,0,board);
        System.out.println(answer);
        return answer;
    }
    private static void bfs(int x, int y,int d, int w,int[][] board) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(x,y,d,w));
        while(!q.isEmpty()){
            Graph g = q.remove();
            int dx = g.x;
            int dy = g.y;
            int dDirection = g.direction;
            int dWeight = g.weight;

            if(dx == n-1 && dy == n-1){
                answer = Math.min(answer, dWeight);
                continue;
            }

            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                int mWeight = 0;
                if(mx >= 0 && mx < n && my >= 0 && my < n){
                    // 같은 방향이거나 처음값이 들어온 경우 (직선=100원)
                    if(i == dDirection || dDirection == -1){
                        mWeight = dWeight + 100;
                    }
                    // 다른방향으로 꺾은 경우 (직선=100+곡선=500)
                    else {
                        mWeight = dWeight + 600;
                    }
                    // 갈수있으며 해당 가중치값보다 더 작으면 갱신
                    if(board[mx][my] == 0 || board[mx][my] >= mWeight){
                        board[mx][my] = mWeight;
                        q.add(new Graph(mx,my,i,mWeight));
                    }
                }
            }
        }

    }
    static class Graph{
        int x;
        int y;
        int direction;
        int weight;

        public Graph(int x, int y, int direction, int weight) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.weight = weight;
        }
    }
}
