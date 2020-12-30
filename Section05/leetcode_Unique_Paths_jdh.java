/*
    풀이 시간: 20분
    예상 시간복잡도: O(m * n)
    풀이 방법: 처음에 DFS 방식의 Back-Tracking으로 접근했으나 LTE가 나왔습니다. 그래서 다른 방법으로 생각하게 되었고 한 정점으로 갈 수 있는 방법은
            오른 방향 혹은 아래 방향으로만 갈 수 있으므로 규칙이 간단해집니다.
            1행에 위치한 정점들 갈 수 있는 경우의 수는 오른 방향밖에 없기 때문에 모두 하나의 경우의 수만 가지게 됩니다. 마찬가지로 1열에 위치한 정점들도
            아래방향이라는 하나의 경우의 수만 가지므로 경우의 수는 1이 됩니다.
            그리고 다른 정점들의 경우 규칙을 보면 바로 왼쪽 정점이 가지는 경우의 수 + 바로 위 정점이 가지는 경우의 수입니다.
            따라서 이러한 규칙으로 m * n의 map을 모두 채우고 도착점에 저장된 경우의 수를 반환해주면 됩니다.
 */
public class leetcode_Unique_Paths_jdh {
    public static int uniquePaths(int m, int n) {
        int map[][] = new int[m][n];

        for(int i = 0; i < m; i++) map[i][0] = 1;
        for(int i = 0; i < n; i++) map[0][i] = 1;

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] = map[i][j - 1] + map[i - 1][j];
            }
        }
        return map[m - 1][n - 1];
    }

    public static void main(String args[]){
        System.out.println(uniquePaths(3, 7));
    }
}
