/*
    풀이 시간: 20분
    예상 시간복잡도: for 수행 O(n) * list.contains O(n) => O(n^2)
    풀이 방법: s를 하나씩 처리하면서 이전과 중복되는 문자이면 이전 위치를 찾아 처음부터 그 문자까지 삭제한 후 새로 리스트 생성,
            그리고 계속해서 max 값을 갱신
 */
public class leetcode_Longest_Substring_Without_Repeating_Characters_dh {
    public static int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<Character>();
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(list.contains(ch)) list.subList(0, list.indexOf(ch) + 1).clear();
            list.add(ch);

            result = Math.max(result, list.size());
        }

        return result;
    }

    public static void main(String args[]){
        int result = lengthOfLongestSubstring("dvdf");
        System.out.println(result);
    }
}
