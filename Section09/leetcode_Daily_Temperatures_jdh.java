/*
    풀이 시간: 3분
    예상 시간복잡도: O(n * n) => n^2
    풀이 방법: 현재 온도를 기준으로 자신의 온도보다 제일 먼저 높은 온도가 나타나면 두 인덱스 차이를 저장합니다. (인덱스 차이가 결국 기다려야 하는 날과 동일하기 때문)
            자신의 온도보다 높은 온도를 만나면 더 탐색할 필요가 없으므로 break로 빠져나와 계속 진행합니다. 만약 배열의 끝까지 자신의 온도보다 높은 온도가 없다면 0을 저장합니다.
 */
public class leetcode_Daily_Temperatures_jdh {

    public static int[] dailyTemperatures(int[] T) {
        int answer[] = new int[T.length];

        for(int i = 0; i < T.length; i++){
            for(int j = i + 1; j < T.length; j++){
                if(T[i] < T[j]) {
                    answer[i] = j - i;
                    break;
                }
                if(j == T.length - 1) answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String arsg[]){
        int T[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }
}
