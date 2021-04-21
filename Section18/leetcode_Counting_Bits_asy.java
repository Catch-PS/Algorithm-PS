package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 1. 풀이시간 : 50분
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 	(1) 0, 1일 경우 -> 고정값 삽입
 * 	(2) 그 외의 숫자일 경우 -> %, / 연산을 반복적으로 사용
 * 		% 연산한 결과가 1이면 카운트를 증가시킴
 * 		/ 연산한 결과(몫)가 1이면 반복적으로 연산하던 것 종료 -> 반복적 연산 로직을 벗어나면 카운트 횟수를 삽입(checkCnt로 0, 1이 아닌 케이스를 구분)
 */
public class leetcode338_Counting_Bits {

	public static void main(String[] args) {
		int num = 2;
		int su = num;
		System.out.println(Arrays.toString(countBits(su)));
	}
	
	public static int[] countBits(int num) {
        int su = num;
        int[] answer = new int[su+1];
        List<Integer> list = new ArrayList<Integer>();
        
        // 0 ~ num까지 반복
        int checkCnt = 0;
        for(int i=0; i<=su; i++){
        	int number = i;
            int nam = 0, mok = 0;
            int cnt = 0;
            // 몫이 1일때까지 반복
            while(mok != 1){
                // 0, 1일때는 케이스가 고정
                if(number==0){
                    list.add(0);
                    checkCnt++;
                    break;
                }
                if(number==1){
                    list.add(1);
                    checkCnt++;
                    break;
                }
                nam = number % 2;
                mok = number / 2;
                checkCnt++;
                
                if(nam==1)  cnt++;
                
                // 몫이 다음의 num이 됨
                number = mok;
            }
            // 몫이 1이 되면 cnt를 증가하고 list에 넣기
            // 0인 경우와 1인 경우에 걸리지 않게 하기 위해, number에 mok이 들어가므로 무조건 1이 되서 number가 0, 1이 아닌 조건으로 하면 안됨
            if(checkCnt >= 3) {
            	cnt++;
                list.add(cnt);
            }
        }
        
        for(int i=0; i<list.size(); i++){
        	try {
        		answer[i] = list.get(i);
			} catch (Exception e) {
				System.out.println(e);
			}
            
        }
        
        return answer;
    }
}
