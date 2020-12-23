package Section04;

/**
 * 풀이 시간: 20분
 * 시간 복잡도 : O(N)
 * 풀이 방법 : 길의 통과 여부와 통과한 방향에 대해 기록하고, 다시 입력시 카운트하지 않는 방식으로 풀었습니다.
 */
public class programmers_방문길이_oht {

  private static final int VERTICAL = 11;
  private static final int HORIZONTAL = 11;
  private static final int DIRECTION = 4;
  private static final int UP_DIREC = 0;
  private static final int DOWN_DIREC = 1;
  private static final int RIGHT_DIREC = 2;
  private static final int LEFT_DIREC = 3;

  public static void main(String[] args) {

    if (solution("ULURRDLLU") == 7) {

      System.out.println("성공");
    }
  }

  private static int solution(String dirs) {

    boolean[][][] checked = new boolean[VERTICAL][HORIZONTAL][DIRECTION];

    int x = 5;
    int y = 5;
    int cnt = 0;
    for (int i=0; i<dirs.length(); i++) {

      char dir = dirs.charAt(i);

      switch(dir) {

        case 'U' :
          if (y == VERTICAL - 1) {// 세로 최대 길이를 벗어나면 연산을 수행하지 않습니다.
            continue;
          } else if (!checked[++y][x][UP_DIREC]){
            cnt++;
            checked[y][x][UP_DIREC] = true; // 이전 정점에서 위 방향으로 통과여부를 true로 변환
            checked[y-1][x][DOWN_DIREC] = true; // 현재 정점에서 아래 방향으로 통과여부를 true로 변환
          }
          break;

        case 'D' :

          if (y == 0) {
            continue;
          } else if (!checked[--y][x][DOWN_DIREC]){
            cnt++;
            checked[y][x][DOWN_DIREC] = true;
            checked[y+1][x][UP_DIREC] = true;
          }
          break;

        case 'R' :

          if (x == HORIZONTAL - 1) {
            continue;
          } else if (!checked[y][++x][RIGHT_DIREC]){
            cnt++;
            checked[y][x][RIGHT_DIREC] = true;
            checked[y][x-1][LEFT_DIREC] = true;
          }
          break;

        case 'L' :

          if (x == 0) {
            continue;
          } else if (!checked[y][--x][LEFT_DIREC]){
            cnt++;
            checked[y][x][LEFT_DIREC] = true;
            checked[y][x+1][RIGHT_DIREC] = true;
          }
          break;
      }
    }
    return cnt;
  }
}
