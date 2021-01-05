package 스터디.스터디_SNU.Section06;

/**
 * 1. 풀이 시간: 초과
 * 2. 컴퓨팅사고
 * (1) 현재 인덱스에서 갈 수 있는 가장 최대로 갈 수 있는 인덱스 값을 구해줍니다.(어디까지 최대로 뛸 수 있는 인덱스인지를 찾아야합니다)
 * (2) 만약 [0]이라는 값이 들어왔으면 항상 자기 자신을 가르킬수 있어야하기 때문에 인덱스의 점프값이 0이고 maxIdx가 i의 이하의 값을 가지고 있으면 도달 할 수 없는 경우입니다.
 *
 * 3. 시간복잡도 O(nums의 길이 만큼 진행)
 */
public class leetcode_JumpGame_kgh {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{0}));
    }
    static boolean canJump(int[] nums) {

        int maxIdx = 0;

        for(int i=0; i< nums.length-1; i++){
            // maxIndex가 자기 자신 이하를 가리키고 그 보다 크면 해당범위를 벗어나게 됩니다.
            // 그리고  nums[i]인 점프력이 0이라면 앞으로 가지 못 합니다.
            if(nums[i] == 0 && maxIdx <= i){
                return false;
            }
            // 해당인덱스에서 최대로 뛸 수 있는 인덱스를 구해줍니다.
            maxIdx = Math.max(maxIdx, i+nums[i]);
        }
        return true;
    }

}
