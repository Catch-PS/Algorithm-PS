package 스터디.스터디_SNU.Section10;

/**
 * 1. 문제풀이시간: 55분
 * 2. 컴퓨팅사
 * 이전에 풀어봤던 i!=0, j!=0의 조건을 제대로 찾지못하였던 문제였습니다.
 * 개인적으로 이것도 경우의수처럼 구할 수 있다고 생각하였는데, 그게 아니였습니다.
 *
 * (1) m,n의 변수가 반대로 입력이 주어지는것에 주의해야합니다.
 * (2) dp를 통해서 처음 출발지를 0,0으로 지정해주었습니다. 기존의 입력이 1,1부터 시작하지만 0,0인덱스부터 사직하기위해서 puddles-1의 값을 사용하였습니다.
 * (3) 웅덩이의 값은 -1로 초기화 시키고 만약 메모이제이션진행시 웅덩이를 찾으면 현지 그값은 0으로 갱신하여 다음값은 웅덩이의 값을 0으로 두고 시작합니다.
 * (4) i,j의 값을 i!=0, j!=0이 아닌 경우 즉, left,top의 범위를 체크하면서 left의 경우의수, top의 경우의 수를 각각의 경우로 처리하여 진행하였습니다.
 * 값이 범위를 벗어날 수 있기때문에 10e10+7를 나눈값으로 정의합니다. 즉, int의 최댓값을 뜻합니다.
 *
 * 3.시간복잡도
 * O(N^2)
 */

public class programmers_등굣길_kgh {
    static int[][] dp;
    public static void main(String[] args) {
        solution1(4,3,new int[][]{{2,2}});

    }
    /**
     * 실제 정답
     * @param m
     * @param n
     * @param puddles
     * @return
     */
    static int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        dp[0][0] = 1;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                // 웅덩이 0으로 처리
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                // top 범위 벗어나지 않는 경우
                if(i != 0){
                    dp[i][j] += (dp[i-1][j] % 1000000007);
                }
                // left 범위 벗어나지 않는 경우
                if(j != 0){
                    dp[i][j] += (dp[i][j-1] % 1000000007);
                }
            }
        }
        return (dp[n-1][m-1] % 1000000007);
    }
    /**
     * 75%정답률
     * @param m
     * @param n
     * @param puddles
     */
    private static void solution1(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        for(int i=0; i<=m; i++){
            dp[0][i] = 1;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        dp[0][0] = 1;
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                }
                dp[i][j] += (dp[i-1][j] % 1000000007) + (dp[i][j-1] % 1000000007);
            }
        }
        System.out.println(dp[n-1][m-1] % 1000000007);

    }
}
