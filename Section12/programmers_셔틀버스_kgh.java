package 스터디.스터디_SNU.Section12;

import java.util.Arrays;

/**
 * 1. 문제풀이시간: 초과
 * 2. 컴퓨팅사고
 * (1) 타임테이블로 주어진 값들을 모두 "분"단위로 변경
 * (2) 순서대로 온다는 보장이 없으므로 sort
 * (3) 셔틀버스 시작시간은 09:00 이므로 9 * 60
 * (4) 셔틀버스 운행전에 도착한 크루가 있는경우(크루의 탑승객의수 증가 + 크루의 진행된 인덱스의 개수)
 * (5) 버스에 정원이 다 차지 않은 경우, 버스도착시간에 콘 도착
 * (5) 버스 정원이 모두 가득찼을 경우, 운행을 종료시키고 마지막지점까지 도달하여 콘은 마지막 프렌즈 도착시간 이전타임 보다 1분 일찍 오면 콘이 오는시간
 * (6) 아직 더 탈인원이 있다면 다음 운행버스 호출
 * (7) 정답은 hh:mm 형식이므로 convertToString 함수 호출하여 정답 반환
 *
 * 3. 시간복잡도
 * O(N^2)
 */
public class programmers_셔틀버스_kgh {
    public static void main(String[] args) {
        solution(1,1,5,new String[]{"08:00","08:01","08:02","08:03"});
    }
    static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        //1. 모든 타임테이블 시간을 분단위로 변경
        int[] times = convertToTime(timetable);
        //2. 도착순서대로 정렬을 진행
        Arrays.sort(times);

        int busTime = 9 * 60;
        // 몇번째 크루까지 탑승했는지
        int busIdx = 0;
        int cornTime = 0;

        // 운행횟수만큼 진행
        for(int i=0; i<n; i++){
            // 버스탑승인원
            int busCrewCnt = 0;
            for(int j=busIdx; j<times.length; j++){
                // 버스 출발전에 도착한크루가 있는 경우
                if(times[j] <= busTime){
                    busCrewCnt++;
                    busIdx++;
                }
                // 버스 정원 꽉찬 경우
                if(busCrewCnt == m){
                    break;
                }
            }

            if(i == n-1){
                // 버스에 정원이 다 차지 않은 경우, 버스도착시간에 콘 도착
                if(busCrewCnt < m){
                    cornTime = busTime;
                }
                // 버스의 정원이 다 찬경우, 콘은 마지막에 탄 프렌즈보다 1분먼저오면 탈수 있음
                else {
                    cornTime = times[busIdx-1]-1;
                    break;
                }
            }
            // 다음 셔틀 호출하기
            busTime += t;
        }
        answer = convertToString(cornTime / 60, cornTime % 60);
        System.out.println(answer);
        return answer;
    }

    /**
     * 분단위 hh:mm형식 변환
     * @param h
     * @param m
     * @return
     */
    private static String convertToString(int h, int m) {
        String hour = Integer.toString(h);
        String minute = Integer.toString(m);
        if(hour.length() == 1){
            hour = "0" + hour;
        }
        if(minute.length() == 1){
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

    /**
     * hh:mm형식 분단위 변환
     * @param timetable
     * @return
     */

    private static int[] convertToTime(String[] timetable) {
        int[] times = new int[timetable.length];
        for(int i=0; i<timetable.length; i++){
            String[] time = timetable[i].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            int total = h * 60 + m;
            times[i] = total;
        }
        return times;
    }
}
