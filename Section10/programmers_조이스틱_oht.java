package Section10;

/**
 * 풀이 시간 : 초과
 *
 * 풀이 방식 :
 * 1. 'A'와 'Z'를 기준으로 상하 커서의 비용을 구합니다.
 * 2. 현 위치에서 좌우로 커서를 움직이면서 연속 되는 'A'를 찾고, 이에 따라 좌우 커서의 최소 움직인 횟수를 구합니다.
 * 3. 상,하,좌,우 커서 이동의 합을 구합니다.
 *
 * 시간 복잡도 : O(N^2)
 */
public class programmers_조이스틱_oht {
  public int solution(String name) {

    return calculate(name);
  }

  private int calculate(String name) {

    int min = name.length() - 1;
    int cnt = 0;
    for (int i = 0; i < name.length(); i++) {

      char ch = name.charAt(i);

      cnt += Math.min(ch - 'A', 'Z' - ch + 1);

      min = moveCursor(name, i, min);
    }

    cnt += min;

    return cnt;
  }

  private int moveCursor(String name, int id, int min) {

    int length = name.length();
    int next = id + 1;

    while (next < length && name.charAt(next) == 'A') {

      next++;
    }

    int left = id; //A를 기준으로 왼쪽의 문자 수 - 1 (건너 뛴 수)
    int right = length - next; //마지막 A를 기준으로 오른쪽의 문자 수
    return Math.min(min, left + right + Math.min(left, right)); //왼쪽 + 오른쪽 + 되돌아갔을 때 비용이 낮은 방향
  }
}
