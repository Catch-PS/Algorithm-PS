/*
    풀이 시간: 20분
    예상 시간복잡도:
    풀이 방법: pq를 이용해서 정점들을 기록합니다. 이때 정점을 나타내는 Vertex 클래스는 x, y 좌표와 함께 거리의 비용인 cost를 가진 객체로 구성했습니다.
            pq에서 cost가 짧은 정부터 꺼내서 조건에 의해 갈 수 있는 정점들을 넣으면서 진행합니다.
 */

public class leetcode_Minimum_Path_Sum_jdh {
    public static int m, n, answer;
    public static int dx[] = {1, 0};
    public static int dy[] = {0, 1};

    public static class Vertex implements Comparable<Vertex>{
        int x, y, cost;

        public Vertex(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.offer(new Vertex(0, 0, grid[0][0]));
        visited[0][0] = true;

        while(!pq.isEmpty()){
            Vertex cur = pq.poll();

            if(cur.x == m - 1 && cur.y == n - 1) {
                answer = cur.cost;
                break;
            }

            for(int dir = 0; dir < 2; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(checkRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                pq.offer(new Vertex(nx, ny, cur.cost + grid[nx][ny]));
                visited[nx][ny] = true;
            }
        }

        return answer;
    }

    public static boolean checkRange(int x, int y){
        return x >= m || y >= n;
    }

    public static void main(String args[]){
        int grid[][] = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }
}
