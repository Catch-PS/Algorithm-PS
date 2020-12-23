package Section04;

import java.util.HashMap;
import java.util.Map;

/**
 * 풀이 시간 : 초과
 * 풀이 방식 : DP 방식으로 풀이, 자식 노드의 경우의 수의 합이라고 생각하고 풀이했습니다.
 * 자식 노드가 발생할 수 있는 경우의 수는 현재 노드의 Element 수 이고, 각각의 Element가 root 노드일 때, 만들어지는 경우의 수를 의미합니다.
 * 이를 재귀적으로 호출하여 조회 카운트하고,
 * 단, 이미 만들어진 형태의 경우의 수의 합은 Map에 저장해서 그 결과값만 불러와서 더해줄 수 있도록 했습니다.
 * 시간 복잡도 : O(N^2)
 */

public class leetcode_Unique_Binary_Search_Trees_oht {

  Map<Integer, Integer> checked = new HashMap<>();

  public int numTrees(int n) {

    if (checked.containsKey(n)) {

      return checked.get(n);
    }

    if (n == 0 || n == 1) {

      return 1;
    }

    if (n == 2) {

      return 2;
    }

    int sum = 0;

    for (int i=0; i<n; i++) {

      sum += numTrees(i)*numTrees(n - i - 1);
    }

    checked.put(n, sum);
    return sum;
  }
}
