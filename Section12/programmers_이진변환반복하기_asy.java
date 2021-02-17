import java.util.*;
/*
 * 1. 풀이시간 : 시간초과
 * 2. 풀이방법
     before = [1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1]
     before 리스트 하나하나를 탐색하며 after라는 새로운 리스트에 1만 넣어줌
     after = [1, 1, 1, 1, 1, 1]
     제거된 0의 개수 = before의 크기 - after의 크기    -> removeZeroCnt에 저장
     
     after 리스트의 크기를 시작으로 이진 변환 알고리즘을 통해 binary 리스트에 넣어줌
     binary 리스트에 거꾸로 들어가있으므로 reverse를 함
     이진 변환 횟수 1증가   -> toBinaryCnt 증가
     
     이진 변환 결과의 결과가 1개면 -> 반복문 종료
     1개가 아니면 -> binary 리스트에 있는 것들을 before 리스트에 넣어서 다시 동일한 과정 반복
 * 3. 예상 시간복잡도 : O(n)
 */
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        char[] charArr = s.toCharArray();
		ArrayList<Character> before = new ArrayList<Character>();
		ArrayList<Character> after = new ArrayList<Character>();
		int toBinaryCnt = 0;
		int removeZeroCnt = 0;
		
		// 문자 하나하나를 list에 넣기
		for (int i = 0; i < charArr.length; i++) {
			before.add(charArr[i]);
		}

		while(true) {
			after.clear();
			// before를 탐색하며 1이면 새로운 리스트 after에 넣어줌
  			for (int i = 0; i < before.size(); i++) {
				if (before.get(i) == '1') {
					after.add('1');
				}
			}
			// 제거된 0의 개수 구하기
			removeZeroCnt += before.size() - after.size();

			//0을 제거한 list의 길이를 이진법으로 표현
			ArrayList<Integer> binary = new ArrayList<Integer>();
			int mok = 0, nmg = 0;  
			int num = after.size();		//0 제거 후 배열 길이
			do { 
				mok = (int) num/2;
				nmg = num - (mok*2);
				
				//int -> char 바꿔서 저장
				binary.add(nmg);
				num = mok;
			}while(mok!=0);		//mok이 0일때까지 계산
			Collections.reverse(binary);
			toBinaryCnt++;
			
			// 한자리 숫자면 종료
			if(binary.size()==1) {
				System.out.println("탐색 종료");
				break;
			}
			// 한자리 숫자가 아닐 경우 똑같은 연산 반복
			else {
				//이진 결과값을 처음 시작인 before 리스트에 넣음
				before.clear();
				for(int i=0; i<binary.size(); i++) {
					before.add( (char) (binary.get(i) + '0'));
				}
			}
		}
        answer = new int[] {toBinaryCnt, removeZeroCnt};
        
        return answer;
    }
}