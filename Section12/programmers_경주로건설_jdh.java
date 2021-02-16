/*
    풀이 시간: 40분
    예상 시간복잡도: O(n^2)
    풀이 방법: BFS를 이용해서 구현했습니다. queue에 들어가는 객체는 좌표 정보, 어떤 방향에서 온 것인지를 표현하는 dir, 그리고 그 지점까지 누적된 비용을
            의미하는 cost를 가지고 있습니다. 상(0), 하(1), 좌(2), 우(3) 방향을 숫자로 잡고 같은 방향인지 아닌지 판단해서 같은 방향이라면 100을,
            현재 움직이려는 방향과 진행했었던 방향이 불일치하는 경우 600(100 + 500)을 더해주면서 탐색하는 해당 좌표에 최소값만을 남길 수 있도록 구현했습니다.
 */
public class programmers_경주로건설_jdh {
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static int N;

    public static class Loc{
        int x, y, dir, cost;

        public Loc(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        N = board.length;

        Queue<Loc> q = new LinkedList<Loc>();
        q.offer(new Loc(0, 0, 1, 0));
        q.offer(new Loc(0,0, 3, 0));
        board[0][0] = 1;

        while(!q.isEmpty()){
            Loc cur = q.poll();

            if(cur.x == N - 1 && cur.y == N - 1) {
                if(cur.cost < answer){
                    answer = cur.cost;
                }
                continue;
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(checkRange(nx, ny)) continue;
                if(board[nx][ny] == 1) continue;

                int cost = 0;
                if(cur.dir == dir) cost = 100;
                else cost = 600;

                if(board[nx][ny] == 0 || cur.cost + cost <= board[nx][ny]){
                    q.offer(new Loc(nx, ny, dir, cur.cost + cost));
                    board[nx][ny] = cur.cost + cost;
                }
            }
        }
        return answer;
    }

    public static boolean checkRange(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String args[]){
        int board[][] = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},
          {0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
         //int board[][] = {{0,0,0},{0,0,0},{0,0,0}};
        // int board[][] = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(solution(board));
    }
}
