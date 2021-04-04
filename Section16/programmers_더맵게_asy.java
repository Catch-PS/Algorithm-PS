package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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
