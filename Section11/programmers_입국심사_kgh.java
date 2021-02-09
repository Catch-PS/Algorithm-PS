package 스터디.스터디_SNU.Section11;

import java.util.Arrays;

/**
 * 1. 풀이시간: 초과
 * 2. 컴퓨팅사고
 * 시간 1,000,000,000이 주어지므로 그냥 N으로는 불가능하다는것을 알고있어야합니다.
 *
 * (1) 주어진 times의 시간이 정렬된 순서로 온다는 보장이 없기때문에 sort진행
 * (2) 기준은 시간! 시간을 기준으로 최소 진행할 수 있는 시간 ~ n명 * 최대 진행 시간의 범위사이 이분탐색을 진행합니다.
 * (3) 심사관이 맡을 수 있는 최대시간을 구해줍니다. 즉, 최대 입국자 수 = 현재 time / 심사관별 심사시간
 * (4) 심사관이 맡을 수 있는 최대 수가 n보다 크거나 같다는것은 즉, 모두 입국자들을 관리할 수 있다는 의미
 * (5) 이분탐색으로 최소가 되는 지점을 찾아줍니다. 결국 현재 진행되는 시간 즉 mid의 값을 기준으로 진행되어야한다는 점이였습니다.
 * 따라서, target값에는 mid값으로 계속 갱신을 진행하고, 마지막 이분탐색이 종료되면 최소시간을 구할 수 있게됩니다.
 * 3. 시간복잡도 O(logN)
 */
public class programmers_입국심사_kgh {
    static int[] check = new int[100001];
    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{7, 10}));
    }
    private static long solution(int n, int[] times) {
        // 시간이 정렬순으로 들어오지 않을 수 있기때문에 sort
        Arrays.sort(times);
        long answer = 0;

        // 시작시간
        long start = 1;
        // 심사관이 최대 걸릴 수 있는 시간
        long end = (long)times[times.length-1]*n;
        // 최대시간에서부터 점점 줄여서 값을 진행하기 위해 target 선언
        long target = end;

        // 이분탐색
        while(start <= end){
            long mid = (start+end) / 2;
            long sum = 0;
            // 심사관이 맡을 수 있는 입국자수를 구해줍니다.
            for (int time : times) {
                sum += mid / time;
            }
            // n개이상의 입국자를 관리할 수 있는 경우
            if(sum >= n){
                // 심사를 받는데 시간의 최솟값을 갱신해줍니다.
                target = mid;
                end = mid-1;
            }
            // n개이상의 입국자를 관리할 수 없는 경우
            else {
                start = mid+1;
            }
        }
        answer = target;
        return answer;
    }
}
