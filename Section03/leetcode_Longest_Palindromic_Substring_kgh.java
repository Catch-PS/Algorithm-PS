package 스터디.스터디_SNU.Section03;

/**
 * 1. 시간초과
 * 2. 컴퓨팅사고
 * 시작점과 끝점의 문자가 같을 경우 펠린드롬 재귀함수를 호출합니다.
 * 예를 들어 b[abba]b와 같은 경우 a, a의 시작점과 끝점이 같으므로 값을 좁혀나가면서 재귀함수를 호출합니다.
 * 그리고 시작점이 끝보다 큰 경우까지만 진행하고 이미 메모이제이션에 저장된 경우 해당값을 사용합니다. 팰린드롬 일 경우:1, 아닐경우 -1
 * 3. 메모이제이션을 처리하므로 시간복잡도 O(len * len)
 */
public class leetcode_Longest_Palindromic_Substring_kgh {

    static int[][] dp;
    public static void main(String[] args) {
        System.out.println(solution("babad"));
    }
    private static String solution(String s) {
        int len = s.length();
        dp = new int[len][len];
        int max = 0;
        String answer = "";

        if(len <= 1){
            return s;
        }

        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                int size = j-i+1;
                int res = validationPalindromic(s,i,j);
                if(res == 1){
                    if(max < size){
                        max = size;
                        answer = s.substring(i,j+1);
                    }
                }
            }
        }
        return answer;
    }

    private static int validationPalindromic(String s, int start, int end) {
        // 시작이 끝보다 클 경우까지 진행
        if(start >= end){
            return 1;
        }

        // 메모이제이
        if(dp[start][end] != 0){
            return dp[start][end];
        }
        int res = -1;

        // 시작점과 끝점이 같은 문자열일 경우 b[abba]b
        if(s.charAt(start) == s.charAt(end)){
            res = validationPalindromic(s,start+1, end-1);
        }
        dp[start][end] = res;
        return res;
    }
}
