package Study.Section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
#1 풀이 시간
인접리스트로 접근하였는데 응용된 힙 + 다익스트라 문제, 시간 초과

#2 접근방식
- 인접리스트로 접근하여서 풀었지만, 21.9% 터져서 다른방식 고민
- 우선순위큐를 사용하여 가중치값이 작은순서대로 처리(Comparable implements를 통해 compareTo함수 override) 오름차순 정렬
- check변수를 사용하여 가장 작은 가중치값을 찾아야하므로 비교를 위해 모든값을 Integer.MAX_VALUE 최대값으로 초기화하였습니다.
- 현재 노드의 거리, 현재까지의 거리를 더한값을 현재 각 노드의 거리 저장값과 비교하여 더 작을 경우 값을 갱신시켜줍니다.
- 체크된 거리값들이 <= K 의 범위를 만족하는 값들만 answer를 카운팅 시켜주었습니다.

#3 시간복잡도
그래프에서 V: 정점, E:간선 으로 표현되기때문에 G=(V,E)식으로 나타낼 수 있습니다.
모든 정점을 방문 O(V), 우선순위큐 트리형식으로 값을 삽입/삭제 O(logE)의 시간복잡도를 갖고 있기때문에
결과적으로 O(V * log E)의 시간복잡도를 갖는다고 생각하였습니다.

+ 추가
인접리스트 시간복잡도: O(V+E)
인접행렬 시간복잡도: O(V^2)
 */

public class programmers_배달_kgh {
    static PriorityQueue<Pair> pq;
    static ArrayList<ArrayList<Pair>> arr = new ArrayList<>();

    static int[] check;
    static int answer = 0;

    public static void main(String[] args) {
        System.out.print(solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
    }
    static int solution(int N, int[][] road, int K) {
        pq = new PriorityQueue<>();
        check = new int[N+1];
        Arrays.fill(check, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            int value = road[i][2];
            arr.get(x).add(new Pair(y,value));
            arr.get(y).add(new Pair(x,value));
        }

        bfs(1);
        for(int i=0; i<check.length; i++){
            if(check[i] <= K){
                answer++;
            }
        }
        return answer;
    }

    private static void bfs(int x) {
        check[x] = 0;
        pq.offer(new Pair(x, 0));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int from_y = pair.y;
            int from_value = pair.value;
            for(int i=0; i<arr.get(from_y).size(); i++){
                int to_y = arr.get(from_y).get(i).y;
                int to_value = arr.get(from_y).get(i).value;
                //System.out.println(check[from_y] + to_value);
                if(check[to_y] > check[from_y] + to_value){
                    check[to_y] = check[from_y] + to_value;
                    pq.offer(new Pair(to_y, to_value));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int y;
        int value;
        Pair(int y, int value) {
            this.y = y;
            this.value = value;
        }
        @Override
        public int compareTo(Pair pair) {
            // 오름차순 정렬
            return this.value - pair.value;
        }
    }

}

/* 정답 21.9% 인접리스트 풀이 30분
import java.util.*;

class Solution {
    static ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
    static int[] check;
    static int answer = 1;
    public int solution(int N, int[][] road, int K) {

        check = new int[N+1];
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            int value = road[i][2];
            arr.get(x).add(new Pair(y,value));
            arr.get(y).add(new Pair(x,value));
        }

        dfs(1, K, 0);
        //bfs(1, K, 0);
        return answer;
    }
    void dfs(int x, int K,int sum){
        check[x] = 1;
        if(sum > K){
            check[x] = 0;
            return;
        }
        if(sum <= K){
            answer++;
        }
        for(int i=0; i<arr.get(x).size(); i++){
            int y = arr.get(x).get(i).y;
            int value = arr.get(x).get(i).value;
            if(check[y] == 0){
                sum += value;
                dfs(y, K, sum);
            }
        }
    }
    void bfs(int x, int K,int sum){
        Queue<Integer> q = new LinkedList<>();
        check[x] = 1;
        q.add(x);

        while(!q.isEmpty()){
            int dx = q.remove();
            for(int i=0; i<arr.get(dx).size(); i++){
                int y = arr.get(dx).get(i).y;
                int value = arr.get(dx).get(i).value;

                if(check[y] == 0){
                    sum += value;
                    if(sum <= K){
                        answer++;
                    }else {
                        sum = 0;

                    }
                    q.add(y);
                }
            }
        }
    }


    class Pair{
        int y;
        int value;

        public Pair(int y, int value){
            this.y = y;
            this.value = value;
        }

        private void setY(int y){
            this.y = y;
        }
        public int getY(){
            return this.y;
        }

        private void setValue(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }
}
 */