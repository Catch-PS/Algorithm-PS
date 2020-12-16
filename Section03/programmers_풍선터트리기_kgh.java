package 스터디.스터디_SNU.Section03;


import java.util.HashSet;
import java.util.Set;

/*
1. 문제풀이시간 40분
2. 컴퓨팅사고
풍선기준으로 왼쪽, 오른쪽은 반드시 마지막까지 남길수 있는 풍선의 수 입니다.
이때 3가지 경우를 나눌 수 있는데
1) 왼쪽이 작은경우 , 오른쪽이 더 작은 경우 (3, 5 ,10) 3,5중 3을 터트리고 5,10중 10을 터트리면 5의 숫자가 살아남게됩니다.
2) 양쪽다 크게 될 경우 (8 5 10) 8,5의 경우 8을 터트리고, 5,10의 경우 10을 터트리고 10도 정상적으로 살아남게됩니다.
3) 양쪽다 작게 될 경우 (3 5 2) /  3,5중 3을 터트리고 5,2중 5를 터트려버리면 5는 살아남지 못하게됩니다.
작은거터트리는것은 1번만 가능하기때문에 이러한 경우가 가능합니다.

즉, 왼쪽->오른쪽 기준으로 가장작은값들을 Hashset을 사용하여 중복없이 저장시키고, 오른쪽->왼쪽 기준으로 가장 작은값들을 저장시킵니다.
이렇게 되면 (왼,오), (오,왼)의 경우를 살필 수 있습니다. 왼쪽은 오른쪽값보다 작아야하고, 오른쪽은 왼쪽값보다 작아야한다는 것을 알 수 있습니다.

3. 시간복잡도
O(배열 길이 왼쪽 + 배열 길이 오른쪽)만큼 진행 -> O(N + N) -> O(2N) -> O(N)

 */
public class programmers_풍선터트리기_kgh {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,-1,-5}));
    }

    private static int solution(int[] arr) {

        Set<Integer> set = new HashSet<>();

        int minValue = arr[0];

        // 첫번째 풍선 제외
        for(int i=1; i< arr.length; i++){
            set.add(minValue);
            minValue = Math.min(arr[i], minValue);
        }

        minValue = arr[arr.length-1];

        // 마지막 풍선 제외
        for(int i= arr.length-2; i>=0; i--){
            set.add(minValue);
            minValue = Math.min(arr[i], minValue);
        }
        return set.size();
    }
}
