package Section19;
/**
 *  풀이 시간 : 40 분
 *  시간 복잡도 : O(N * K log(K))
 *              - N : length of strs
 *              - K : length of strs[i]
 *  문제 풀이:
 *  String 의 alphabet을 모두 Array of Charachter으로 변환하여 순서를 정렬
 *  key = alphabetically ordered word
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_groupAnagrams_ps {
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> wordList = new HashMap<>();
    for(String word : strs) {
      char[] ch = word.toCharArray();
      Arrays.sort(ch);
      String key = String.valueOf(ch);
      if(!wordList.containsKey(key)) {
        wordList.put(key, new ArrayList<>());
      }
      wordList.get(key).add(word);
    }
    return new ArrayList<>(wordList.values());
  }

  public static void main(String[] args) {
    String[] strs = {"ac", "d"};
    System.out.println(groupAnagrams(strs));
  }

}
