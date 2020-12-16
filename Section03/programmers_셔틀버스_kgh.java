package 스터디.스터디_SNU.Section03;

import java.util.Arrays;

/**
 * 1. 문제풀이 시간
 * 2. 컴퓨팅 사고
 * 각 버스는 09:00정각에 출발한다. 그전에 있던 사람들은 09:00버스를 탄다고 생각한다.
 * 만약 모두 09:00일 경우 08:59분에 도착해야 해당버스를 탈 수 있다.
 * 버스는 24시까지 운행되며 다음날이 넘어가면 크루는 대기열에서 빠진다.
 * 3. 시간복잡도
 * O(버스시간 * 버스 타임테이블 )
 */
public class programmers_셔틀버스_kgh {
    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
    }

    static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        String[] busTime = new String[n];
        for(int i=0; i<n; i++){
            busTime[i] = getArriveTime("09:00", t*i);
        }

        String lastBusTime = busTime[n-1];
        Arrays.sort(timetable);
        int curPosition =0;
        int curAdded = 0;
        String busStop = "";

        // 버스 시간
        for(int i=0; i<busTime.length; i++){
            busStop = busTime[i];
            curAdded = 0;
            // 탑승객 시간
            for(int j=curPosition; curPosition < timetable.length; j++){
                // 버스 시간 이전에 도착사람과 버스에 빈자리가 있을 경우
                if(getConvertTime(busStop) >= getConvertTime(timetable[j]) && curAdded < m){
                    answer = timetable[curPosition];                   // 마지막 탑승객일경우
                    answer = getArriveTime(answer, -1);         // 자리가 없을수도 있기 때문에 -1
                    curPosition++;
                    curAdded++;
                    // 버스자리 있고, 마지막 탑승객일 경우 현재 시간에 나간다.
                    if(i == busTime.length-1 && j == timetable.length-1 && curAdded < m){
                        answer = busTime[n-1];
                    }
                }else {
                    // 마지막 버스인데 전부 못타면 최종탑승자보다 일찍오게 한다 -1분일찍온다.
                    if(i == busTime.length-1 && curPosition >= 1){
                        // 마지막 탑승 가능한 도착 시간 저장
                        answer = timetable[curPosition-1];
                        answer = getArriveTime(answer,-1);
                    }
                    break;
                }
            }
        }
        // 여유 있는 경우 가장 늦게 있는 버스를 탄다.
        if("".equals(answer) || getConvertTime(answer) > getConvertTime(lastBusTime)){
            answer = lastBusTime;
        }
        return answer;
    }

    private static String getArriveTime(String hhmm, int min) {
        long tmpTime = getConvertTime(hhmm);
        tmpTime = tmpTime + min;
        int hh = (int)tmpTime / 60;
        int mm = (int)tmpTime % 60;
        return String.format("%02d", hh)+":"+String.format("%02d", mm);
    }
    private static long getConvertTime(String hhmm) {
        String str[] = hhmm.split(":");
        int hh = Integer.parseInt(str[0]);
        int mm = Integer.parseInt(str[1]);
        return hh*60+mm;
    }
}
