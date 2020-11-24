package week2;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
 *  #1 풀이시간 : 1시간 30분 
 * 
 *  #2 풀이 방법 :
 *   다익스트라 알고리즘으로 접근.
 *   Pair 자료구조를 만들후 가중치가 적은 순으로 우선순위큐에 삽입.
 *   while 문을 통해 우선순위큐에 아무것도 들어가지 않을때까지 반복수행.
 *   
 *   
 *   #3 시간복잡도 : 일반적인 다익스트라 알고리즘의 시간복잡도 O(ElogV)
 *   여기서 E 는 간선의 개수 , V 는 정점의 개수
 * 
 * 
 */

public class programmers_배달_pcy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N=6;
		
		int[][] road= {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road2 = {{1,2,1},
		                 {1,3,2},
		                 {2,3,2},
		                 {3,4,3},
		                 {3,5,2},
		                 {3,5,3},
		                 {5,6,1}};
		int K=4;
		
		
		System.out.println(solution(N, road2, K));
		

	}
	public static int solution(int N, int[][] road, int K) {
		int answer=0;
		
		int[][] dp = new int[N+1][N+1];
		int[] dist = new int[N+1];
		
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0 ; i<road.length ; i++) {
			int num0 = road[i][0];
			int num1 = road[i][1];
			int num2 = road[i][2];
			if(dp[num0][num1]!=0) {
				num2=Math.min(num2, dp[num0][num1]);
			}
			
			dp[num0][num1]=num2;
			dp[num1][num0]=num2;
		}
		
		dist[1]=0;
		
		PriorityQueue<vertexSet> pq = new PriorityQueue<vertexSet>();
		vertexSet cur;
		pq.add(new vertexSet(1,0));
		while(!pq.isEmpty()) {
			cur = pq.poll();
			int curV=cur.v;
			int curW = cur.w;
			
			if(dist[curV]<curW) {
				continue;
			}
			
			for(int i=1 ; i<dp[curV].length ; i++) {
				if(dp[curV][i]==0) {
					continue;
				}
				int nextV=i;
				int nextW=dp[curV][i];
				if(dist[nextV]>curW+nextW) {
					dist[nextV]=curW+nextW;
					
					pq.add(new vertexSet(nextV, dist[nextV]));
				}
			}
			
			
			
		}
		
		for(int i=1 ; i<dist.length ; i++) {
			if(dist[i]<=K) {
				answer++;
			}
		}
		
		System.out.println(Arrays.toString(dist));
		
		
		
		return answer;
	}
	
	public static class vertexSet implements Comparable<vertexSet> {
		
		int v;
		int w;
		
		public vertexSet(int v , int w) {
			this.v=v;
			this.w=w;
			
		}

		@Override
		public int compareTo(vertexSet o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
		
		
	}

}
