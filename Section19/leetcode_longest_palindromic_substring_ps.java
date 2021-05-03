package Section19;
/**
 *  풀이 시간 : 30 분
 *  시간 복잡도 : O(N)^3
 *  문제 풀이 :
 *  - substring 구하기 : 글자 하나하나씩 움직이며 substring 생성
 *  - isPalindrome : 양쪽 끝을 탐색하며 동일한지 확인하기
 *  - maxWord : 가장 긴 펠린드롬 찾기
 *
 */

public class leetcode_longest_palindromic_substring_ps {
  public static String maxWord;

  public static String longestPalindrome(String s) {
    maxWord = "";
    for(int start = 0; start < s.length(); start++) {
      for(int end = start; end < s.length(); end++) {
        String word = s.substring(start, end+1);
        if(maxWord.length() < word.length() && isPalindrome(word)) {
          maxWord = word;
        }

      }

    }
    return maxWord;
  }

  public static boolean isPalindrome(String word) {
    int start = 0;
    int end = word.length()-1;
    while(start < end) {
      if(word.charAt(start) != word.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    longestPalindrome("babad");
  }

}
