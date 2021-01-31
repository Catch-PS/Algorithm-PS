/*
 * 풀이시간 : 50분
 * 풀이방법
    1. begin을 words 안에 있는 문자들과 하나씩 비교
    2. count를 재귀 탐색할 때 같이 넘기며 탐색횟수 저장
    3. count가 words의 문자 개수와 동일하다면 일치하는 단어가 없으므로 0을 반환
 * 예상 시간복잡도 : ??
 */
class Solution {
    static int minConversion;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        minConversion = words.length;
        visited = new boolean[words.length];
		dfs(begin, target, 0, words);
        
        return minConversion == words.length ? 0 : minConversion;
    }
    
    public static void dfs(String presentWord, String target, int count, String[] words) {
		// "나온 단어 = 목표 단어"일 경우 count와 횟수 비교
        if(presentWord.equals(target)){
            minConversion = (minConversion > count) ? count : minConversion;
            return;
        }
        
        // dfs 탐색
        for(int i=0; i<words.length; i++){
            // 아직 방문하지 않았고, 글자가 1개만 차이난다면
            if(!visited[i] && check(presentWord, words[i])){
                visited[i] = true;
                dfs(words[i],target,count+1,words);
                visited[i] = false;
            }
        }
    }
    
    public static boolean check(String presentWord, String nextWord){
        int checkCnt = 0;
        
        // 단어 하나씩 체크
        for(int i=0; i<presentWord.length(); i++){
            if(presentWord.charAt(i) != nextWord.charAt(i)){
                checkCnt++;
            }
        }
        
        return checkCnt == 1 ? true : false;
    }
}