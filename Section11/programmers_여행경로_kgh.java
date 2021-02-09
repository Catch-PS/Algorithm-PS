package 스터디.스터디_SNU.Section11;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 1. 문제풀이시간: 초과
 * 2. 컴퓨팅사고
 * 처음에 Map이랑 Set으로 사용하여 문제를 풀려고하였으나, 점점 더 로직이 복잡해지는 느낌이 강해서 다른방법을 찾다보니 조합으로 풀게되었습니다.
 * (1) Arrays.sort를 사용하여 애초에 시작할때 출발지점이 같은 경우 도착지 기준으로 알파벳순서를 가깝게 정렬하고,
 * 출발지점이 다른 경우 출발지 기준으로 알파벳순서가 더 가깝게 정렬을 하였습니다.
 * (2) DFS진행시 start,path점을 ICN으로 초기화하여 DFS를 진행할 수 있도록 하였습니다. basement조건은 해당여행경로수만큼 진행되어있을때 종
 * (3) 하나의 리스트에는 여러가지 조합의경우가 담겨있는게 되고 현재 정렬이 된 상태에서 진행하니까 리스트의 첫번째에 담긴 원소들이 정답이 됩니다.
 * 따라서, " " 기준으로 split을 처리하여 정답을 리턴시켜주게 되었습니다.
 *
 * 3. 시간복잡도
 * O(DFS Recursive)
 *
 */
public class programmers_여행경로_kgh {
    static boolean[] check;
    static List<String> answer;
    static List<String> arr;
    public static void main(String[] args) {
        solution(new String[][]{{"ICN","JFK"}, {"HND", "IAD"}, {"JFK","HND"}});
        System.out.println();
        solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});

    }
    static List<String> solution(String[][] tickets){
        answer = new ArrayList<>();
        arr = new ArrayList<>();
        check = new boolean[10001];
        Arrays.sort(tickets, (prev, next) -> {
            // 출발지점이 같은 경우 도착지 기준으로 알파벳 순서가 더 가깝게 정렬
            if(prev[0].equals(next[0])){
                return prev[1].compareTo(next[1]);
            }
            // 출발지점이 다른 경우 출발지 기준으로 알파벳 순서가 더 가깝게 정렬
            else {
                return prev[0].compareTo(next[0]);
            }
        });
        dfs("ICN", "ICN", tickets, 0);
        String[] s = arr.get(0).split(" ");
        Collections.addAll(answer, s);
        for (String s1 : answer) {
            System.out.println(s1);
        }
        return answer;
    }

    private static void dfs(String start,String path,String[][] tickets, int cnt) {
        // 종료조건 하나의 경로가 완성되었을때
        if(cnt == tickets.length){
            arr.add(path);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            // 출발지점이 같고, 체크안된 지점일 경우
            if(tickets[i][0].equals(start) && !check[i]){
                check[i] = true;
                // 하나의 리스트를 만들어서 add,remove를 통하여 처리해주어도되고 하나의 path문자열로 처리해도됩니다.
                dfs(tickets[i][1], path+" "+tickets[i][1], tickets,cnt+1);
                check[i] = false;
            }
        }
    }
}
