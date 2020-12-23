package 스터디.스터디_SNU.Section04;
/**
 * 1. 문제풀이시간: 50분
 * 2. 홀수,짝수 팰린드롬의 경우를 나누어서 처리한다. 그리고 각 문자열의 start,end포인트를 설정하고 범위를 체크한다.
 * 첫문자와 끝문자가 그값은 팰린드롬으로 판단할 수 있다. 그게 아닌경우 다음 경우의 수로 이동한다.
 * 하위문자열이 팰린드롬인 경우 팰린들모의 개수를 리턴한다.
 * 3. 시간복잡도 O(2 * s.length) => O(s.length)
 */
public class leetcode_palindromic_substrings_kgh {
    public static void main(String[] args) {
        countSubstrings("abc");
        countSubstrings("aaa");
    }

    private static void countSubstrings(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            cnt += palindromes(s, i, i);
            cnt += palindromes(s, i, i+1);
        }
        System.out.println(cnt);
    }
    private static int palindromes(String s, int start, int end) {
        int cnt = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            cnt++;
        }
        return cnt;
    }

}
