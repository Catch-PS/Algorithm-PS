package 스터디.스터디_SNU.Section09;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 문제풀이시간: 15분
 * 2. 컴퓨팅 사고
 * (1) 값을 하나씩 진행하면서 뒤에진행되는 값끼리 비교를 진행합니다.
 * (2) 값 기준으로 날짜값을 카운팅해주고 체크된게 없다면 0을 넣어줍니다.
 * 3. 시간복잡도
 * 최악의 경우 O(N^2)
 */
public class leetcode_Daily_Temperature_kgh {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78});
    }
    static int[] dailyTemperatures(int[] T) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<T.length; i++){
            int daily = T[i];
            int dayCnt = 0;
            boolean isCheck = false;
            for(int j=i+1; j<T.length; j++){
                dayCnt++;
                if(daily < T[j]){
                    arr.add(dayCnt);
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck){
                arr.add(0);
            }
        }
        arr.forEach(i-> System.out.println(i));
        int[] answer = arr.stream().mapToInt(integer -> integer).toArray();
        return answer;
    }
}
