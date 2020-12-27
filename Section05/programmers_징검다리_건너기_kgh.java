package 스터디.스터디_SNU.Section05;

/**
 * 1. 풀이시간: 55분
 * 2. 해당 문제를 처음봤을때 시뮬레이션 완전탐색으로 돌리게 되면 1 이상 200,000,000의 범위때문에 무조건 시간초과가 나온다고 생각을 하였습니다.
 * 따라서, DP나 다른 시간을 줄일만한 방법중 이분탐색을 진행하여 탐색의 횟수를 줄이는 방법을 확인하였습니다.
 * start,end,mid의 값을 사용하여 탐색을 진행하였는데 mid = (최솟값 + 최댓값) / 2 를 처리하여 돌다리를 건널 수 있는 인원들을 파악하였습니다.
 * 최대한 돌다리를 건널 수 있는지, 못 건너는지에 대한 확인은 돌 적힌수 - 돌다리 건너는 인원이 음수가 되면 해당인원으로 돌다리를 건널 수 있다는 것을 의미하고여
 * 양수가 된다면 해당 인원으로 K의 범위만큼을 더 건넌것이 되므로 현재까지 세어진 돌다리를 건너는 인원을 체크하는 cnt 변수를 초기화 시켜주게 되었습니다.
 * 범위가 cnt >= k 가 된다는것은 돌다리를 건너는 인원이 초과 된것을 의미하고 이와 반대로 cnt < k 충분히 돌다리를 건널 수 있음을 의미하게 됩니다.
 *
 * 돌다리 개수가 k개를 넘게되면 건널수 없는 범위이므로 최댓값을 mid-1로 변경하고, 건널 수 있으면 최솟값을 mid+1로 지정하여 이분탐색을 계속 진행하게 되면
 * 결국, start의 변수에는 최종적으로 돌다리를 최대 건널 수 있는 사람의 인원수가 담기게 됩니다.
 *
 * 3. 시간복잡도: 이분탐색의 특징으로 값들을 계속절반으로 줄어들고 있는 로직을 가지고 있으므로 O(NlogN)의 시간복잡도를 갖습니다.
 */
public class programmers_징검다리_건너기_kgh {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,4,5,3,2,1,4,2,5,1}, 3));
    }
    private static int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = Integer.MAX_VALUE;
        int mid = 0;

        while(start <= end){
            int cnt = 0;
            // 돌다리 건너는 인원
            mid = (start + end) / 2;        

            for(int i=0; i<stones.length; i++){
                // 돌 적힌수 - 돌다리 건너는 인원(인원수 만큼 감소되기 때문에)이 0보다 작거나 같은경우에 cnt값 증가
                if(stones[i] - mid <= 0){
                    cnt++;
                }
                // 돌 적힌수 - 돌다리 건너는 인원일 경우 최대인원이 될 수 없기 때문에 0으로 초기화
                else {
                    cnt = 0;
                }
                // 돌다리 개수가 k개를 넘게되면 건널수 없는 범위
                if(cnt >= k){
                    end = mid-1;
                    break;
                }
            }
            // 돌다리 건너기 가능이면 mid값보다 1큰 값부터 다시 재탐색을 수행
            if(cnt < k ){
                start = mid+1;
            }
        }
        answer = start;
        return answer;
    }
}
