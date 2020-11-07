/*
풀이시간: 초과...
 */

package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_Mootube15591_kgh {
    static int n;
    static int q;
    static boolean[] check;
    static int answer = 0;
    static ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr.get(x).add(new Pair(y,value));
            arr.get(y).add(new Pair(x,value));
        }


        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bfs(k,v);
            System.out.println(answer);
            answer = 0;
        }
    }

    private static void bfs(int k, int v) {
        check = new boolean[5001];
        Queue<Integer> q = new LinkedList<>();
        check[v] = true;
        q.add(v);

        while(!q.isEmpty()){
            int node = q.remove();

            for(int i=0; i<arr.get(node).size(); i++){
                int y = arr.get(node).get(i).y;
                int value = arr.get(node).get(i).value;
                // 방문하지 않은 노드이고, 가중치값이 k보다 크거나 같을 경우만 진행한다. 그 외의 경우에는 진행하지 않는다. 조건을 만족 X
                if(!check[y] && value >= k){
                    q.add(y);
                    check[y] = true;
                    answer++;
                }
            }
        }
    }

    static class Pair{
        int y;
        int value;
        public Pair(int y, int value) {
            this.y = y;
            this.value = value;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }
}
