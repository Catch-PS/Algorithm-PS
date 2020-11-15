package Study.Section02;
import java.util.*;

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
