/*
    풀이 시간: 15분
    예상 시간복잡도: ....
    풀이 방법: BFS를 이용해서 구현했습니다.
 */

public class programmers_카카오프렌즈컬러링북_jdh {
    public static int max;
    public static boolean isVisited[][];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static class Pair {
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        max = Integer.MIN_VALUE;
        isVisited = new boolean[m][n];
        int answer[] = new int[2];

        int areaCnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isVisited[i][j]) continue;
                if(picture[i][j] == 0) continue;
                int cnt = bfs(i, j, m, n, picture);
                areaCnt++;

                if(max < cnt) max = cnt;
            }
        }

        answer[0] = areaCnt;
        answer[1] = max;
        return answer;
    }

    public static int bfs(int x, int y, int m, int n, int picture[][]){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        isVisited[x][y] = true;

        int cnt = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int dir = 0; dir < 4; dir++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                if(checkRange(nx, ny, m, n)) continue;
                if(isVisited[nx][ny]) continue;
                if(picture[p.x][p.y] != picture[nx][ny]) continue;
                q.offer(new Pair(nx, ny));
                isVisited[nx][ny] = true;
                cnt++;
            }
        }

        return cnt;
    }

    public static boolean checkRange(int x, int y, int m, int n){
        return x < 0 || x >= m || y < 0 || y >= n;
    }

    public static void main(String args[]){
        int m = 6;
        int n = 4;
        int picture[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(solution(m, n , picture)));
    }
}
