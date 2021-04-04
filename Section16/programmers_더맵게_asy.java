package level2;

import java.util.PriorityQueue;
/*
 * 1. 풀이시간 : 40분
 * 2. 예상 시간복잡도 : O(logN)
 * 3. 풀이방법
 * 	- 우선순위큐를 사용
 *  - 가장 맵지 않은 음식의 스코빌 지수, 두 번째로 맵지 않은 음식의 스코빌 지수 뽑아서 계산
 *  - 우선순위큐 peek()을 사용해서 가장 앞에 있는 숫자가 K보다 작으면 계속 반복해야함 -> 우선순위큐이므로 맨 앞의 숫자가 K 이상이면 그 뒤의 숫자들도 다 K 이상임
 */	
public class programmers_더맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int cnt = 0;
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int aScoville : scoville) {
			heap.add(aScoville);
		}
		
		while(heap.peek() < K) {
			//마지막 하나 남은 요소가 K보다 작다면 만들 수 없는 경우
			if(heap.size() == 1) {
				cnt = -1;
				break;
			}
			
			int first = heap.poll();
			int second = heap.poll();
			
			int newScoville = first + (second * 2);
			heap.add(newScoville);
			cnt++;
		}
        
        System.out.println(cnt);
	}

}
