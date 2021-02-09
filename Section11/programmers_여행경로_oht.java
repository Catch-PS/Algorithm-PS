package Section11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 풀이시간 : 초과
 *
 * 풀이 방식 : dfs를 사용하여 풀었습니다.
 *
 */
public class programmers_여행경로_oht {
  public String[] solution(String[][] tickets) {

    boolean[] visited = new boolean[tickets.length];
    List<String> answers = new ArrayList<>();
    String answer = "ICN";
    dfs(0, "ICN", answer, tickets, visited, answers);

    Collections.sort(answers);
    return answers.get(0).split(",");
  }

  private void dfs(int cnt, String current, String answer, String[][] tickets,
                   boolean[] visited, List<String> answers) {

    if (cnt == tickets.length) {
      answers.add(answer);
      return;
    } // 모든 티켓을 사용하면 정답을 추가하고 깊이탐색을 빠져나옵니다.

    for (int i = 0; i< tickets.length; i++) {
      if (!visited[i] && tickets[i][0].equals(current)) {
        //이전에 사용하지 않은 티켓 중 현재 위치에서 출발하는 티켓을 찾아 깊이 탐색을 진행합니다.
        dfs(cnt + 1, tickets[i][1],
                answer + "," + tickets[i][1], tickets, visited, answers);
        visited[i] = false;
      }
    }
  }
}
