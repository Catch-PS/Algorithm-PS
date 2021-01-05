package 스터디.스터디_SNU.Section06;

import java.util.*;

/**
 * 1. 문제풀이시간: 20분
 * 2. 컴퓨팅 사고
 *
 * (1). 시작점, 끝점으로부터 처음 시작을 진행하면서 시작값이 끝값보다 클 경우 끝의 값을 기준으로 y값을 설정한다.
 * (2). 높이 설정후 end-start의 차이만큼의 x축의 길이를 구한 후 y * x의 연산을 통해 부피를 구해준다.
 * (3). 시작값이 끝값보다 클 경우 end를 감소시켜주고 반대의 경우는 start값을 증가시켜준다.
 * (4). 해당되는 값들을 Math.max()함수를 통해 최댓값을 구해준다.
 * (5). 최종적으로 maxValue에는 최대한 만들수 있는 부피가 담기게 된다.
 *
 * 3. 시간복잡도: O(N)
 */

public class leetcode_container_with_most_water_kgh {
    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        maxArea(new int[]{1,2,1});
        maxArea(new int[]{1,2,4,3});
        maxArea (new int[]{1,1});
        maxArea(new int[]{4,3,2,1,4});
        maxArea(new int[]{2,1});
        maxArea(new int[]{1,0,0,0,0,0,0,2,2});
    }


    static int maxArea(int[] height){
        int start = 0;
        int end = height.length-1;
        int maxValue = 0;
        while(end - start > 0){
            int waterVolume;
            int minValue = 0;
            if(height[start] > height[end]){
                minValue = height[end];
                waterVolume = minValue * (end - start);
                end--;
            }else {
                minValue = height[start];
                waterVolume = minValue * (end - start);
                start++;
            }
            maxValue = Math.max(maxValue, waterVolume);
        }
        System.out.println(maxValue);
        return maxValue;
    }
    // 오답: 가장 큰 맥시멈 값을 기준으로 반반나누어서 시작 ~ 맥시멈값, 끝값 ~ 맥시멈값까지 처리를 진행하였는데 거치지 못한 테스트케이스가 있다고 생각이든다.
    static int maxArea1(int[] height) {

        int startIdx = 0;
        int answer = 0;

        List<Integer> maxList = new ArrayList<>();
        if(height.length <= 2){
            answer = Math.min(height[0], height[1]);
            System.out.println(answer);
            return answer;
        }
        int maxValue = 0;
        for(int i=0; i<height.length; i++){
            maxValue = Math.max(height[i], maxValue);
        }
        for(int i=0; i<height.length; i++){
            if(height[i] == maxValue) maxList.add(i);
        }
        for(int i=0; i<maxList.size(); i++){
            int maxIdx = maxList.get(i);
            int sum1 = 0;
            int sum2 = 0;
            for(int j=0; j<maxIdx; j++){
                if(height[j] != height[maxIdx]) {
                    sum1 = (maxIdx - j) * height[j];
                    answer = Math.max(sum1, answer);
                }
            }
            for(int k=height.length-1; k >= maxIdx; k--){
                if(height[k] != height[maxIdx]) {
                    sum2 = (height.length - 1 - k) * height[k];
                    answer = Math.max(sum2, answer);
                }
            }
            if(sum1 == sum2) answer = sum1+sum2;
        }
        System.out.println(answer);
        return 1;
    }




}
