package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 1. Ǯ�̽ð� : �ð��ʰ�
 * 2. ���� �ð����⵵ : O(N)
 * 3. Ǯ�̹��
 * 	
 */	
public class programmers_īī���������÷����� {
	static int[] di = {-1,1,0,0};	//��,��,��,��
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
		// �� �迭�� ���۰� Ž��
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				// �ش簪�� 0�� �ƴϰ�, �̹� �湮���� ���� �迭�̶�� Ž�� ����
				if(pictures[i][j] != 0 && !visited[i][j]) {
					// ���ο� ������ Ž���ϹǷ� cnt �ʱ�ȭ
					cnt = 0;
					visited[i][j] = true;
					cnt++;
					dfs(i,j,m,n,pictures);
					// ī��Ʈ�� ArrayList�� �ְ� �ʱ�ȭ
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list.get(0));
	}

	private static void dfs(int si, int sj, int m, int n, int[][] pictures) {
		//������ġ�� 0�̰ų�, Ž���� �� ���̶�� ����
//		if(pictures[si][sj]==0 || visited[si][sj]==true) return;
		
		for(int dir=0; dir<4; dir++) {
			int ni = si + di[dir];
			int nj = sj + dj[dir];
			
			if(ni<0 || ni>=m || nj<0 || nj>=n) {
				continue;
			}
			
			// ������ ���� ���̰�, ���� �湮���� �ʾҴٸ� ī��Ʈ ����
			if(pictures[ni][nj] == pictures[si][sj] && !visited[ni][nj]) {
				visited[ni][nj] = true;
				cnt++;
				dfs(ni, nj, m, n, pictures);
			}
			// ������ �ٸ� ���̰ų�, �̹� �湮������ ����
			else if (pictures[ni][nj] != pictures[si][sj] || !visited[ni][nj]) {
				return;
			}
		}
	}

}
