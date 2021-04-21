package Section18;

/**
 * 풀이 시간 : 40분
 *
 * 풀이 방식 : 3진법을 계산하는 방식으로 풀었습니다.
 *
 * 최초 int형 배열에 담아서 처리했을 때, 효율성 처리가 통과하지 못했으나,
 * String을 변환 후에 정상동작하는 것을 확인했습니다. (예상이지만 int -> String)을 하는데
 * 오버헤드가 발생하기 때문일 것이라고 생각됩니다.
 *
 * 시간 복잡도 : ?
 */
public class programmers_124_나라의_숫자_oht {

  public String solution(int n) {
    StringBuilder answer = new StringBuilder();

    String[] nums = new String[] {"4", "1", "2"};

    while (n > 0) {

      int rest = n % 3;
      n = rest == 0 ? n / 3 - 1 : n / 3;

      // 숫자 0이 존재하지 않기 때문에 n % 3 == 0이면 0 대신 4를 저장하고 n - 1을 해줍니다.
      answer.insert(0, nums[rest]);
    }
    return answer.toString();
  }
}
