/*
    풀이 시간: 10분
    예상 시간복잡도: for문이 가장 시간복잡도가 높기 때문에 O(n)
    풀이 방법: pq를 이용하여 따로 정렬하지 않고 앞 두개의 원소를 가지고 스코빌 지수를 계산하였습니다.
            이때 두 개씩 원소를 빼서 계산 후 다시 삽입을 하기 때문에 매 루프마다 하나씩 원소가 감소하게 됩니다.
            그래서 사이즈가 1인데 스코빌 지수 미만인 경우 불가능한 경우이기 때문에 -1을 반환하고 그 경우가 아니라면 루프 수행 횟수가
            곧 섞어야하는 최소 횟수가 됩니다.
 */

public class programmers_더맵게_jdh {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while(true){
            if(pq.size() == 1 && pq.peek() < K) return -1;
            if(pq.peek() >= K) break;

            int min1 = pq.poll();
            int min2 = pq.poll();

            int scoNum = min1 + (min2 * 2);
            pq.offer(scoNum);
            answer++;
        }

        return answer;
    }

    public static void main(String args[]){
        int scovile[] = {0, 0, 3, 9, 10, 12};
        int k = 7000;
        System.out.println(solution(scovile, k));
    }
}
