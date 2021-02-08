package 스터디.스터디_SNU.Section11;

/**
 * 1.문제풀이 시간: 초과
 * 2.컴퓨팅사고
 * (1) 기준을 "초" 로 설정하여 convertTimeToInt함수 생성
 * (2) 재생 누적시간을 구하기 위해서는 재생구간의 개수가 필요하므로 재생구간의 개수를 구해줍니다.
 * (3) 재생구간의 개수를 활용하여 재생구간의 누적시간을 구해줍니다.
 * 재생구간의 개수는 (재생시작시간 + 1 ~ 재생이 끝나는시간)의 값으로 실질적인 동영상의 재생시간이라고 할 수 있습니다.
 * 문제 하단에 주어진 이 조건이 중요한데 다음과 같습니다.
 * => 동영상 재생시간 = 재생이 종료된 시각 - 재생이 시작된 시각(예를 들어, 00시 00분 01초부터 00시 00분 10초까지 동영상이 재생되었다면, 동영상 재생시간은 9초 입니다.)
 * 그리고 동영상의 최대시간은 동영상 재생시간의 최대시간 99:59:59 => 359999초이므로 해당 타임에 대한 배열값을 해당 범위만큼 초기화해줍니다.
 * (4) 광고가 들어갈 수 있는 시간은 (동영상 시간 - 광고시간 +1)의 식으로 구해줍니다.
 * (5) 광고가 들어갈 수 있는 최종시간까지 매시간마다 광고를 모두 집어 넣어보면서 확인을 진행합니다.
 * (6) 재생 누적시간값을 바탕으로 현재 그순간에 재생구간의 갯수만큼을 더해준후 1초에서의 재생구간의 갯수만큼 빼주면 됩니다.
 * (7) 최종적으로 모든 시간에 대해 재생 누적시간을 구한후에 재생 누적시간이 가장 큰 시간을 반환시켜주면 해당 time변수에서는 이 값을 확인할 수 있습니다.
 * (8) 결과적으로는 해당 String으로 변환하여 반환해야하므로 convertTimeToString()를 호출하여 문자열을 반환시켜줍니다.
 *
 * 자세한 내용은 스터디에서!
 *
 * 3. 시간복잡도
 * O(N^2)
 */
public class programmers_광고삽입_kgh {
    public static void main(String[] args) {
        solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
    }
    static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = convertTimeToInt(play_time);
        int advTime = convertTimeToInt(adv_time);

        // 동영상 재생시간의 최대시간 99:59:59 => 359999초
        int[] totalPlayTime = new int[360000];
        for(int i=0; i<logs.length; i++){
            String[] timeSplit = logs[i].split("-");
            int start = convertTimeToInt(timeSplit[0]);
            int end = convertTimeToInt(timeSplit[1]);

            // 재상구간의 개수 구하기
            for(int j=start+1; j<=end; j++){
                totalPlayTime[j]++;
            }
        }
        long currPlayTime = 0;
        long maxPlayTime = 0;
        int time = 1;
        for(int i=1; i<=advTime ; i++){
            currPlayTime += totalPlayTime[i];
            maxPlayTime += totalPlayTime[i];
        }
        for(int i=2; i<=playTime-advTime+1; i++){
            currPlayTime += (long) (totalPlayTime[i+advTime-1] - totalPlayTime[i-1]);
            if(currPlayTime > maxPlayTime) {
                maxPlayTime = currPlayTime;
                time = i;
            }
        }
        answer = convertTimetoString(time-1);
        System.out.println(answer);
        return answer;

    }

    /**
     * 문자열 시간 초단위로 변환
     * @param s
     * @return
     */
    static int convertTimeToInt(String s){
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]) * 3600;
        int minute = Integer.parseInt(time[1]) * 60;
        int second = Integer.parseInt(time[2]);
        int totalTime = hour + minute + second;
        return totalTime;
    }

    /**
     * 시간 문자열로 변환
     * @param time
     * @return
     */

    static String convertTimetoString(int time)
    {
        String s = "";
        int hour =  time / 3600;
        int minute = (time % 3600) / 60;
        int second = time % 60;

        if (hour <= 9){
            s += '0';
        }
        s += Integer.toString(hour);
        s += ':';
        if (minute <= 9){
            s += '0';
        }
        s += Integer.toString(minute);
        s += ':';
        if (second <= 9){
            s += '0';
        }
        s += Integer.toString(second);
        return s;
    }

}
