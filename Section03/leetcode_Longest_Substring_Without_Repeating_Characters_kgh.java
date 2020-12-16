package 스터디_SNU.Section03;

/* 연속되는 문자열 찾기
1. 풀이 시간 체크: 50분
2. 컴퓨팅사고:
start,end 포인터 지점을 체크하는 변수를 만듭니다.
1) hashset에 포함되지 않았을 경우
Hashset을 사용하여 문자별 체크를 진행하고 포함되지 않은 문자가 나타났을 경우 해당 문자값을 Hashset에 Add시키고 end포인터를 이동시킵니다.
ans의 값과 end-start점을 통해서 ans값보다 큰값일 경우 해당 길이를 갱신시켜줍니다.

2) hashset이 포함된 경우
해당 문자를 Hashset에서 제거하고 start 포인터를 증가시켜줍니다.

3. 자신이 생각하는 시간복잡도
O(N start +N end) => O(2N) 상수를 무시하므로 => O(N)
*/
import java.io.IOException;
import java.util.HashSet;


public class leetcode_Longest_Substring_Without_Repeating_Characters_kgh {
    public static void main(String[] args) throws IOException {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    // 중복없는 연속된 문자열을 찾는문제
    static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        int ans = 0;
        int start = 0;
        int end = 0;
        while (start < n && end < n) {
            // hashset에 포함되지 않았을 경우 해당 문자 add
            if (!hs.contains(s.charAt(end))){
                hs.add(s.charAt(end));
                end++;            // 끝 위치 증가
                ans = Math.max(ans, end - start);
            }
            // hashset에 포함 되었을 경우 해당 문제 삭제
            else {
                hs.remove(s.charAt(start));
                start++;            // 시작 위치 증가
            }
        }
        return ans;
    }
}