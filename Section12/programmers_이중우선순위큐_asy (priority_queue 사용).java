import java.util.*;
/*
 * 1. 풀이시간 : 20분
 * 2. 풀이방법
        priority queue 2개를 만듦
        -> maxQueue : 내림차순으로 된 우선순위큐
        -> minQueue : 오름차순으로 된 우선순위큐
        
        "I"가 나오면 최대 우선순위큐, 최소 우선순위큐 두 군데에 넣음
        "D"가 나오면
        (1) 1이 나왔을 때 : 최대값을 구해야하므로 최대 우선순위큐에서 poll을 해서 가장 앞의 값을 꺼내옴
                            (최대 우선순위큐에서 가장 앞의 값 : 최대값)
        (2) -1이 나왔을 때 : 최솟값을 구해야하므로 최소 우선순위큐에서 poll을 해서 가장 앞으 값을 꺼내옴
                            (최소 우선순위큐에서 가장 뒤의 값 : 최솟값)
 * 3. 예상 시간복잡도 : O(nlogn)
 */
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		
		// PriorityQueue는 기본적으로 오름차순 정렬 -> reverseOrder()를 하여 내림차순으로 변경
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		
		for(int i=0; i<operations.length; i++) {
			String[] op = operations[i].split(" ");
			switch (op[0]) {
				case "I":
					int num = Integer.parseInt(op[1]);
					maxQueue.add(num);
					minQueue.add(num);
					break;
				case "D":
					// 큐가 비어있으면 무시
					if(maxQueue.isEmpty()) {
						break;
					}
					if(op[1].equals("1")) {
						// 가장 큰 값을 꺼내고 큐에서 삭제
						int max = maxQueue.poll();
						// 최소힙에서도 삭제해줘야함
						minQueue.remove(max);
					} else {
						int min = minQueue.poll();
						maxQueue.remove(min);
					}
					break;
			default:
				break;
			}
		}//for
		if(!maxQueue.isEmpty()) {
			answer[0] = maxQueue.poll();
			answer[1] = minQueue.poll();
		}
        
        return answer;
    }
}