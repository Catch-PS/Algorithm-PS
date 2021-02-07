import java.util.*;
/*
 * 1. 풀이시간 : 45분
 * 2. 풀이방법
        처음에 ["ICN", "~~~"]인 부분을 찾음
        ["ICN", "~~~"] -> [start, end]
        ["~~~", "###"] -> [nextStart, nextEnd]
        end와 nextStart가 일치하는지 확인해서 일치하면 cnt 증가시키고 계속 탐색 (재귀 호출)
        "ICN,SFO,ATL,ICN,ATL,SFO" / "ICN,ATL,ICN,SFO,ATL,SFO" 이렇게 모든 경우의 수를 list에 넣음
        list를 정렬한 후에 가장 앞에 위치하고 있는 문자열을 뽑아서 출력
 * 3. 예상 시간복잡도 : O(?)
 */
class Solution {
    static List<String> list = new ArrayList<>();
    static String route;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        for(int i=0; i<tickets.length; i++){
            
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            // 시작 값이 ICN이면 dfs 탐색
            if(start.equals("ICN")){
                route = start + ",";
                visited[i] = true;
                dfs(tickets, end, 1);
                visited[i] = false;
            }
        }
        
        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        
        return answer;
    }
    
    public static void dfs(String[][] tickets, String end, int cnt){
        route += end + ",";
        
        // 모든 배열을 다 탐색했을 경우
        if(cnt == tickets.length){
            // 하나의 경로를 list에 넣음
            // 모든 경우의 경로가 list에 들어감
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            String nextStart = tickets[i][0];
            String nextEnd = tickets[i][1];
            
            // 다음으로 탐색할 start(=nextStart)가 현재의 end(=end)와 같다면 다음 단계 탐색
            if(nextStart.equals(end) && !visited[i]) {
                visited[i] = true;      // 탐색한 행을 다시 탐색 못하도록 함
                dfs(tickets, nextEnd, cnt+1);
                visited[i] = false;     // 마지막에 탐색했던 것부터 역순으로 하나씩 돌아감
                // 마지막에 탐색했던 것을 지우는 부분
                route = route.substring(0, route.length()-4);
            }
        }
    }
}