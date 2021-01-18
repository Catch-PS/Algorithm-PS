/*
    풀이 시간: 30분
    예상 시간복잡도: O(n)
    풀이 방법: 가장 큰 길이를 중심으로 좌측과 우측 탐색을 나눠서 계산합니다.
            좌측의 경우 가장 큰 길이를 제외하고 그 다음으로 긴 길이, 즉 두 번째로 긴 길이에서 현재 탐색하는 길이를 뺀 것이 물이 차는 높이가 됩니다.
            우측의 경우에도 같은 원리로 계산을 합니다.
            이때 좌측과 우측을 나누는 이유는 가장 긴 길이를 기준으로 좌측의 경우 현재 채우려는 칸보다 왼쪽의 칸이 더 높아야 물이 차고
            우측의 경우 현재 채우려는 칸보다 오른쪽의 칸이 더 높아야 하기 때문입니다.
            그래서 secondHigh를 왼쪽의 경우 0인덱스의 으로 초기 세팅을 했고, 오른쪽의 경우 마지막 인덱스의 값으로 세팅했습니다.
 */
public class leetcode_Trapping_Rain_Water_jdh {
    public static int trap(int[] height) {
        int answer = 0;
        int max = 0;
        int idx = 0;
        for(int i = 0; i < height.length; i++){
            if(max < height[i]){
                max = height[i];
                idx = i;
            }
        }

        int secondHigh = height[0];
        for(int i = 0; i < idx; i++){
            if(height[i] < secondHigh) answer += secondHigh - height[i];
            else secondHigh = Math.max(secondHigh, height[i]);
        }

        secondHigh = height[height.length - 1];
        for(int i = height.length - 1; i > idx; i--){
            if(height[i] < secondHigh) answer += secondHigh - height[i];
            else secondHigh = Math.max(secondHigh, height[i]);
        }

        return answer;
    }

    public static void main(String ars[]){
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
