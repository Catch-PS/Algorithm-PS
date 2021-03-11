package Section13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * 풀이 시간 : 초과
 *
 * 풀이 방식 :
 * 1. 시간을 분리하고, milliseconds 단위로 변환합니다.
 * 2. 각 입력의 라인의 시작시간과 트랜잭션 종료시간을 구합니다.
 * 3. 준비해놓은 하루 동안의 milliseconds가 모인 배열에 각 startTime 부터 endTime까지 시간 카운트를 저장합니다.
 * 4. 전체 배열을 돌면서 max값을 반환합니다.
 *
 * 시간 복잡도 : O(N^2)
 */
public class programmers_추석트래픽_oht {

  private static final int ONE_DAY_TO_MILLISECONDS = 24 * 60 * 60 * 1000;
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");

  public int solution(String[] lines) throws ParseException {

    int[] timeCnt = new int[ONE_DAY_TO_MILLISECONDS + 1];

    for (String line : lines) {

      classify(line, timeCnt);
    }

    return Arrays.stream(timeCnt).max().orElse(0);
  }

  private void classify(String time, int[] timeCnt) throws ParseException {

    String[] timeStr = time.split(" ");

    int baseTime = (int) DATE_FORMAT.parse("00:00:00.000").getTime();
    int endTime = (int) (DATE_FORMAT.parse(timeStr[1]).getTime() - baseTime);
    int runTime = (int) (Double.parseDouble(
            timeStr[2].substring(0, timeStr[2].length() - 1)) * 1000);

    int startTime = endTime - runTime + 1;

    for (int i = Math.max(startTime - 999, 0); i <= endTime; i++) {

      timeCnt[i]++;
    }
  }
}
