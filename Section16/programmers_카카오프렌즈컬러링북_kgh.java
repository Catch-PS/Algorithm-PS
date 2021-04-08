package 스터디.스터디_SNU.Section16;
import java.util.*;
/**
 * 1. 문제 풀이 시간: 40분
 * 2. 컴퓨팅 사고
 * (1) BFS로 모든 영역의 최대 영역을 구해준다.
 * (2) 현재 체크된 부분은 뛰어넘고, 체크되지 않은 부분이면서 picture의 값이 0이 아닌 값일 경우 계속 탐색을 진행한다.
 * (3) 각 정점을 기준으로 bfs가 진행된 areaSize를 0으로 초기화해주면서 값을 구해준다
 * (4) 정점마다 bfs를 한번 수행할때마다 하나의 section이 생성되므로 값을 증가시켜준다
 * 주의점: 모든 예외케이스를 구해보아도 계속 틀렸습니다가 나와서 확인해보니 static으로 선언한 부분의 초기화가 제대로 이루어지지 않아 에러가 나오는 상황이 발생하여 solution진입시 모든값을 초기화 해주었습니다.
 * 3. 시간복잡도
 * O(N^2)
 */
public class programmers_카카오프렌즈컬러링북_kgh {
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[][] check;
    static int[][] dist;
    static int areaSize;
    static int sectionSize;
    static int maxValue;
    public static void main(String[] args) {
        solution(6,4,new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}});
        solution(3,3,new int[][]{
                {0, 1, 0},
                {1, 1, 0},
                {0, 0, 0}});
    }
    static int[] solution(int m, int n, int[][] picture) {
        areaSize = 0;
        sectionSize = 0;
        maxValue = 0;
        check = new int[m][n];
        dist = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && check[i][j] == 0) {
                    areaSize = 0;
                    bfs(i, j, m, n, picture);
                    sectionSize++;
                }
            }
        }
        int[] result = new int[2];
        result[0] = sectionSize;
        result[1] = maxValue;
        System.out.println(result[0] + " " + result[1]);
        return result;
    }

    private static void bfs(int x, int y, int m, int n, int[][] picture) {
        Queue<Pair> q = new LinkedList<>();
        dist[x][y] = 0;
        check[x][y] = 1;
        areaSize+=1;
        q.add(new Pair(x,y));
        while(!q.isEmpty()){
            Pair pair = q.remove();
            int dx = pair.x;
            int dy = pair.y;
            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                //if(mx < 0 || mx >= m || my < 0 || my >= n) continue;
                if(mx >= 0 && mx < m && my >=0 && my < n) {
                    // 상하좌우가 같은 경우
                    if (picture[dx][dy] == picture[mx][my] && check[mx][my] == 0) {
                        dist[mx][my] = dist[dx][dy] + 1;
                        check[mx][my] = 1;
                        areaSize++;
                        q.add(new Pair(mx, my));
                    }
                }
            }
        }
        maxValue = Math.max(areaSize, maxValue);
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
