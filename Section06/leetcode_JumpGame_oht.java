package Section06;


/**
 * 풀이시간 : 40분
 * 풀이방식 : DP Top-down 방식으로 풀이했습니다.
 * check[i] 값이 true인 경우는 최종 지점에 도달할 수 있는 상태라고 정의했습니다.
 * 1. 첫 번째 루프는 해당 인덱스가 다음 인덱스로 갈 수 있는지 비교하는 대상인 기준이 됩니다.
 * 2. nums[i] 가 0이면 해당 인덱스에서는 다음 인덱스로 어떠한 방법으로도 갈 수 없기 때문에 check[i]에 false를 기록합니다.
 * 3. nums[i] 만큼 인덱스에서 이동할 수 있으므로 이동할 수 있는 경우의 수를 모두 비교해보고,
 * check[i + j(1->nums[i])]가 true인 값이 존재하면 해당 인덱스도 최종 인덱스에 도달할 수 있다고 가정하므로
 * check[i]를 true로 하고 다음 루프를 지속합니다.
 * 4. 최종적으로 check[0] 가 true면 최종 지점에 도달할 수 있다고 유추할 수 있으며, check[0]의 값에 따라 결과값을 반환합니다.
 * 시간 복잡도 : O(N*M) N : nums.length, M : nums[i]의 Max값
 */
public class leetcode_JumpGame_oht {
  public boolean canJump(int[] nums) {

    return jump(nums);
  }

  private boolean jump(int[] nums) {

    //2,3,1,1,4 true
    boolean[] check = new boolean[nums.length];
    check[nums.length -1] = true;
    for (int i=nums.length - 2; i>=0; i--) {

      if (nums[i] == 0) {

        check[i] = false;
        continue;
      }

      for (int j=1; j<=nums[i]; j++) {
        if (check[i + j]) {
          check[i] = true;
          break;
        }
      }
    }

    return check[0];
  }
}
