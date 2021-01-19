package Section08;

import java.util.LinkedList;

/**
 * 풀이 시간 : 초과
 *
 * 풀이 방식 : bfs를 사용해서 노드를 돌면서 상, 하, 좌, 우, 회전하는 경로를 체크했습니다.
 *
 * 시간복잡도
 * 공간복잡도 : O(2 * N^2)
 */
public class programmers_블록_이동하기_oht {

  private static final int HORIZONTAL = 0;
  private static final int VERTICAL = 1;

  public int solution(int[][] board) {

    int answer = 0;

    int[][] copy = new int[board.length + 2][board[0].length + 2];
    boolean[][][] checked = new boolean[copy.length][copy[0].length][2];

    copyBigSizeArray(copy, board);

    LinkedList<Node> queue = new LinkedList<>();

    answer = bfs(queue, copy, checked);

    return answer;
  }

  private int bfs(LinkedList<Node> queue, int[][] copy, boolean[][][] checked) {

    int answer = 0;
    int indexLength = copy.length - 1;
    queue.add(new Node(1, 1, HORIZONTAL, 0)); // 시작 지점

    while (!queue.isEmpty()) {

      Node node = queue.poll();
      int x = node.getX();
      int y = node.getY();
      int status = node.getStatus();
      int time = node.getTime();

      if (checked[y][x][status]) {

        continue;
      }// 이미 체크한 노드는 더이상 체크하지 않습니다.

      if (x == indexLength - 1 && y == indexLength - 1) {

        answer = time - 1;
        break;
      } // 최종 노드에 도착하면 지금까지 계산한 시간을 반환하고 탐색을 종료합니다.

      checked[y][x][status] = true;

      if (status == HORIZONTAL) {

        if (copy[y][x] == 1 || copy[y][x + 1] == 1) {

          continue;
        } // 현재 노드에 1이 하나라도 포함되어 있으면 통과합니다. (여기서 부터는 이동할 수 없기 때문)

        moveHorizontal(queue, x, y, time); // 수평으로 된 노드에서 상, 하, 좌, 우로 움직입니다.

        rotateHorizontalToVertical(queue, copy, x, y, time);
        // 수평으로 된 노드에서 회전하는 경우의 수를 queue에 삽입합니다.

      } else {

        if (copy[y][x] == 1 || copy[y + 1][x] == 1) {

          continue;
        }

        moveVertical(queue, x, y, time);

        rotateVerticalToHorizontal(queue, copy, x, y, time);
      }

    }

    return answer;
  }

  private void moveVertical(LinkedList<Node> queue, int x, int y, int time) {

    queue.add(new Node(x, y + 1, VERTICAL, time + 1));
    queue.add(new Node(x + 1, y, VERTICAL, time + 1));
    queue.add(new Node(x - 1, y, VERTICAL, time + 1));
    queue.add(new Node(x, y - 1, VERTICAL, time + 1));
  }

  private void moveHorizontal(LinkedList<Node> queue, int x, int y, int time) {

    queue.add(new Node(x + 1, y, HORIZONTAL, time + 1));
    queue.add(new Node(x, y + 1, HORIZONTAL, time + 1));
    queue.add(new Node(x - 1, y, HORIZONTAL, time + 1));
    queue.add(new Node(x, y - 1, HORIZONTAL, time + 1));
  }

  private void rotateHorizontalToVertical(LinkedList<Node> queue, int[][] copy,
                                          int x, int y, int time) {

    if (copy[y + 1][x + 1] != 1 && copy[y + 1][x] != 1) {// 노드가 위쪽에 있을 때

      queue.add(new Node(x, y, VERTICAL, time + 1));
      queue.add(new Node(x + 1, y, VERTICAL, time + 1));
    }

    if (copy[y - 1][x + 1] != 1 && copy[y - 1][x] != 1) {// 노드가 아래 쪽에 있을 때

      queue.add(new Node(x, y - 1, VERTICAL, time + 1));
      queue.add(new Node(x + 1, y - 1, VERTICAL, time + 1));
    }
  }

  private void rotateVerticalToHorizontal(LinkedList<Node> queue, int[][] copy,
                                          int x, int y, int time) {

    if (copy[y + 1][x + 1] != 1 && copy[y][x + 1] != 1) {// 노드가 왼쪽에 있을 때

      queue.add(new Node(x, y, HORIZONTAL, time + 1));
      queue.add(new Node(x, y + 1, HORIZONTAL, time + 1));
    }

    if (copy[y + 1][x - 1] != 1 && copy[y][x - 1] != 1) {// 노드가 오른 쪽에 있을 때

      queue.add(new Node(x - 1, y, HORIZONTAL, time + 1));
      queue.add(new Node(x - 1, y + 1, HORIZONTAL, time + 1));
    }
  }

  private void copyBigSizeArray(int[][] copy, int[][] board) {

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy.length; j++) {

        if (i == 0 || j == 0 || i == board.length + 1|| j == board.length + 1) {

          copy[i][j] = 1;
          continue;
        }
        copy[i][j] = board[i - 1][j - 1];
      }
    }
  }
}

class Node {

  int x;

  int y;

  int status;

  int time;

  public Node(int x, int y, int status, int time) {
    this.x = x;
    this.y = y;
    this.status = status;
    this.time = time;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getStatus() {
    return status;
  }

  public int getTime() {
    return time;
  }
}

