package 스터디.스터디_SNU.Section10;
/**
 * 1. 문제풀이시간 35분
 * 2. 컴퓨팅 사고
 * (1) 조합 + 문자열
 * (2) 시작문자열을 바탕으로 주어진 문자열안에서 target값을 찾을때 까지의 카운팅을 세주는 문제입니다.
 * (3) 기준이되는것은 words의 문자열이기때문에 begin값과 모든 값을 탐색하여 한글자만 다른경우를 찾아줍니다.
 * (4) 한글자만 다른경우 DFS를 재수행하여 begin값이 target값과 같아지는 경우까지 진행합니다.
 * 3. 시간복잡도: 재귀 + O(N^2) 효율성으로는 좋아보이지않음.
 */
public class programmers_단어변환_kgh {
    static boolean[] check;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        solution("hit","cog",new String[]{"hot","dot","dog","lot","log","cog"});
        solution("hit","cog",new String[]{"hot","dot","dog","lot","log"});
    }

    static int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];

        // 모든 경우의 수 찾기
        dfs(begin, target,words,0);
        // testcase2: target이 words안에 없으므로 0 반환, basement조건에때 걸린적이 없을
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        System.out.println(answer);
        return answer;
    }

    private static void dfs(String begin, String target, String[] words, int min) {
        // 타겟과 같은 경우
        if(begin.equals(target)){
            answer = Math.min(answer, min);
            return;
        }

        for(int i=0; i<words.length; i++){
            // 체크된 문자열일 경우 건너뛰기
            if(check[i]){
                continue;
            }
            int cnt = 0;
            for(int j=0; j<words[i].length(); j++){
                // 시작점과 값이 같지 않을 경우, 즉 값이 1개만 다른 경우
                if(begin.charAt(j) != words[i].charAt(j)){
                    cnt++;
                }
            }
            // 값이 1개만 다를 경우 변환할 수 있는 단어이므로 다음 경우의수 진행
            if(cnt == 1){
                check[i] = true;
                dfs(words[i], target, words,min+1);
                check[i] = false;
            }
        }
    }
}
