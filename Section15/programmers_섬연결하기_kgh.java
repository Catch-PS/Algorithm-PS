package 스터디.스터디_SNU.Section15;
import java.util.Arrays;
import java.util.Comparator;
/**
 * 1. 문제 풀이 시간
 * 초과
 * 2. 컴퓨팅 사고
 * 인접리스트로 접근하였다가 크루스칼알고리즘 최소비용으로 구한 문제
 * (1) 섬의 모든 비용이 주어지고, 모든 지점을 연결할 수 있는 최소비용을 구하여라.
 * (2) 크루스칼 알고리즘으로 연결된 부모를 찾는다.
 * (3) 부모가 같지 않다면 연결이 안된 최솟값이므로 연결을 시켜준다.
 */

// n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
public class programmers_섬연결하기_kgh {
    /* 인접리스트 변수
    static boolean[] isCheck;
    static int answer = Integer.MAX_VALUE;
     */
    static int[] parent;
    public static void main(String[] args) {
          solution(4, new int[][]{{0,1,1,},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
    }
    static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer x = o1[2];
                Integer y = o2[2];
                return x.compareTo(y);
            }
        });
        parent = new int[n];
        // 1. 부모 테이블상에서 부모를 자기자신으로 초기화
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 2. 부모를 찾기
        for(int i=0; i<costs.length; i++){
            int first = findParent(costs[i][0]);
            int second = findParent(costs[i][1]);
            if(first != second){
                System.out.println(first + " " + second);
                parent[second] = first;
                answer += costs[i][2];
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private static int findParent(int x) {
        if(x == parent[x]){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    /**
     * 인접리스트를 이용한 풀이 12.5%
     * @param n
     * @param costs
     * @return
     */
    /*
    static int solution(int n, int[][] costs) {
        // Adj List Init
        List<List<Graph>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        // Adj List
        for(int i=0; i<costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int w = costs[i][2];
            graph.get(x).add(new Graph(y,w));
            graph.get(y).add(new Graph(x,w));
        }
        for(int i=0; i<n; i++){
            bfs(i, costs,graph);
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private static void bfs(int x, int[][] costs, List<List<Graph>> graph) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        isCheck = new boolean[costs.length];
        isCheck[x] = true;
        pq.add(x);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int node = pq.remove();
            for (int i = 0; i < graph.get(node).size(); i++) {
                int dy = graph.get(node).get(i).y;
                int dw = graph.get(node).get(i).w;
                if (!isCheck[dy]) {
                    pq.add(dy);
                    isCheck[dy] = true;
                    sum += dw;
                }
            }
        }
        answer = Math.min(answer, Math.min(sum, min));
    }

    private static class Graph implements Comparable<Graph>{
        int y;
        int w;
        public Graph(int y, int w) {
            this.y = y;
            this.w = w;
        }
        // 오름 차순 정렬
        @Override
        public int compareTo(Graph o) {
            return Integer.compare(o.w, this.w);
        }
    }
     */
}
