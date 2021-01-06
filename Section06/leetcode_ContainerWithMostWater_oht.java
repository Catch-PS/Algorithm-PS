package Section06;

/**
 * 풀이 시간 : 30분
 * 풀이 방식 : 중복을 제거한 전체 수열의 면적을 구하면서 최댓값과 비교하여 최종 값을 반환하는 식으로 풀었습니다.
 * 1. 최초 반복문은 기준이 되는 대상 입니다.
 * 2. 두 번째 반복문은 비교가 되는 대상입니다.
 * 3. 기준과 비교 대상의 최소값 연산을 통해 컨테이너의 높이를 구합니다.
 * 4. 비교 인덱스에서 기준 인덱스를 빼서 컨테이너의 가로 길이를 구합니다.
 * 5. 높이 * 가로 길이를 통해 컨테이너의 면적을 구하고, 기존 max값과 비교하여 갱신합니다.
 * 6. 최종적으로 남은 결과만 반환합니다.
 *
 * 시간 복잡도 O(N^2/2) {1,8,6,2,5,4,8,3,7} 의 경우, 9 + 8 + 7 + ... 2 + 1 번 연산을 하게 되기 때문에
 * k 수열의 합을 구하면 n(n+1)/2가 될 것으로 예상합니다.
 */
public class leetcode_ContainerWithMostWater_oht {

  public int maxArea(int[] height) {

    return calculate(height);

  }

  private int calculate (int[] height) {

    int max = 0;
    for (int i=0; i<height.length; i++) {

      int cmp = height[i];
      for (int j=i + 1; j<height.length; j++) {

        int dist = j - i;
        int area = dist * Math.min(cmp, height[j]);

        if (max < area) {
          max = area;
        }

      }
    }

    return max;
  }
}