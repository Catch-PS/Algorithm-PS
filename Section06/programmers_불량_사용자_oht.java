package Section06;

import java.util.*;

/**
 * 풀이 시간 : 초과
 * 풀이 방식 : 구현에 초점을 두고 풀었습니다.
 * 1. 이차원 리스트에 금지 아이디 목록의 경우의 수를 저장합니다.
 * { fr*d* {"frodo", "fradi"},
 *   *rodo {"frodo", "crodo"},
 *  ****** {"abc123", "frodoc"},
 *  ****** {"abc123", "frodoc"}}
 *
 *  2. set에 비교대상의 id가 존재하지 않으면 set에 삽입합니다.
 *  3. 결과 리스트를 최종적으로 구하고, 중복을 제거합니다.
 *  시간 복잡도 : O(n^3) ?
 */
public class programmers_불량_사용자_oht {
  public int solution(String[] user_id, String[] banned_id) {
    List<LinkedList<String>> bannedIdArrays = new ArrayList<>();
    classify(bannedIdArrays, user_id, banned_id);

    return calculate(bannedIdArrays);
  }

  private void classify(List<LinkedList<String>> bannedIdArrays, String[] user_id, String[] banned_id) {

    for (String value : banned_id) {

      LinkedList<String> matchIds = new LinkedList<>();

      for (String s : user_id) {

        if (isMatch(s, value)) {
          matchIds.add(s);
        }
      }

      bannedIdArrays.add(matchIds);
    }
  }

  private boolean isMatch(String userId, String bannedId) {

    if (userId.length() != bannedId.length()) {

      return false;
    }

    int cnt = 0;

    for (int i=0; i<userId.length(); i++) {

      if (bannedId.charAt(i) == '*') {
        cnt++;

      } else if (userId.charAt(i) == bannedId.charAt(i)) {

        cnt++;
      }
    }

    return userId.length() == cnt;
  }

  private int calculate(List<LinkedList<String>> bannedIdArrays) {

    LinkedList<Set<String>> answerSets = new LinkedList<>();

    for (LinkedList<String> bannedIds : bannedIdArrays) {

      combination(bannedIds, answerSets);
    }

    Set<Set<String>> set = new HashSet<>(answerSets);

    return set.size();
  }

  private void combination(LinkedList<String> cmp, LinkedList<Set<String>> answerSets) {

    if (answerSets.isEmpty()) {
      while (!cmp.isEmpty()) {
        Set<String> tmp = new HashSet<>();
        tmp.add(cmp.poll());
        answerSets.add(tmp);
      }
    } else {
      int length = answerSets.size();

      for (int i = 0; i < length; i++) {

        Set<String> answer = answerSets.pollFirst();

        for (int j = 0; j < cmp.size(); j++) {
          String bannedId = cmp.pollFirst();
          if (answer.contains(bannedId)) {
            cmp.addLast(bannedId);
            continue;
          }

          Set<String> newAnswer = new HashSet<>(answer);
          newAnswer.add(bannedId);
          answerSets.addLast(newAnswer);
          cmp.addLast(bannedId);
        }
      }
    }
  }
}
