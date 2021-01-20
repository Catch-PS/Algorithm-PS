package 스터디.스터디_SNU.Section08;

/**
 * 1. 문제 풀이 시간: 20분
 * 2. 홀 / 짝나누어서 팰린드롬을 탐색합니다.
 * 여기서 가장 중요한점은 기준점을 잡아서 완전탐색을 진행하고 start를 -- 해주고, end점은 ++해주는것이고 시작점과 끝점이 같을때만 진행된다는 점입니다.
 * 3. 해당 기준점탐색을 돈 후에 해당점에 대한 팰린드롬의 idx값이 start,end값을 가지고 substring을 통한 해당 문자열의 길이를 구해서 리턴해주었습니다.
 */
public class programmers_가장긴팰린드롬_kgh {
    public static void main(String[] args) {
//        solution("abcbcba");
        solution("abacde");
    }
    static int solution(String s)
    {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            answer = Math.max(palindrom(s, i,i),answer);
            answer = Math.max(palindrom(s, i,i+1), answer);
        }
        System.out.println(answer);
        return answer;
    }
    static int palindrom(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return (s.substring(start+1,end)).length();
    }
}
