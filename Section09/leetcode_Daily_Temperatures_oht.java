package Section09;

import java.util.Stack;

/**
 * 풀이시간 : 1시간
 *
 * 풀이방식 : stack을 활용해서 풀었습니다.
 *
 * 1. stack이 비었거나, stack의 최상단 엘리먼트에 해당하는 값이 i에 해당하는 값보다 클 때,
 * stack에서 id를 pop()하고, answer[id] = 현재 인덱스 - id 를 하여 값을 저장합니다.
 *
 *  0   1   2   3   4   5   6   7
 * {73, 74, 75, 71, 69, 72, 76, 73} 에서 2 - 5의 경우,
 *
 * |   4   |    T[4] < T[5] -> pop() -> answer[4] = 5 - 4
 * |   3   |    T[3] < T[5] -> pop() -> answer[3] = 5 - 3
 * |   2   |    T[2] > T[5] -> push(5)
 * ㅡㅡㅡㅡㅡ
 *
 * 이러한 과정을 반복하면 최종적으로 answer[] 배열에 원하는 값이 담기게 됩니다.
 *
 * 시간 복잡도 :
 */
public class leetcode_Daily_Temperatures_oht {

  public int[] dailyTemperatures(int[] T) {

    Stack<Integer> stack = new Stack<>();
    int[] answer = new int[T.length];

    for (int i = 0; i< T.length; i++) {

      while(!stack.isEmpty() && T[i] > T[stack.peek()]) {

        int id = stack.pop();
        answer[id] = i - id;
      }

      stack.push(i);
    }

    return answer;
  }
}
