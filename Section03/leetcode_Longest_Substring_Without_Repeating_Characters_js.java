package Study.Section02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
#1 풀이시간 : 10분

#2 접근방식
Brute force로 풀었다
String 문자열을 char[] 배열로 바꾼 후, 하나씩 문자를 리스트에 넣다가 중복이 있으면 break 한다
result 값은 list의 사이즈가 더 크면 업데이트한다
그리고 최종적으로 result를 리턴한다

#3 시간복잡도
O(N*N)
 */

public class leetcode_Merge_Two_Sorted_Lists_js {
    public static void main(String[] args) {
        System.out.println("start");
        lengthOfLongestSubstring("dvdf");
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();

        for (int i=0; i<charArray.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j=i; j<charArray.length; j++) {
                if (list.contains(charArray[j])) break;
                list.add(charArray[j]);
            }
            if (list.size() > result) result = list.size();
        }
        return result;
    }
}
