package 스터디.스터디_SNU.Section17;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.문제풀이시간: 초과
 * 2. 컴퓨팅 사고

 (1) 특정 숫자를 양 끝 숫자와 비교했을 때 양 끝 숫자 모두보다 크지만 않으면 됩니다.
 [-100,2,100] 양 끝 숫자와 가운데 숫자를 비교했을 때 하나만 작을 경우 2 가능
 [50,2,100] 양 끝 숫자 모두 가운데 숫자보다 클 경우 2 가능
 [-100,2,-50] 양 끝 숫자 모두 가운데 숫자보다 작을 때 2 불가능

 (2) 주어진 숫자열 중 양 끝에 있는 숫자들은 무조건 살아남을 수 있습니다.
 양 끝 숫자 각각과 index가 하나씩 작은 숫자들 각각과 비교했을 때 작으면 answer를 추가합니다.

 3.시간복잡도
 O(N)


 */
public class programmers_풍선터트리기_kgh {
    public static void main(String[] args) {
        solution(new int[]{9,-1,-5});
    }
    static int solution(int[] arr) {
        Set<Integer> set = new HashSet<>();

        // 첫번째 풍선을 제외 한 경우
        int minValue = arr[0];
        for(int i=1; i<arr.length; i++){
            set.add(minValue);
            minValue = Math.min(arr[i], minValue);
            System.out.println("minValue = " + minValue);
        }
        // 마지막 풍선을 제외 한 경우
        minValue = arr[arr.length-1];

        for(int i=arr.length-2; i>=0; i--){
            set.add(minValue);
            minValue = Math.min(arr[i], minValue);
        }
        System.out.println("set.size() = " + set.size());
        return set.size();
    }
}
