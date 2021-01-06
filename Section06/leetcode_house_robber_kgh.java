package 스터디.스터디_SNU.Section06;

/**
 * 1. 문제 풀이 시간: 40분
 * 2. 컴퓨팅 사고
 *
 * 맨 처음에 짝,홀로 값을 나누어서 그 값중에 가장 큰 값을 체킹해주었는데 짝,홀수이외에 값을 체크하는 경우가 있어서 다른 풀이를 생각해냈음.
 * 해당 문제는 DP를 사용하였는데 인접한 값을 훔칠수는 없기때문에 [0 , 1, 2]
 * 즉, num[2] + num[0]을 더한 값과 num[1] 그 중간에 끼어있는 값에 최대값을 구해주면 모든 포인트에 대한 최댓값을 확인할 수 있습니다.
 *
 * 그 외의 경우에는
 * (1) [] 빈값이 오는 경우 처리 하는 경우
 * (2) [1] 값이 하나만 오는 경우
 * (3) [2,1] 값이 두개가 오는 경우 더 큰값으로 처리하는 경우(더 큰 값을 뒤로 그래야 반환시 올바른 값을 체크할 수 있음)
 *
 * 3. 시간복잡도
 * O(nums.length)
 */
public class leetcode_house_robber_kgh {
    public static void main(String[] args) {
//        rob(new int[]{1,2,3,1});
//        rob(new int[]{2,7,9,3,1});
//        rob(new int[]{2,1,1,2});
        System.out.println(rob(new int[]{1,3,1,3,100}));
        System.out.println(rob(new int[]{2,1}));


    }
    static int rob(int[] nums) {
        int answer = 0;

        // []오는 경우 처리
        if(nums.length == 0){
            return 0;
        }
        // [1] 하나의 값만 오는 경우 처리
        else if(nums.length == 1){
            return nums[0];
        }
        // [2,1] 값이 2개 올 경우 더 큰 값을 nums[1]에 넣어주기, nums[nums.length-1]값을 반환하기 때문에
        nums[1] = Math.max(nums[0],nums[1]);
        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }
        answer = nums[nums.length-1];
        return answer;
    }
}
