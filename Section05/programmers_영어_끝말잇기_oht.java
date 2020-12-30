package Section05;

import java.util.HashMap;
import java.util.Map;

/**
 * 풀이 시간 : 15분
 * 풀이 방식 : 기준에 통과한 단어들을 HashMap에 저장하고, 해당 값의 중복 여부를 판단합니다.
 * 답은 각각 /, % 연산자를 통해 순서를 파악합니다.
 * 시간 복잡도 : O(N)
 */
public class programmers_영어_끝말잇기_oht {
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
        answer = new int[]{i%n + 1, i/n + 1};
        break;
      }
    }

    return answer;
  }
}
