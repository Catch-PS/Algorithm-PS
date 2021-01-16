package Section08;

/**
 * 풀이시간 : 50분
 * 풀이방식 :
 * 1. 가장 큰 value를 가진 Index를 구합니다.
 * 2. max Index를 기준으로 좌, 우의 면적을 구합니다.
 * 3. 면적을 구하는 방식은 이전까지 가장 큰 value(highId의 값) 보다 같거나 큰 value를 만났을 때,
 *    아래 변 길이 * highId의 값 - lowSum(highId의 값보다 작은 값들의 합)을 합니다.
 *
 *          *
 *    *     *
 *    *   * *
 *    * * * *
 *    0 1 2 3
 *
 *    위와 같은 경우에, 아래 변의 길이 (3-0-1) 실질적으로 1 2에 해당하는 변을 구해야 하므로 -1을 합니다.
 *    이전까지 가장 큰 값을 가진 Index는 highId = 0;
 *    lowSum에는 1과 2의 값이 추가됩니다. 즉, 3이 더해집니다.
 *
 *    최종적으로 index 3에 도달하면 아래 변의 길이 (3-0-1) * highId(3) - lowSum(3) 을 하여 3의 면적을 구할 수 있습니다.
 *
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(1)
 */
public class leetcode_Trapping_Rain_Water_oht {

  public int trap(int[] height) {

    int area = 0;

    int maxId = findMaxId(height);

    area += calculateLeftArea(height, maxId);
    area += calculateRightArea(height, maxId);

    return area;
  }

  private int calculateRightArea(int[] height, int maxId) {

    int area = 0;
    int highId = height.length-1;
    int lowSum = 0;

    for (int i=height.length-2; i>=maxId; i--) {

      if (height[i] >= height[highId]) {

        area += Math.abs(i - highId + 1) * height[highId] - lowSum;
        highId = i;
        lowSum = 0;
      } else {

        if (i != height.length - 1) {
          lowSum += height[i];
        }
      }
    }

    return area;
  }

  private int calculateLeftArea(int[] height, int maxId) {

    int highId = 0;
    int area = 0;
    int lowSum = 0;

    for (int i=1; i<=maxId; i++) {

      if (height[i] >= height[highId]) {

        area += (i - highId - 1) * height[highId] - lowSum;
        highId = i;
        lowSum = 0;
      } else {

        if (i != 0) {
          lowSum += height[i];
        }
      }
    }

    return area;
  }

  private int findMaxId(int[] height) {

    int maxId = 0;

    for (int i=0; i<height.length; i++) {

      if (height[maxId] < height[i]) {

        maxId = i;
      }
    }

    return maxId;
  }
}
