package Section19;
/**
 *  풀이 시간 : 30분
 *  시간 복잡도 : O(V+E)
 *  풀이 방법 : DFS
 *  - island 가 되기위한 제약 => 상하좌우가 0 이여야 함.
 *    상하좌우로 dfs / visited 를 통해 접근한 노드 tracking
 *    [1] (i-1, j) [2] (i+1,j) [3] (i,j-1) [4] (i, j+1)
 *
 *  - island 탐색 조건 : (grid[i][j] == '1' && !visited[i][j])
 *
 *  한 island 를 찾기 위한 dfs로 연결되어있는 1을 모두 탐색하였기 때문에
 *  island 에 이어져있는 1 들은 visited 를 통해 탐색을 이미 하였기 때문에 접근이 불가능하여
 *  dfs 를 통해 island 영역을 구하여 개수를 찾을 수 있음.
 */
public class leetcode_number_of_islands_ps {
  public static int numIslands(char[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int island = 0;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == '1' && !visited[i][j]) {
          dfs(grid, i, j, visited);
          island++;
        }

      }
    }
    return island;
  }

  public static void dfs(char[][] grid, int i , int j, boolean[][] visited) {
    if(i < 0 || j < 0 ||
        i  >= grid.length || j >= grid[0].length ||
        visited[i][j] || grid[i][j] == '0') return;

    visited[i][j] = true;
    // 상하 좌우 탐색
    dfs(grid, i-1, j , visited);
    dfs(grid, i+1, j , visited);
    dfs(grid, i, j-1 , visited);
    dfs(grid, i, j+1 , visited);

  }

  public static void main(String[] args) {
    char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
    numIslands(grid);
  }

}
