/*
 * 1. 풀이시간 : 초과
 * 2. 풀이방법
 * 탐색을 시작하는 노드에서 탐색 여부를 확인해서, 아직 탐색하지 않았으면 그 위치에서 dfs를 돌림
 * <탐색 조건>
 * (1) computers[row][col] 여기서 행, 열을 바꾼 computers[col][row] == 1 이어야 됨.
        (연결되어 있다는 뜻)
 * (2) 자기 자신이 아니어야함. (row != col)
 * (3) 아직 탐색 안 한 노드여야 함. (visited[index] == false)
 * 3. 예상 시간복잡도 : O(?)
 */
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];     //해당 노드 방문체크
        int cnt = 0;
        
        //전체 컴퓨터 방문
        for(int index=0; index<n; index++){
            //시작 위치에 이미 방문을 했으면 가지 않음
            if(!visited[index]){
                //첫 탐색 노드부터 재귀함수 시작
                dfs(index, computers, visited);
                //한 사이클을 돌면 연결된 네트워크가 생기므로, dfs가 모두 끝나고 나서 1을 증가시켜줌
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public void dfs(int index, int[][] computers, boolean[] visited){
        //방문했다고 표시
        visited[index] = true;
        
        //연결된 노드 중 조건에 맞는 것 탐색
        for(int i=0; i<computers.length; i++){
            //"1. 자신을 제외한 것 중에서 2. 연결된 노드이고 3. 아직 방문을 하지 않은 노드" 이면 탐색
            if(index != i && computers[i][index] == 1 && !visited[i]){
                dfs(i, computers, visited);
            }
        }
    }
}