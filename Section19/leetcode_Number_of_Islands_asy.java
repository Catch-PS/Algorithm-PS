package medium;
/*
 * 1. 풀이시간 : 40분
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 	(1) 시작 위치가 섬(1)인 곳에서부터 dfs 탐색 시작
 * 	(2) dfs 탐색을 하면서 물(0)이거나, 이미 탐색한 곳이면 탐색하지 않고 이전에 재귀호출한 부분으로 돌아감
 * 	(3) main에서 findIsland 함수를 나오게 되면 섬을 하나 찾은 것이므로 카운트 1증가 
 */
public class leetcode_Number_of_Islands {
	static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static boolean[][] visited;

	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		int answer = 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    findIsland(i,j,grid);
                    answer++; //한 덩어리의 섬을 찾으면 개수 증가, 그 다음 돌아가서 다른 위치의 탐색 시작 부분 찾기
                }
            }
        }
        
        System.out.println(answer);
	}
	
    public static void findIsland(int si, int sj, char[][] grid){
        // 시작위치가 물이거나, 이미 탐색한 곳이라면 리턴
        if(grid[si][sj]=='0' || visited[si][sj])    return;
        
        visited[si][sj] = true;
        
        // 4방향 탐색
        for(int dir=0; dir<4; dir++){
            int ni = si + di[dir];
            int nj = sj + dj[dir];
            
            // 범위를 벗어나면 다른 방향 탐색
            if(ni<0 || ni>=grid.length || nj<0 || nj>=grid[0].length) continue;
            
            // 다음 위치가 섬이고, 방문하지 않은 곳이라면 재귀호출
            if(grid[ni][nj]=='1' && !visited[ni][nj]){
                findIsland(ni,nj,grid);
            }
        }
    }
}
