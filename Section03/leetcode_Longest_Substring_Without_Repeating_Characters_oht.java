package Section03;

import java.util.ArrayList;
import java.util.List;

/**
 * 풀이시간 : 1시간
 * 접근방식 : 브루트 포스 방식으로 조건에 부합하는 문자열을 조합하다가
 * 조건이 불일치하는 순간,
 * max 길이와 비교 후,
 * 중복된 문자열 다음 부터 다시 탐색을 합니다.
 *
 * 예상 시간 복잡도 : O(N*N)
 */
public class leetcode_Longest_Substring_Without_Repeating_Characters_oht {

  public static void main(String[] args) {

    int expected = 3;
    String input = "abcabcbb";

    if (lengthOfLongestSubstring(input) != expected) {
      throw new IllegalStateException("잘못된 입력입니다.");
    } else {
      System.out.println("성공");
    }
  }

  public static int lengthOfLongestSubstring(String s) {

    char[] charArr = s.toCharArray();

    List<Character> subStr = new ArrayList<>();
    int max = 0;

    for (char c : charArr) {

      for (int j = 0; j < subStr.size(); j++) {

        if (subStr.get(j) == c) {

          max = Math.max(subStr.size(), max);
          subStr = subStr.subList(j + 1, subStr.size());
          break;
        }
      }

      subStr.add(c);
    }

    return Math.max(subStr.size(), max);
  }
}
