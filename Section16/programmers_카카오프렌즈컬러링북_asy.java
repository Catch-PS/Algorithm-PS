package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 1. 풀이시간 : 시간초과
 * 2. 예상 시간복잡도 : O(N)
 * 3. 풀이방법
 * 	
 */	
public class programmers_카카오프렌즈컬러링북 {
	static int[] di = {-1,1,0,0};	//상,하,좌,우
	static int[] dj = {0,0,-1,1};
	static boolean[][] visited;
	static int cnt;
	
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] pictures = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		
		List<Integer> list = new ArrayList<Integer>();
		visited = new boolean[m][n];
		// 각 배열의 시작값 탐색
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				// 해당값이 0이 아니고, 이미 방문하지 않은 배열이라면 탐색 시작
				if(pictures[i][j] != 0 && !visited[i][j]) {
					// 새로운 값부터 탐색하므로 cnt 초기화
					cnt = 0;
					visited[i][j] = true;
					cnt++;
					dfs(i,j,m,n,pictures);
					// 카운트를 ArrayList에 넣고 초기화
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list.get(0));
	}

	private static void dfs(int si, int sj, int m, int n, int[][] pictures) {
		//시작위치가 0이거나, 탐색을 한 곳이라면 리턴
//		if(pictures[si][sj]==0 || visited[si][sj]==true) return;
		
		for(int dir=0; dir<4; dir++) {
			int ni = si + di[dir];
			int nj = sj + dj[dir];
			
			if(ni<0 || ni>=m || nj<0 || nj>=n) {
				continue;
			}
			
			// 이전과 같은 값이고, 아직 방문하지 않았다면 카운트 증가
			if(pictures[ni][nj] == pictures[si][sj] && !visited[ni][nj]) {
				visited[ni][nj] = true;
				cnt++;
				dfs(ni, nj, m, n, pictures);
			}
			// 이전과 다른 값이거나, 이미 방문했으면 리턴
			else if (pictures[ni][nj] != pictures[si][sj] || !visited[ni][nj]) {
				return;
			}
		}
	}

}
