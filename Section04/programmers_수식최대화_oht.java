package Section04;

import java.util.LinkedList;
import java.util.List;

/**
 * 풀이 시간 : 30분
 * 풀이 방식 : 수식이 만들어 질 수 있는 경우의 수를 전부 비교하고, 그 중 절대값이 Max인 값을 출력했습니다.
 * 시간 복잡도 : O(6*3*N) 6: 우선순위 경우의 수, 3: 연산자 종류
 */
public class programmers_수식최대화_oht {

  private static final char[][] priority = new char[][] {{'+', '-', '*'},
          {'+', '*', '-'},
          {'-', '+', '*'},
          {'-', '*', '+'},
          {'*', '-', '+'},
          {'*', '+', '-'}};
  //만들어지는 우선 순위 경우의 수 3!개

  public long solution(String expression) {

    List<Long> values = new LinkedList<>();
    List<Character> operators = new LinkedList<>();
    long max = 0;

    split(expression, values, operators);//문자열을 연산자 리스트와 value 리스트로 나누어 저장합니다.

    for (int i=0; i<6; i++) {
      List<Long> cmpValue = new LinkedList<>(values);
      List<Character> cmpOperators = new LinkedList<>(operators);// 각 리스트를 기존의 값으로 매번 초기화 해야합니다.

      for (int j=0; j<3; j++) {

        calculate(priority[i][j], cmpValue, cmpOperators);
      }//연산자 우선순위에 따라 계산을 진행합니다.

      long answer = Math.abs(cmpValue.get(0));
      if (max < answer) {
        max = answer;
      }
    }

    return max;
  }

  private void split(String expression, List<Long> values, List<Character> operators) {

    StringBuilder sb = new StringBuilder();

    for (int i=0; i<expression.length(); i++) {

      char ch = expression.charAt(i);

      if (48 <= ch && ch <= 57) {
        sb.append(ch);
      } else {
        operators.add(ch);
        values.add(Long.parseLong(sb.toString()));
        sb = new StringBuilder();
      }

      if (i == expression.length() -1) {

        values.add(Long.parseLong(sb.toString()));
      }
    }
  }

  private void calculate(char priority, List<Long> values, List<Character> operators) {

    int i = 0;//연산자의 위치를 찾는 포인터
    while (i < operators.size()) {

      char op = operators.get(i);

      if (op == priority) {

        operators.remove(i);//계산한 연산자를 제거합니다.
        long x = values.get(i);
        long y = values.get(i+1);//연산 대상을 가져옵니다.
        values.remove(i+1);//
        values.remove(i);//연산 대상을 리스트에서 제거합니다.
        long value;

        switch(op) {

          case '+' :
            value = x + y;
            break;

          case '-' :
            value = x - y;
            break;

          default :

            value = x * y;
            break;
        }

        values.add(i, value);//연산 결과를 재배치 합니다. a+b = c라면 k - a + b * d = x 의 경우  k - c * d 로 변환합니다.
      } else {

        i++;
      }
    }
  }
}
