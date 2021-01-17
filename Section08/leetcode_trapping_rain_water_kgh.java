package 스터디.스터디_SNU.Section08;

/**
 *
 * 1. 문제풀이시간: 55분
 * 2. 컴퓨팅 사고
 * 비가 내린후 빗물의 컨테이너에 채워지는 빗물의양을 구하는문제였습니다.
 * (1) 왼쪽에 가장 작은 인덱스와 오른쪽 가장 큰 인덱스와 모든 빗물중에 가장 큰 인덱스도 구해줍니다.
 * 그 이유는 왼쪽인덱스~빗물양이 가장 큰 인덱스, 오른쪽인덱스~빗물양이 가장 큰 인덱스 2가지 경우로 나누어서 계산하기 위함입니다.
 * (2) 기존에 입력으로 주어진 빗물의 크기(왼쪽 + 오른쪽)와 진행하면서 가장 큰 높이의 빗물기준으로 빗물의 크기를 구해줍니다.
 * (3) 기존의 컨테이너로 가둘 수 있는 빗물을 가둘 수 있는 최대의 크(컨테이너+빗물) - 입력으로 주어진 컨테이너의 높이를 계산해주면 최종적으로 담겨진 빗물의 크기를 알 수 있습니다.
 *
 * 3. 시간복잡도: O(N) 선형시간
 */
public class leetcode_trapping_rain_water_kgh {
    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        trap(new int[]{0,0,0,0,1,0,1,3,2,1,0,0});
        trap(new int[]{1,0,1,1,1,0,1,0,2,1,1,1});
    }
    static int trap(int[] height) {


        int minIdx = 0;
        int maxIdx = 0;
        boolean isMax = false;
        boolean isMin = false;
        // 가장 작은 인덱스 값 찾기
        for(int i=0; i<height.length; i++){
            if(height[i] == 0){
                isMin = true;
            }else {
                // 연속적으로 0이 나오는 경우
                if(isMin){
                    minIdx = i;
                    break;
                }
                // 0이 나오기전에 가장 작은 인덱스를 찾은 경우
                else {
                    minIdx = Math.min(minIdx, i);
                    break;
                }
            }
        }

        // 가장 큰 인덱스값 찾기
        for(int i=height.length-1; i >= 0; i--){
            if(height[i] == 0){
                maxIdx = i;
                isMax = true;
            }else {
                // 연속적으로 0이 나온경우
                if(isMax){
                    maxIdx = i;
                    break;
                }
                // 0이 나오기전에 가장 큰 인덱스를 찾은 경우
                else {
                    maxIdx = Math.max(maxIdx, i);
                    break;
                }
            }
        }
        System.out.println(minIdx + " " + maxIdx);
        int maxHightIdx = 0;
        // 빗물중에서 가장 큰 인덱스 값 찾기
        for(int i=0; i<height.length; i++){
            if(height[i] > height[maxHightIdx]){
                maxHightIdx = i;
            }
        }
        int h = 0;
        int leftSum = 0;
        int sum = 0;
        // 왼쪽 가장 작은 인덱스 ~ 가장 큰 인덱스까지 가장 큰 높이 기준으로 빗물 크기를 구합니다.
        for(int i=minIdx; i<maxHightIdx; i++){
            // 기존 빗물 크기의 합
            leftSum += height[i];
            // 진행되면서 가장 큰 높이 빗물 기준으로 총 빗물양 구하기
            h = Math.max(height[i], h);
            sum += h;
        }
        // 높이 초기화
        h = 0;
        int rightSum = 0;
        // 오른쪽 가장 큰 인덱스 ~ 가장 큰 인덱스까지 가장 큰 높이 기준으로 빗물 크기를 구합니다.
        for(int i=maxIdx; i>maxHightIdx; i--){
            rightSum += height[i];
            h = Math.max(height[i], h);
            sum += h;
        }
        System.out.println(sum + " " + leftSum + " "+ rightSum);
        return sum-(leftSum + rightSum);
    }
}
