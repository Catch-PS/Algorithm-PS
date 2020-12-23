/*
    풀이 시간: 12분
    예상 시간복잡도:
    풀이 방법: 글자 개별은 모두 palindrome으로 생각할 수 있으므로 먼저 글자 수만큼 result를 셋팅
              글자를 하나씩 늘리면서 palindrome이 맞는지 확인(isPalindrome 함수)
              isPalindrome -> loop를 돌 때마다 시작점은 한 칸 뒤로, 종료점은 한 칸 앞으로 설정해서 각 위치의 글자가 일치하는지 판단
 */
public class leetcode_Palindromic_Substrings_jdh {

    public static char chArr[];

    public static int countSubstrings(String s) {
        int result = s.length();
        chArr = s.toCharArray();

        for(int i = 1; i < s.length(); i++){
            for(int j = 0; j < s.length() - i; j++){
                if(isPalindrome(j, j + i)) {
                    result++;
                }
            }
        }

        return result;
    }

    public static boolean isPalindrome(int start, int end){
        while(start < end){
            if(chArr[start] != chArr[end]) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }


    public static void main(String args[]){
        // System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
