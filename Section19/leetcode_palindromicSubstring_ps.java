package Section19;

/**
 *  풀이 시간 : 10 분
 *  시간 복잡도 : O(N)^3
 *  문제 풀이 :
 *  - substring 구하는 방법 : start = end = 0 부터 시작해서 점점 문자열의 길이를 점점 늘려간다.
 *  - isPalindrome :
 *    s.charAt(start) == s.charAt(end);
 *    문자열 한자리 한자리를 끝자리 부터 비교해서 동일한지 확인한다.
 *
 */

public class leetcode_palindromicSubstring_ps {
  private static int answer;

  public static int countSubstrings(String s) {
    answer = 0;
    int leng = s.length();
    for(int start = 0; start < leng; start++) {
      for(int end = start; end < leng; end++) {
        isPalindrome(s, start, end);
      }
    }
    return answer;

  }

  public static boolean isPalindrome(String s, int start, int end) {
    while(start < end) {
      if(s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    answer++;
    return true;
  }

  public static void main(String[] args) {
    countSubstrings("abc");
  }

}
