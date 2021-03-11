package 스터디.스터디_SNU.Section13;

/**
 * 1. 문제풀이시간: 초과
 * 2. 컴퓨팅사고
 * (1) 응답시간, 응답완료 시간을 모두 m/s단위로 바꾸어줍니다.
 * (2) 해당 함수를 바꾸어주고 각 로그의 시작점과 끝점을 구합니다.
 * (3) 시작점은 (응답완료 - 처리시간 + 1m/s) +1을 해주지 않으면 조건에 위배됩니다.
 * (4) 시작점이 걸쳐있는경우, 끝점이 걸쳐있는경우, 로그가 모두 포함되어있는경우 세가지 경우로 나누어서
 * 시작점과 끝점기준으로 모든 경우의 수를 구해주게됩니다.
 *
 * 자세한사항은 스터디때!
 *
 * 3. 시간복잡도
 * O(N^2)
 *
 */
public class programmers_추석트래픽_kgh {
    public static void main(String[] args){
//        solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
//                "2016-09-15 01:00:07.000 2s"});
        solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"});

    }
    static int solution(String[] lines){
        int answer = 0;

        // ms 단위로 변환
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];
        convertDateToMs(lines,startTimes, endTimes);

        for (int startTime : startTimes) {
            System.out.println("startTime = " + startTime);
        }
        for (int endTime : endTimes) {
            System.out.println("endTime = " + endTime);
        }
        // 시작되는시점기준으로 탐색
        for(int i=0; i<lines.length; i++) {
            int cnt = 0;
            // 시작시점에서 초단위로 확인을 해야하기 때문에 해당사항처럼 진
            int startTime = startTimes[i];
            int endTime = startTime + 1000;
            for (int j = 0; j < lines.length; j++) {
                if (startTimes[j] >= startTime && startTimes[j] < endTime) {
                    cnt++;
                } else if (endTimes[j] >= startTime && endTimes[j] < endTime) {
                    cnt++;
                } else if (startTimes[j] <= startTime && endTimes[j] >= endTime) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        // 끝지점 기준으로 탐색
        for(int i=0; i<lines.length; i++) {
            int cnt = 0;
            // 시작시점에서 초단위로 확인을 해야하기 때문에 해당사항처럼 진행
            int startTime = endTimes[i];
            int endTime = startTime + 1000;
            for (int j = 0; j < lines.length; j++) {
                if (startTimes[j] >= startTime && startTimes[j] < endTime) {
                    cnt++;
                } else if (endTimes[j] >= startTime && endTimes[j] < endTime) {
                    cnt++;
                } else if (startTimes[j] <= startTime && endTimes[j] >= endTime) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
        return answer;
    }
    private static void convertDateToMs(String[] lines, int[] startTimes, int[] endTimes) {
        for(int i=0; i<lines.length; i++){
            // "2016-09-15 01:00:04.001 2.0s"
            lines[i] = lines[i].replace("s","");
            // "01:00:04.001          2.0"
            String[] dateTimes = lines[i].split(" ");
            String[] responseTimes = dateTimes[1].split(":");
            System.out.println(lines[i]);
            // "2.0 -> 2000 ms단위 변환"

            int processingTime = (int)(Double.parseDouble(dateTimes[2]) * 1000);
            // 모든 시간들 ms단위로 변환
            int endTime = 0;
            int startTime = 0;
            endTime = Integer.parseInt(responseTimes[0]) * 60 * 60 * 1000
                    + Integer.parseInt(responseTimes[1]) * 60 * 1000
                    + (int)(Double.parseDouble(responseTimes[2]) * 1000);
            startTime = (endTime - processingTime)+ 1;
            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}