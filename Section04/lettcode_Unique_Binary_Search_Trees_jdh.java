/*
    풀이 시간: 15분
    예상 복잡도:
    풀이 방법: 규칙을 생각해보면 예를 들어 k = 3인 경우
              root로 1이 오는 경우 -> 2, 3은 무조건 오른쪽 자식이 될 수밖에 없음. 여기서 만들 수 있는 경우 2가지
              root로 2가 오는 경우 -> 1은 무조건 왼쪽, 3은 무조건 오른쪽 자식이 될 수밖에 없음. 경우 1가지
              root로 3이 오는 경우 -> 1, 2는 무조건 왼쪽 자식이 될 수밖에 없음. 여기서 만들 수 있는 경우 2가지
 */
public class lettcode_Unique_Binary_Search_Trees_jdh {
    public static int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++){
            for(int j = 0; j < i; j++){
                System.out.println(dp[j] + " - " + dp[i - 1 - j]);
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }

    public static void main(String args[]){
        System.out.println(numTrees(5));
    }
}
