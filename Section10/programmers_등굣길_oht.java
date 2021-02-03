package Section10;

import java.util.HashSet;
import java.util.Set;

/**
 * 풀이 시간 : 1시간
 *
 * 풀이 방식 : dp를 사용하여 풀었습니다.
 * puddle 객체는 HashSet에 저장해서 O(1)의 복잡도로 조회할 수 있도록 했습니다.
 * puddle이 발생한 dp[y][x]을 0으로 초기화하고 이후의 합은 초기화된 상태로 더할 수 있도록 처리했습니다.
 *
 * 시간 복잡도 O(NM)
 */
public class programmers_등굣길_oht {
  public int solution(int m, int n, int[][] puddles) {
    long[][] dp = new long[n][m];

    Set<Puddle> puddleSet = new HashSet<>();

    if (puddles.length != 0) {

      for (int[] puddle : puddles) {

        puddleSet.add(new Puddle(puddle[0] - 1, puddle[1] - 1));
      }
    }

    for (int y = 0; y < n; y++) {

      for (int x = 0; x < m; x++) {

        if (puddleSet.contains(new Puddle(x, y))) {

          dp[y][x] = 0;
          continue;
        }

        if (x == 0 && y == 0) {

          dp[y][x] = 1;
          continue;
        }

        if (x == 0) {

          dp[y][x] = dp[y - 1][x];
        }

        if (y == 0) {

          dp[y][x] = dp[y][x - 1];
        }

        if (x > 0 && y > 0) {

          dp[y][x] = dp[y - 1][x] + dp[y][x - 1] % 1_000_000_007L;
        }
      }
    }

    return (int) (dp[n - 1][m - 1] % 1_000_000_007L);
  }
}

class Puddle {

  private final int x;

  private final int y;

  public Puddle(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Puddle)) return false;
    Puddle puddle = (Puddle) o;
    return this.x == puddle.getX() && this.y == puddle.getY();
  }

  @Override
  public int hashCode() {
    return 1;
  }
}