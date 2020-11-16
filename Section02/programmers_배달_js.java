package Study.Section02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*

    풀이 시간: 시간초과
    풀이 방법: dijkstra (그래프 우선순위큐를 이용)
              도착점 노드와 거리 필드를 가진 Edge를 구현하여 거리를 가중치로 가지도록함
              방향이 없는 엣지를 가진 그래프를 정의, dist[] 배열에는 최단거리를 가지는데 초기값으로 Integer 최대값으로 셋팅
              가장 처음에 1부터 시작하므로 도착노드 1, 거리 0인 엣지를 정의하여 우선순위 큐에 넣습니다
              BFS 탐색을 합니다
              - 현재 꺼낸 노드의 최단거리(dist[cur])가 현재 거리보다 작으면 continue
                (왜냐하면 현재거리 + 다음거리가 최단거리면 업데이트인데, 이미 현재 거리보다 작으니 더 이상 수행을 하지 않아도 됩니다)
              - 현재 거리보다 크면, 다음 노드의 거리와 현재 노드의 거리의 합이 최소인 것을 찾아서 dist[]에 에 업데이트 해주고, 큐에 넣어줍니다
              최종적으로 dist[] 배열에는 각 노드에 도달하기까지의 최단거리가 나올 것이고,
              다시한번, dist[] 배열을 돌면서 k이하일 때 count++하여 count를 return 합니다

    시간 복잡도: O(ElogE) = O(E)(dijkstra는 모든 간선을 검사) X O(logE)(우선순위큐 검사하면서 추가 및 삭제가 최대 한번씩)
                + O(N)(배열을 돌면서 k이하를 찾으면서 count++)
                = O(N) + O(ElogE)
 */

public class programmers_배달_js {
    public static void main(String[] args) {
        int count = 0;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int N = 5;
        int K = 3;
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Graph graph = new Graph(road.length+1);
        for (int[] edge : road) {
            graph.addDirectionlessEdge(edge[0], edge[1], edge[2]);
        }

        graph.dijkstra(1,dist);
        for (int i : dist) count += i<=K ? 1 : 0;
        System.out.println(Arrays.toString(dist));
        System.out.println(count);
    }

    static class Graph {

        private final List<List<Edge>> graph;

        public Graph(int nodeSize) {
            graph = new ArrayList<>();
            for (int i=1; i<=nodeSize; i++) graph.add(new LinkedList<>());
        }

        public void addDirectionlessEdge(int node1, int node2, int distance) {
            graph.get(node1).add(new Edge(node2, distance));
            graph.get(node2).add(new Edge(node1, distance));
        }

        public void dijkstra(int s, int[] dist) {
            dist[s] = 0;
            PriorityQueue<Edge> priorityQueue = new PriorityQueue();
            priorityQueue.offer(new Edge(s,0));

            while (!priorityQueue.isEmpty()) {
                Edge curEdge = priorityQueue.poll();

                int curDestination = curEdge.destination;
                int curDistance = curEdge.distance;

                if (dist[curDestination] < curDistance) continue;


                List<Edge> nextEdge = graph.get(curDestination);
                for (int i=0; i<nextEdge.size(); i++) {
                    int nextDestination = nextEdge.get(i).destination;
                    int nextDistance = nextEdge.get(i).distance;

                    if (dist[nextDestination] >= curDistance + nextDistance) {
                        dist[nextDestination] = curDistance + nextDistance;
                        priorityQueue.offer(new Edge(nextDestination, dist[nextDestination]));
                    }
                }
            }

        }
    }

    static class Edge implements Comparable<Edge> {

        int destination;
        int distance;

        public Edge(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.distance, o.distance); // 오름차순
        }
    }
}
