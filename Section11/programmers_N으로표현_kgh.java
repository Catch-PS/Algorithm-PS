package 스터디.스터디_SNU.Section11;

/**
 * 1. 문제풀이시간: 초과
 * 2. 컴퓨팅사고
 * DFS를 통하여 모든 연산의 경우를 모두 구해주었습니다. 생각보다 까다로웠고 어려웠던 문제라고 생각이듭니다.
 * (1) -1 return 조건: 숫자 사용 개수(cnt)가 8개 넘어가는경우 [최솟값이 8보다 크면 -1을 return 합니다.]의 조건이 있기 때문에 -1을 리턴을 시켜주게 되었습니다.
 * (2) 최솟값 갱신 return 조건:재귀함수를 돌다가 값을 처음 찾은 경우(-1) 현재 카운팅값을 넣어주거나 더 낮은 cnt값을 찾은 경우 answer에 넣어줍니다.
 * (3) for문으로 숫자 사용 최대 개수만큼을 돌려주고 DFS 진행시 횟수를 1씩 줄여나갑니다.
 * 예) 5 -> 7개 오기 가능, 55 -> 6개 오기가능
 * (4) 자리수를 계속해서 갱신시키는 방법은
 * value = value * 10 + n 이런형식으로 처리 할 수 있습니다.
 * 예)
 * value=5, 5 * 10 + 5 = 55 갱신
 * value=55, 55 * 10 + 5 = 555 갱신
 *
 * DP로 푸는문제라고 해서 DP로 푸신분들 코드를 보니 TreeSet을 사용해서 풀이를 진행하던데 일단 가장 이해가 쉬웠던 DFS로 풀었습니다.
 * 3. 시간복잡도
 * O(DFS 재귀)
 *
 */
public class programmers_N으로표현_kgh {
    static int answer = -1;
    public static void main(String[] args) {
        solution(2, 11);
        solution(5, 12);
    }
    static int solution(int N, int number) {
        dfs(N,number, 0,0);
        System.out.println(answer);
        return 0;
    }
    private static void dfs(int n, int number,int sum, int cnt) {
        // N 사용 횟수가 8이 넘어가면 -1을 반환
        if(cnt > 8){
            answer = -1;
            return;
        }
        // 최소 답을 만났을 경우
        if(number == sum){
            // 처음에 들어왔던 경우나 더 작은 값을 찾은경우 갱신시켜줍니다.
            if(answer == -1 || answer > cnt) {
                answer = cnt;
            }
            return;
        }
        int value = n;
        // 남은 최소의 개수만큼 사칙연산 경우 모두 탐색
        for(int i=0; i<8-cnt; i++){
            dfs(n,number,(sum+value),cnt+i+1);
            dfs(n,number,(sum-value),cnt+i+1);
            dfs(n,number,(sum*value),cnt+i+1);
            dfs(n,number,(sum/value),cnt+i+1);
            value = value * 10 + n;
        }
    }
}
