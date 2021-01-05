/*
 * 1. 풀이시간 : 15분
 * 2. 풀이방법 : 재귀를 사용해서 depth를 사용해서 계속 타고 들어가는 식으로 구현했습니다.
                visited 배열을 두고 방문한 곳은 다시 못 가도록 했습니다.
                그리고 depth가 끝까지 가서 permutation이라는 재귀 함수를 반환할 경우, visited 배열을 false로 바꿔줌으로써 그 전 단계에서 다시 탐색 시작이 가능하도록 했습니다.(그 전 단계 기준으로 다음 depth에 있는 숫자를 탐색 안한 경우까지도 탐색해야하므로)
 * 3. 시간복잡도 : 
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length();  // 제시된 배열의 숫자 개수
        int r = nums.length();  // 뽑을 개수
        boolean[] visited = new new boolean[n]; // 방문 체크
        int[] answer = new int[r];
        
        permutation(n, r, nums, visited, answer, 0);
    }
    
    public static void permutation(int n, int r, int[] input, boolean[] visited, int[] answer, int depth) {
        // 제시된 숫자의 개수만큼 타고 들어갔을 때 종료
        if(depth == r) {
            print(answer);
            
            return;
        }
        
        // 재귀 호출
        for(int i=0; i<n; i++){
            //방문한 곳이 아니라면 탐색
            if(!visited[i]) {
                visited[i] = true;      //방문했다고 표시
                answer[depth] = input[i];
                permutation(n, r, input, visited, answer, depth+1);     //재귀호출
                visited[i] = false;     //재귀를 타고 들어갔다가 나오면서 false를 만들어줘야 그 전 단계 탐색 가능
            }
        }
    }
}