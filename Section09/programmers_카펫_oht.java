package Section09;

/**
 * 풀이 시간 : 15분
 *
 * 풀이 방식 : yellow 의 약수를 x, y라고 가정하고,
 * brown == (x + 2) * (y + 2) - yellow 가 성립하는 요소를 찾으면 값을 반환합니다.
 *
 * 시간 복잡도 : O(N)
 */
public class programmers_카펫_oht {
  public int[] solution(int brown, int yellow) {

    return calculateLength(brown, yellow);
  }

  private int[] calculateLength(int brown, int yellow) {

    int[] answer = new int[2];

    for (int i = 1; i <= yellow; i++) {

      if (yellow % i == 0) {

        answer[1] = i + 2;
        answer[0] = yellow / i + 2;

        if (brown == answer[0] * answer[1] - yellow) {

          break;
        }

      }
    }

    return answer;
  }
}
