package Section15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 풀이 시간 : 50분
 *
 * Input: S = "ababcbaca defegde hijhklij"
 * 풀이 방식 :
 * 1. 선형 탐색을 하면서 등장하는 알파벳의 시작과 끝 index를 저장합니다.
 * 2. label들은 각각 중복된 문자를 갖고 있지 않으므로 해당 규칙대로 라벨을 끊습니다.
 * 3. 라벨의 길이를 리스트에 각각 담습니다.
 *
 * 시간 복잡도 : O(N)
 */
public class leetcode_partitionLabels_oht {

  public List<Integer> partitionLabels(String S) {

    List<Integer> answer = new ArrayList<>();
    HashMap<Character, Position> partitionMap = new HashMap<>();
    List<Character> characters = new ArrayList<>();
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (!partitionMap.containsKey(ch)) {

        partitionMap.put(ch, new Position(i, i));
        characters.add(ch);
      } else {

        Position position = partitionMap.get(ch);
        position.end = i;
      }
    }


    Position first = partitionMap.get(S.charAt(0));
    int start = first.start;
    int end = first.end;

    for (char ch : characters) {

      Position position = partitionMap.get(ch);

      if (position.start > end) {

        answer.add(end - start + 1);
        start = position.start;
        end = position.end;
      }

      if (position.end > end) {

        end = position.end;
      }
    }

    answer.add(end - start + 1);

    return answer;
  }
}

class Position {

  int start;

  int end;

  public Position(int start, int end) {
    this.start = start;
    this.end = end;
  }
}