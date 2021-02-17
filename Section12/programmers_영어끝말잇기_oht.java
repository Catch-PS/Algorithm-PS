package Section12;

import java.util.HashMap;
import java.util.Map;

/**
 * 풀이 시간 : 30분
 *
 * 풀이 방식 : HashMap 을 사용하여 풀었습니다.
 *
 * 시간 복잡도 : O(N)
 */

public class programmers_영어끝말잇기_oht {

  public int[] solution(int n, String[] words) {
    Map<String, Boolean> wordMap = new HashMap<>();
    wordMap.put(words[0], true);

    boolean isPassed = true;

    int[] answer = new int[]{0,0};
    for (int i=1; i<words.length; i++) {

      if (wordMap.get(words[i]) != null) {
        isPassed = false;
      }

      if (words[i].charAt(0) != words[i-1].charAt(words[i-1].length() - 1)) {
        isPassed = false;
      }

      if (isPassed) {

        wordMap.put(words[i], true);
      } else {

        answer = new int[]{i % n + 1, i / n + 1};// 규칙 위반된 상황이 발생하면 반복을 정지합니다.
        //i % n + 1은 탈락한 사람의 번호를 구하고, i / n + 1은 몇 번째 차례에 탈락했는지 구합니다.
        break;
     }
    }

    return answer;
  }
}
