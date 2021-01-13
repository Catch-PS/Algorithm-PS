package Section07;

import java.util.Stack;

/**
 * 풀이시간: 시간 초과
 * 풀이방법 : Stack을 활용해서 풀었습니다.
 * 숫자를 만나면 SB를 통해 인수를 만들고, [를 만남과 동시에 인수 스택에 삽입합니다.
 * 인수 SB를 초기화하고, 지금까지 계산한 문자열을 문자열 스택에 삽입합니다.
 * ]를 만나면 문자열과 인수를 pop해서 반복하고, 문자열 SB에 저장합니다.
 * 최종적으로 결과를 sb에 결과가 쌓이게 되고, sb -> String으로 결과값을 반환합니다.
 * 시간복잡도 : O(N*300)
 */
public class leetcode_DecodeString_oht {
  public String decodeString(String s) {

    Stack<Integer> factors = new Stack<>();
    Stack<StringBuilder> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    StringBuilder n = new StringBuilder();// 곱하는 인수를 만드는 StringBuilder

    for (int i = 0; i < s.length(); i++) {

      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {

        n.append(ch - '0');

      } else if (ch == '[') {
        factors.push(Integer.parseInt(n.toString()));//인수 stack에 추가, 100과 같은 자리수가 많은 숫자를 처리하기 위해 sb로 처리
        n.setLength(0);// n 초기화
        stack.push(sb);
        sb = new StringBuilder();

      } else if (ch == ']') {
        int factor = factors.pop();
        StringBuilder tmp = sb;
        sb = stack.pop();

        sb.append(String.valueOf(tmp).repeat(Math.max(0, factor)));

      } else {

        sb.append(ch);
      }
    }

    return sb.toString();
  }
}
