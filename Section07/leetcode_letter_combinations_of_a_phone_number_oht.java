package Section07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 풀이시간 : 30분
 * 풀이방식 : dfs로 순회하면서 만들 수 있는 문자열 조합을 모두 구했습니다.
 * 시간 복잡도 :
 */
public class leetcode_letter_combinations_of_a_phone_number_oht {
  public List<String> letterCombinations(String digits) {

    Map<Integer, String> map = new HashMap<>();

    List<String> combinations = new ArrayList<>();

    map.put(2, "abc");
    map.put(3, "def");
    map.put(4, "ghi");
    map.put(5, "jkl");
    map.put(6, "mno");
    map.put(7, "pqrs");
    map.put(8, "tuv");
    map.put(9, "wxyz");

    if (digits.isEmpty()) {

      return combinations;
    }

    dfs(digits, new StringBuilder(), map, combinations);

    return combinations;
  }

  private void dfs (String digits, StringBuilder answer, Map<Integer, String> map, List<String> combinations) {

    if (digits.isEmpty()) {

      combinations.add(answer.toString());
      return;
    }

    int digit = digits.charAt(0) - '0';

    String values = map.get(digit);

    for(int i=0; i<values.length(); i++) {

      StringBuilder sb = new StringBuilder(answer.append(values.charAt(i)));
      dfs(digits.substring(1), sb, map, combinations);
      answer.deleteCharAt(answer.length()-1);
    }

  }
}
