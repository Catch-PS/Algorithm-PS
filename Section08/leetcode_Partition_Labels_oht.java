package Section08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 풀이 시간 : 20분
 *
 * 풀이 방법 : 주어진 문자열을 순차탐색하고, Hash에 StartPoint와 EndPoint를 저장하여 순회했습니다.
 *
 * ex) 0 1 2 3 4 5 6 7 8
 *     a b c b a c d f d
 *
 * 1. 주어진 문자열을 순회하여 Map에 다음과 같은 형태로 저장합니다.
 *        List      Map   Map
 *     characters  start  end
 *         a         0     4
 *         b         1     2
 *         c         2     5
 *         d         6     8
 *         f         7     7
 *
 * 2. characters 리스트를 다시 순회하면서 startPoint와 endPoint를 비교합니다.
 *  currentStart : 0
 *  currentEnd   : 0
 *
 * 3. a를 먼저 비교하면 currentStart와 currentEnd는 각각 0, 4로 갱신됩니다.
 *
 * 4. b를 비교하면 현재 EndPoint 보다 b의 EndPoint가 작으므로 Continue 합니다.
 * 5. c를 비교하면 현재 EndPoint 보다 c의 startPoint가 작지만 c의 EndPoint는 더 크기 때문에 EndPoint를 5로 갱신합니다.
 * 6. d의 경우, startPoint가 현재 EndPoint보다 크기 때문에 currentEnd - currentStart + 1 을 해준 뒤에 답을 리스트에 삽입하고,
 * currentStart와 currentEnd를 각각 d의 값으로 변경합니다.
 *
 * 이를 순차적으로 끝내게 되면 최종적으로 answers 리스트 안에는 원하는 값이 위치합니다.
 *
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(N)
 */
public class leetcode_Partition_Labels_oht {

  public List<Integer> partitionLabels(String S) {

    List<Character> characters = new ArrayList<>();
    HashMap<Character, Integer> startMap = new HashMap<>();
    HashMap<Character, Integer> endMap = new HashMap<>();
    List<Integer> answers = new ArrayList<>();

    scan(S, characters, startMap, endMap);
    seek(characters, startMap, endMap, answers);

    return answers;
  }

  private void seek(List<Character> characters, HashMap<Character, Integer> startMap,
                    HashMap<Character, Integer> endMap, List<Integer> answers) {

    int currentStart = 0;
    int currentEnd = 0;

    for (char ch : characters) {

      int startPoint = startMap.get(ch);
      int endPoint = endMap.get(ch);

      if (startPoint > currentEnd) {

        answers.add(currentEnd - currentStart + 1);
        currentStart = startPoint;
        currentEnd = endPoint;
      }

      if (endPoint > currentEnd) {

        currentEnd = endPoint;
      }
    }

    answers.add(currentEnd - currentStart + 1);

  }

  private void scan(String s, List<Character> characters,
                    HashMap<Character, Integer> startMap,
                    HashMap<Character, Integer> endMap) {

    for (int i=0; i<s.length(); i++) {

      char ch = s.charAt(i);

      if (!startMap.containsKey(ch)) {
        characters.add(ch);
        startMap.put(ch, i);
      }

      endMap.put(ch, i);
    }
  }
}
