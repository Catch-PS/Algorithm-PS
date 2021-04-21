package Section18;
import java.util.Arrays;

/**
 * 풀이 시간 : 시간초과
 * 시간복잡도 : O(N) - O(N) space
 * 풀이 과정 :

 //Can you do it in linear time O(n) and possibly in a single pass?
 //Could you solve it in O(n) space complexity?

 패턴 :
  temp   0  0  1  1  2  2  3  3  4  4  5
  index  0  1  2  3  4  5  6  7  8  9  10
  ans[i] 0  1  1  2  1  2  3  3  1  2  2
  temp'  0  1  1  2  2  3  3  4  4  5  5

    index 가 홀수 일 경우
    그 전 answer[temp] + 1
    index 가 짝수 일 경우
    그 전 answer[temp]의 값 과 똑같이 출력
    temp = index/2 표햔 가능

    int temp 두지않고 index/2 로 할 경우 space complexity 가 줄어든다.

 */

public class leetcode_countingBits_ps {

  public static int[] countBits(int num) {
    int[] answer = new int[num + 1];
    int temp = 0;
    for(int i = 0; i < num+1; i++) {
      if(i % 2 == 0) {
        answer[i] = answer[temp];
      } else {
        answer[i] = answer[temp]+1;
        temp++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int nums = 5;
    System.out.println(Arrays.toString(countBits(nums)));
  }

}
