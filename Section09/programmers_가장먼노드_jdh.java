/*
    풀이 시간: 30분
    예상 시간복잡도:
    풀이 방법: 각 정점의 최소 경로를 구한 후 가장 큰 max 값을 구합니다.
            그리고 최소 경로를 저장해 둔 배열에서 max 값과 일치하는 값을 카운팅합니다.
 */
public class programmers_가장먼노드_jdh {

    public static class Vertex {
        int n, weight;

        public Vertex(int n, int weight){
            this.n = n;
            this.weight = weight;
        }
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int d[] = new int[n];
        boolean visited[] = new boolean[n];

        LinkedList<Vertex> list[] = new LinkedList[n];
        Queue<Vertex> pq = new LinkedList<>();

        for(int i = 0; i < n; i++) list[i] = new LinkedList<Vertex>();

        for(int i = 0; i < edge.length; i++){
            list[edge[i][0] - 1].add(new Vertex(edge[i][1] - 1, 1));
            list[edge[i][1] - 1].add(new Vertex(edge[i][0] - 1, 1));
        }

        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        pq.offer(new Vertex(0, d[0]));

        while(!pq.isEmpty()){
            Vertex cur = pq.poll();

            if(visited[cur.n]) continue;
            visited[cur.n] = true;

            for(Vertex v : list[cur.n]){
                if(visited[v.n]) continue;
                if(cur.weight + v.weight >= d[v.n]) continue;
                d[v.n] = cur.weight + v.weight;
                pq.offer(new Vertex(v.n, d[v.n]));
            }
        }

        Arrays.sort(d);

        for(int i = 0; i < d.length; i++){
            if(d[i] == d[d.length - 1]) answer++;
        }

        return answer;
        }
    }

    public static void main(String args[]){
        int edge[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, edge));
    }
}
