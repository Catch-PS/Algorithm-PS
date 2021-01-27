package Section09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 풀이 시간 : 1시간
 *
 * 풀이 방식 : bfs를 사용하여 풀었습니다.
 *
 * 1 번 노드를 시작으로
 *      1
 *     / \    distance[0] = 2
 *   2    3
 *  / \    \  distance[1] = 3
 * 3   4    5
 *
 *
 * bfs를 돌고, 더 이상 현재 level에 노드가 존재하지 않으면 탐색을 멈추고, distance[level - 1]을 반환합니다.
 *
 * 시간복잡도 : O(N^2) 최악의 경우, 1-2-3-4-5-6 간선이 하나씩 연결되어 있을 때, 가장 느릴 것으로 예상됩니다.
 */
public class programmers_가장_먼_노드_oht {
  static final int FROM = 0;
  static final int TO = 1;

  public int solution(int n, int[][] edge) {

    boolean[][] vertex = new boolean[n][n];

    for (int i = 0; i < vertex.length; i++) {

      vertex[i][i] = true;
    }

    setDirections(edge, vertex);

    return bfs(vertex);
  }

  private void setDirections(final int[][] edge, boolean[][] vertex) {

    Arrays.stream(edge).forEach(v -> {
      vertex[v[FROM] - 1][v[TO] - 1] = true;
      vertex[v[TO] - 1][v[FROM] - 1] = true;
    });
  }

  private int bfs(final boolean[][] vertex) {

    Queue<Integer> queue = new LinkedList<>();

    boolean[] visited = new boolean[vertex.length];
    int[] distance = new int[vertex.length];

    int level = 0;

    queue.add(0);

    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int j = 0; j < size; j++) {

        int v = queue.poll();

        for (int i = 0; i < vertex[v].length; i++) {

          if (vertex[v][i] && !visited[i]) {

            visited[i] = true;

            if (v != i) {

              queue.add(i);
              distance[level]++;
            }
          }
        }
      }

      if (distance[level] == 0) {

        break;
      }

      level++;
    }

    return level == 0 ? distance[level] : distance[level - 1];
  }
}
