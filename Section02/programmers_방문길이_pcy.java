package week2;

import java.util.HashSet;

/*
 * #1 Ǯ�̽ð� 1�ð�
 * 
 * #2 Ǯ�� ���
 * 2-1 ó�� ����� Pair �� �ڷᱸ�� (now_x now_y ...) �� �� 4���� ������ Set�� ���� ����ҷ��� �Ǵ�.
 * ������ Custom Class �� ��� �� ������ �޸𸮰��� �޶� ���� ���̿��� ���� �ٸ� ��ü�� �ν�.
 * Sol -> hasCode �� equals �� ������ ���� ���� -> ����...
 * 
 * 2-2 -> 4���� �迭�� ���� �տ� �ΰ��� ������ ��ǥ ���� 2���� ���� ��ǥ�� ���� ����
 * 
 * 
 * #3 �ð����⵵.
 * 
 * dirs �� ������ �ѹ����� ��. O(N)
 * 
 * 
 * 
 */

public class programmers_�湮����_pcy {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dirs = "LULLLLLLU";
		
		System.out.println(solution(dirs));

	}
	
	
	public static int solution(String dirs) {
		int answer=0;
		
		boolean[][][][] visited = new boolean[11][11][11][11];
		// 0 1 2 3 4 || 5 || 6 7 8 9 10 
		HashSet<Pair> h = new HashSet<Pair>();
		
		int now_x=5;
		int now_y=5;
		
		int next_x=5;
		int next_y=5;
		int dir=0;
		
		for(int i=0 ; i<dirs.length() ; i++) {
			
			
			
			if(dirs.charAt(i)=='U') {				
				dir=2;
				
			}else if(dirs.charAt(i)=='D') {				
				dir=3;

			}else if(dirs.charAt(i)=='R') {
				
				dir=1;

			}else if(dirs.charAt(i)=='L') {
				
				dir=0;
				
			}
			
			
			next_x=now_x+dx[dir];
			next_y=now_y+dy[dir];
			
			if(next_x<0) {
				next_x=0;
				continue;
			}else if(next_x>10) {
				next_x=10;
				continue;
			}
			
			
			
			if(next_y<0) {
				next_y=0;
				continue;
			}else if(next_y>10) {
				next_y=10;
				continue;
			}
			
			
			
			
			
			
			if(!visited[now_x][now_y][next_x][next_y] || !visited[next_x][next_y][now_x][now_y]) {
			
				visited[now_x][now_y][next_x][next_y]=true;
				visited[next_x][next_y][now_x][now_y]=true;
				answer++;
				
			}
			
			
			
			now_x=next_x;
			now_y=next_y;
			
		}
		
		
		
		
		
		return answer;
	}
	
	
	public static class Pair{
		
		int now_x;
		int now_y;
		int next_x;
		int next_y;
		Pair(int now_x , int now_y , int next_x ,int next_y){
			this.now_x=now_x;
			this.now_y=now_y;
			this.next_x=next_x;
			this.next_y=next_y;
		}
		
	}

	    
		
	

}
