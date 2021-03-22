/*
    풀이 시간: 6분
    예상 시간복잡도: ...?
    풀이 방법: DFS를 이용하여 Combination 수행
 */

public class programmers_타겟넘버_jdh {
    public static int answer;

    public static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    public static void dfs(int cnt, int sum, int numbers[], int target){
        if(cnt == numbers.length){
            if(sum == target) answer++;
            return;
        }

        dfs(cnt + 1, sum + numbers[cnt], numbers, target);
        dfs(cnt + 1, sum - numbers[cnt], numbers, target);
    }

    public static void main(String args[]){
        int numbers[] = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
