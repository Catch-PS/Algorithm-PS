package Section18;
/**
 *  * 풀이 시간 : 30분
 *  * 시간복잡도 : O(N)
 *  * 풀이 과정 :
 *   - 이용 가능한 숫자 배열을 {4,1,2} 로 배열하여 나머지가 0 == 4 / 1 == 1/ 2 == 2
 *   - 나머지 연산의 결과를 뒤에서 붙어 이어서 붙인다.
 *   - temp == 0 일 경우 nums--;
 *     왜냐하면, 0 의 0 부터 시작하는 것이 아니라 3 일때 나머지 0 == 4 부터 시작하기 때문에
 *     사실 순서는 1-2-4 순으로 적용이 되는 패턴이다.
 *
 *    int[] nums 으로 할 경우 효율성 검사에서 fail - 타입변환
 */

public class programmers_124나라의숫자_ps {
  public static String solution(int nums) {
    String[] numList = {"4", "1", "2"};
    String answer = "";
    while(nums > 0) {
      int temp = nums % 3 ;
      answer = numList[temp] + answer;
      nums = nums / 3;
      if(temp == 0) nums--;
    }

    return answer;
  }
  public static void main(String[] args) {
    System.out.println(solution(20));
  }
}
