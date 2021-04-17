package Section18;

/**
 *
 */
public class programmers_124_나라의_숫자_oht {

  public String solution(int n) {
    StringBuilder answer = new StringBuilder();

    String[] nums = new String[] {"4", "1", "2"};

    while (n > 0) {

      int rest = n % 3;
      n = rest == 0 ? n / 3 - 1 : n / 3;
      answer.insert(0, nums[rest]);
    }
    return answer.toString();
  }
}
