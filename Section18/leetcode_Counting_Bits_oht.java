package Section18;

/**
 * 풀이 시간 : 10분
 *
 * 풀이 방식 : java Integer Wrapper 클래스에서 제공하는 bitCount() 를 사용하여 현재 정수의 1의 개수를 구했습니다.
 *
 * 시간 복잡도 : O(N) -> bitCount() 연산이 O(1)으로 수행되기 때문에 O(N)의 복잡도를 갖습니다.
 */

public class leetcode_Counting_Bits_oht {
  public int[] countBits(int num) {

    int[] answer = new int[num + 1];

    for (int i = 0; i <= num; i++) {

      answer[i] = Integer.bitCount(i);
    }

    return answer;
  }
}
