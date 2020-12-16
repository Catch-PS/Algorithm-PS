package Section03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 풀이시간 : 1시간
 * 접근방식 : 브루트 포스 방식으로 괄호 문자열을 만들어가면서
 * Parenthese 조건에 맞지 않는 괄호가 발생하면 이후 깊이 탐색은 종료하고,
 * 다음 조건을 계산합니다.
 * 예상 시간 복잡도 :
 */
public class leetcode_Generate_Parenthese_oht {

  public static void main(String[] args) {

    int input = 1;
    List<String> expected = new ArrayList<>();
    expected.add("()");

    List<String> actual = generateParenthesis(input);

    if (expected.size() != actual.size()) {

      throw new IllegalStateException("오답입니다.");
    } else {

      for (int i=0; i<expected.size(); i++) {

        if (!expected.get(i).equals(actual.get(i))) {

          throw new IllegalStateException("오답입니다.");
        }
      }
    }

    System.out.println("통과입니다.");
  }

  public static List<String> generateParenthesis(int n) {

    Stack<String> stack = new Stack<>();
    List<String> answer = new ArrayList<>();
    stack.push("(");

    while (!stack.isEmpty()) {

      String pair = stack.pop();

      if (!isRight(pair, n)) {

        continue;
      }

      if (pair.length() == (n * 2)) {

        answer.add(pair);
      } else {

        stack.push(pair + ')');
        stack.push(pair + '(');
      }
    }
    return answer;
  }

  public static boolean isRight(String pair, int n) {

    Stack<Character> cmp = new Stack<>();
    boolean right = true;
    int cnt = 0;

    for (char ch : pair.toCharArray()) {

      if (ch == '(') {
        cnt++;
        cmp.push(ch);

        if (cnt > n) {

          right = false;
          break;
        }
      } else {

        if (cmp.isEmpty()) {
          right = false;
          break;
        }

        cmp.pop();
      }
    }

    return right;
  }
}
