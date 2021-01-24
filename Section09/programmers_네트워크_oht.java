package Section09;

import java.util.Stack;

/**
 * 풀이 시간 : 40분
 *
 * 풀이 방식 : 깊이 우선 탐색을 통해 네트워크를 구하고,
 * 이미 방문한 노드는 체크하여 제외하는 방식으로 풀었습니다.
 *
 * 시간 복잡도 : 최악의 경우, 모든 노드가 개별 네트워크를 가질 때, O(N^2)이 될 것으로 예상됩니다
 */
public class programmers_네트워크_oht {

  public int solution(int n, int[][] computers) {

    int cnt = 0;
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {

      if (visited[i]) {

        continue;
      }

      dfs(computers, i, visited);
      cnt++;
    }

    return cnt;
  }

  private void dfs(int[][] computers, int v, boolean[] visited) {

    Stack<Integer> stack = new Stack<>();

    stack.push(v);

    while (!stack.isEmpty()) {

      int node = stack.pop();

      for (int i = 0; i < computers[node].length; i++) {

        if (visited[i]) {

          continue;
        }

        if (computers[node][i] == 1) {

          visited[i] = true;
          stack.push(i);
        }
      }
    }
  }
}
