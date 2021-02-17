package Section12;

/**
 * 풀이시간 : 20분
 *
 * 풀이 방식 : 재귀적으로 이진수 변환과 제거된 0의 개수를 구합니다.
 *
 * 시간 복잡도 :
 */
public class programmers_이진변환반복하기_oht {

  public int[] solution(String s) {

    int[] answer = new int[2];

    calculate(s, answer);
    return answer;
  }

  private void calculate(String s, int[] answer) {

    if (s.equals("1")) {

      return;
    }

    int length = s.length();
    String tmp = removeZero(s);
    answer[0]++;
    answer[1] += length - tmp.length();// 제거된 0의 갯수를 구합니다.

    calculate(Integer.toBinaryString(tmp.length()), answer);// 이진수 변환
  }

  private String removeZero(String s) {

    return s.replaceAll("0","");
  }
}
