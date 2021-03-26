package 스터디.스터디_SNU.Section16;

import java.util.PriorityQueue;

/**
 * 1. 문제 풀이 시간: 20분
 * 2. 컴퓨팅 사고
 * (1) 우선순위큐를 사용하여 큐에 넣어줄때마다 작은값으로 갱신처리한다.
 * (2) 우선순위큐가 비지 않았고, 맨 앞에서 꺼낸값이 K보다 작을때 반복문을 진행한다.
 * K보다 작다는것은 더이상 진행할 필요가 없다는 뜻과 같습니다.
 * (3) 만약 맨앞에 값을 빼고나서 사이즈가 0이라면 첫번째, 두번째의 값을 비교할 수 없으므로 answer를 -1로 리턴해줍니다.
 * (4) 그게 아니라면 첫번째 값 + 두번째값 * 2를 수행해서 우선순위큐에 넣으면서 갱신을 진행합니다.
 * (5) 현재까지 진행한 횟수값을 카운팅해줍니다.
 * 3. 시간복잡도
 */
public class programmers_더맵게_kgh {
    public static void main(String[] args) {
        solution(new int[]{1,2,3,9,10,12}, 7);
        solution(new int[]{1,1,1,1,1,1}, 100);
        solution(new int[]{8, 10, 11}, 7);
        solution(new int[]{1,1,100}, 3);
    }
    static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int sco : scoville) {
            pq.add(sco);
        }
        while(!pq.isEmpty() && pq.peek() < K){
            int firstFood = pq.remove();
            if(pq.size() == 0){
                answer = -1;
            }
            int secondFood = pq.remove();
            int totalFoods = (firstFood + (secondFood * 2));
            pq.add(totalFoods);
            answer++;
        }
        return answer;
    }
}
