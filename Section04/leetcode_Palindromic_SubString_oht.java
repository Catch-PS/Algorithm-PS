package Section04;

/**
 * 풀이시간 : 초과
 * 풀이 방식 : 문자의 인덱스를 통해 조합하여 만들 수 있는 순열의 수를 만들고, 회문 여부를 검사한 뒤 기록합니다.
 * 이를 통해 작은 부분의 결과가 큰 부분의 결과를 구하는 연산의 해가 되는 DP를 사용하면 해결할 수 있습니다.
 * 시간 복잡도 전체 경우의 수가 O(n^2/2) 정도이고, 이를 다 비교해보아야 하기 때문에 O(n^2) 정도 걸리리라고 생각됩니다.
 */
public class leetcode_Palindromic_SubString_oht {

  public int countSubstrings(String s) {

    int length = s.length();
    boolean[][] palindrome = new boolean[length][length];
    int cnt = 0;

    for (int j=0; j<length; j++) {
      for (int i=j; i>=0; i--) {

        if (i == j) {

          palindrome[i][j] = true;
          cnt++;

          continue;
        } // 한 문자의 경우 회문으로 사용

        if (s.charAt(i) == s.charAt(j)) {

          if (j-i <=2 || palindrome[i+1][j-1]) {
            palindrome[i][j] = true;
            cnt++;
          }// i, j 인덱스에 해당하는 문자가 같고, 이전 문자열이 회문이면 현재 i to j에 해당하는 palindrome[i][j]도 회문입니다.
        }//단, 문자가 2자리 순열이라면 두 자리 같으면 되기 때문에 이전 회문여부를 판단하지 않고 참, 거짓 여부가 결정됩니다.
      }
    }

    return cnt;
  }
}
