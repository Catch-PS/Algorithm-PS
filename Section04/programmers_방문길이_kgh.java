package 스터디.스터디_SNU.Section04;

import java.util.HashSet;

/*
#1 풀이 시간
45분

#2 접근 방식
- 음수의 값을 사용하기 싫었기 때문에 전체의 맵을 10x10으로 생각하여 시작점은 (5,5)에서 시작한다고 가정하였습니다.
- 간선보다는 정점을 체킹하는 형식으로 진행하였으나 중복점을 체킹하기가 어려워 간선풀이로 변경 Set자료구조를 사용하여 처리하였습니다.
- 방문 체크는 북, 남, 동, 서 4방향으로 진행하면서 간선을 체크하였습니다.
- 시작 x, y 도착 tmp_x tmp_y 양방향을 HashSet에 넣어주면서 하나의 문자열을 간선처럼 생각하여 넣어주었습니다.
- 벽에 부딪힌 경우는 방향을 이동하고나서 다시 제자리로 돌려주는 로직을 넣어주었습니다.

#3 시간복잡도
O(dirs.length() + Hashset add()1) 즉, 상수를 무시하므로 O(N)
 */
public class programmers_방문길이_kgh {

    static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int[][] check;
    static HashSet<String> hs;
    public static void main(String[] args) {
        solution("ULURRDLLU");
        solution("LULLLLLLU");

    }
    static int solution(String dirs) {
        int answer = 0;
        check = new int[11][11];
        hs = new HashSet<>();
        int x = 5;
        int y = 5;
        for(int i=0; i<dirs.length(); i++){
            int idx = -1;
            if(dirs.charAt(i) == 'U'){
                idx = 0;
            }else if(dirs.charAt(i) == 'D'){
                idx = 1;
            }else if(dirs.charAt(i) == 'R'){
                idx = 2;
            }else if(dirs.charAt(i) == 'L'){
                idx = 3;
            }
            int tmp_x = x;
            int tmp_y = y;
            x = x + dir[idx][0];
            y = y + dir[idx][1];

            // Set으로 고유값 저장
            if(x >= 0 && x <= 10 && y >=0 && y <= 10){
                hs.add(x+""+y+""+tmp_x+""+tmp_y);
                hs.add(tmp_x+""+tmp_y+""+x+""+y);
            }
            // 벽 부딪히는 경우
            else {
                x = x - dir[idx][0];
                y = y - dir[idx][1];
            }
        }
        // hs.forEach(value ->{
        //     System.out.println(value);
        // });
        // 간선으로 처리하였으므로 / 2(양방향 -> 단방향 개수)
        answer = hs.size()/2;
        return answer;
    }
}
