package week2;

import java.util.HashSet;

/*
 * #1 풀이시간 1시간
 * 
 * #2 풀이 방법
 * 2-1 처음 방법은 Pair 형 자료구조 (now_x now_y ...) 등 총 4개의 변수를 Set을 통해 계산할려고 판단.
 * 하지만 Custom Class 일 경우 각 형태의 메모리값이 달라 같은 값이여도 서로 다른 객체로 인식.
 * Sol -> hasCode 와 equals 를 조정을 통해 접근 -> 실패...
 * 
 * 2-2 -> 4차원 배열의 통해 앞에 두개는 현재의 좌표 다음 2개는 다음 좌표를 통해 접근
 * 
 * 
 * #3 시간복잡도.
 * 
 * dirs 의 문자을 한번씩만 비교. O(N)
 * 
 * 
 * 
 */

public class programmers_방문길이_pcy {
	
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
