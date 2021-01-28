package 스터디.스터디_SNU.Section10;

/**
 * 1. 문제 풀이 시간: 22분
 * 2. 컴퓨팅 사고
 * (1) DFS로 모든 경우의 조합을 찾아냅니다.
 * (2) 입력으로 주어진 문자를 체크하는 변수, 해당 문자가 소수를 체크하는 변수
 * (3) Basement 조건, 현재까지 누적된 문자열이 ""이 아니고, 현재 체크된 소수가 아닐 경우 해당 DFS 종료
 * (4) 소수를 구하는 Prime함수 선언
 * 일반적으로 2-N까지 구하는 소수 방식을 사용하지 않고 2의배수, 3의배수.....N의 배수만큼 진행하면서 값을 체킹하면 sqrt N 까지만 진행하여도 모든 소수를 구할 수 있기때문에 해당 방법을 사용하였습니다.
 * 3. 시간복잡도
 * DFS 재귀 + 소수 판별 함수
 *
 */
public class programmers_소수찾기_kgh {
    static boolean[] isCheck;
    static boolean[] isStrCheck;
    static int answer = 0;
    public static void main(String[] args) {
        System.out.println(solution("17"));
    }
    static int solution(String numbers) {
        isCheck = new boolean[numbers.length()];
        isStrCheck = new boolean[10000000];
        dfs(numbers, "");
        return answer;
    }
    private static void dfs(String numbers, String s) {
        if(!"".equals(s) && !isStrCheck[Integer.parseInt(s)]){
            isStrCheck[Integer.parseInt(s)] = true;
            if(isPrime(Integer.parseInt(s))) answer++;
        }
        for(int i=0; i<numbers.length(); i++){
            if(isCheck[i]){
                continue;
            }
            isCheck[i] = true;
            dfs(numbers, s+numbers.charAt(i));
            isCheck[i] = false;
        }
    }
    private static boolean isPrime(int num) {
        if(num < 2){
            return false;
        }
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
