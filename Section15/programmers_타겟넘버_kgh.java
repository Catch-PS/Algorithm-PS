package 스터디.스터디_SNU.Section15;

/**
 * 1. 문제풀이시간: 10분
 * 2. 컴퓨팅사고
 * (1) +배열값을 더하는 경우, -배열값을 빼는 경우 두가지에서 DFS를 수행합니다.
 * (2) number의 길이만큼 도달하였을때 해당되는 dfs를 종료시킵니다.
 * (3) number의 길이만큼 도달하였을때 target값인지 아닌지를 확인합니다.
 * target값과 같다면 answer값을 증가시키고 아니라면 dfs수행을 종료합니다.
 * 3. 시간복잡도
 * O(DFS 수행 속도)
 */
public class programmers_타겟넘버_kgh {
    static int answer = 0;
    public static void main(String[] args) {
        solution(new int[]{1,1,1,1,1}, 3);
    }
    static int solution(int[] numbers, int target) {
        dfs(0,0, numbers, target);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(int cnt,int sum, int[] numbers, int target) {
        if(cnt == numbers.length){
            if(sum == target) answer++;
            return;
        }
        dfs(cnt+1, sum+numbers[cnt], numbers, target);
        dfs(cnt+1, sum-numbers[cnt], numbers, target);
    }
}
