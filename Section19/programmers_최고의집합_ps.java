package Section19;
/**
 *  풀이 시간 : 시간 초과
 *  시간 복잡도 : O(N)
 *  풀이 :
 *   - **규칙**
 *     n개로 구성된 원소의 합 && 원소의 곱이 최대
 *     = 가장 중간에 있는 값 (s/n)
 *     ex. { 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 } =>  { 4, 5 }
 *   - s % n != 0 일 경우,
 *     4 * 4 * 4 * 3 > 6 * 3 * 3 * 3
 *     골고루 1씩 더해주는 것이 한 index에 총 나머지값을 더해주는 것보다 곱했을때 크다.
 *   - 최고의 집합은 오름차순으로 정렬
 *     => Arrays.sort(answer);
 */

import java.util.Arrays;

public class programmers_최고의집합_ps {

  public static int[] solution(int n, int s) {
    if( s < n ) return new int[]{-1};
    int[] answer = new int[n];

    for(int i = 0; i < n; i++) {
      answer[i] = s/n;
    }

    for(int i = 0; i < n%s; i++) {
      answer[i] ++;
    }
    Arrays.sort(answer);
    return answer;
  }

  public static void main(String[] args) {
    solution(2,9);
  }

}
