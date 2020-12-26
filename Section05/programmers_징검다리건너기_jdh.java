/*
    풀이 시간: 50분
    예상 시간복잡도:
    풀이 방법: 친구 하나씩 수행을 하면 2억이 넘기 때문에 이는 시간 초과가 나게 됩니다. 따라서 탐색 시간을 줄여야 하는데
                선형 탐색에서 시간 복잡도를 줄이는 방식 중 이분 탐색으로 접근하게 되었습니다.
                인원 수를 기준으로 이분 탐색을 하게 되는데 최소 1부터 최대 2억까지 범위가 됩니다.
                따라서 초기 세팅은 left = 1, right = 200000000으로 설정하고 mid는 디딤돌을 다 건널 수 있는 최대 인원 수를 의미합니다.
                문제에서 주어진 조건에 의하면 건널 수 있는 경우 가장 가까운 돌을 건너야 하고 만약 건널 수 없는 경우 k라는 범위 안에
                있는 가장 가까운 돌을 건너야 합니다. 따라서 돌의 높이가 건너려는 인원 수보다 적은 경우가 k번 연속된다면 이는 건너려고 
                시도한 인원이 건널 수 없는 경우를 의미합니다. 따라서 인원을 하나 줄여서 다시 시도해보는 과정을 통해서 최대 인원을 찾습니다.
 */
public class programmers_징검다리건너기_jdh {

    public static int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;

        while(left <= right){
            int mid = (left + right) / 2;
            // 건널 수 있는 경우 최소 값을 하나 증가
            if(available(stones, mid, k)) left = mid + 1;
            // 건널 수 없는 경우 최대 값을 하나 감소
            else right = mid - 1;
        }

        // 오른쪽에 최대 값을 의미하므로 right return
        return right;
    }

    public static boolean available(int stones[], int mid, int k){
        int cnt = 0;
        for(int i = 0; i < stones.length; i++){
            // 돌의 높이가 건너려는 인원 수보다 작은 경우 카운트
            if(stones[i] - mid < 0) cnt++;
            // 작지 않은 경우 cnt 0으로 초기화
            else cnt = 0;

            // 돌의 높이가 인원 수보다 작은 경우가 k번 연속으로 있다면 이는 건널 수 없는 경우이므로 false 리턴
            if(cnt >= k) return false;
        }

        return true;
    }

    public static void main(String args[]){
        int stones[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution(stones, 3));
    }
}
