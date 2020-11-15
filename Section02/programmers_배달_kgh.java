package Study.Section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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