package Section06;

/**
 * 풀이 시간 : 1시간
 * 풀이 방식 : DP Bottom-Up 방식으로 풀이했습니다.
 *
 * 1. 가장 큰 경우의 수를 구히기 위해서 2번째, 3번째 전 index까지의 경우의 수의 합 중 큰 수 + 현재 nums[i]를 해야 한다고 생각했습니다.
 * 2. sum 배열은 해당 인덱스 까지 경우의 수들의 합 중 가장 큰 값을 기록한 배열입니다.
 * 3. sum[3] = Max(nums[0], nums[1]) + nums[3]; 가장 첫 번째 경우의 수는 해당 방식으로 정의할 수 있습니다.
 * 4. sum[i] = Math.max(sum[i-2], sum[i-3]) + nums[i]; 이러한 방식으로 연산해 나가면
 * 최종적으로 마지막 인덱스 와 그 전 인덱스 2가지 경우의 수가 남게 됩니다.
 * 5. 두 경우의 수 중 큰 값을 결과 값으로 반환합니다.
 *
 * 시간 복잡도 : O(N)
 */
public class leetcode_HouseRobber_oht {

  public int rob(int[] nums) {

    return countAmount(nums);
  }

  private int countAmount(int[] nums) {

    int[] sum = new int[nums.length];

    if (nums.length == 0) {

      return 0;
    }

    if (nums.length == 1) {

      return nums[0];
    }

    if (nums.length == 2) {

      return Math.max(nums[0], nums[1]);
    }

    sum[0] = nums[0];
    sum[1] = nums[1];
    sum[2] = nums[0] + nums[2];

    for (int i=3; i<nums.length; i++) {

      sum[i] = Math.max(sum[i-2], sum[i-3]) + nums[i];
    }

    return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
  }
}
