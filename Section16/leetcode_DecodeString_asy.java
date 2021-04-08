package medium;

import java.util.Stack;

/*
 * 1. 풀이시간 : 
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * 	(case 1) 숫자
 * 		반복횟수를 변수에 기억(두자리, 세자리 수까지 고려)
 * 	(case 2) "["
 * 		1. 반복횟수를 countStack에 push
 * 		2. 앞에서 반복해서 만들어진 문자를 stringStack에 push
 * 		3. 반복횟수(count)와 반복으로 만들어진 문자열(result)을 초기화 -> 새로운 것들을 받아야하므로
 *  (case 3) "]"
 *  	1. 반복횟수를 countStack에서 꺼냄
 *  	2. 반복횟수만큼 문자열을 반복한 문자열을 구함(temp)
 *  	3. 지금까지 만들어진 반복 문자열(result) + 현재 단계에서 만들어진 반복 문자열(temp) -> 여기서 구한 result를 "["가 나오면 stackStack에 push
 */	
public class leetcode_DecodeString {

	public static void main(String[] args) {
//		String s = "3[a]2[bc]";
//		String s = "3[a2[c]]";
		String s = "2[abc]3[cd]ef";
		
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> stringStack = new Stack<String>();
		
		StringBuilder result = new StringBuilder();
		int count = 0;
		
		// 문자열 길이만큼 반복
		for(char c : s.toCharArray()) {
			// 1. 숫자일 경우
			if('0'<=c && c<='9') {
				count = 10 * count + Integer.parseInt(c+"");
			}
			// 2. "["일 경우
			else if(c=='[') {
				countStack.push(count);
				stringStack.push(result.toString());	
				count = 0;
				result = new StringBuilder();
			}
			//  3. "]"일 경우
			else if(c==']') {
				StringBuilder temp = new StringBuilder();
				int curCount = countStack.pop();
				for(int i=0; i<curCount; i++) {
					temp.append(result);
				}
				result = new StringBuilder(stringStack.pop() + temp);
			}
			// 4. 문자일 경우
			else {
				result.append(c);
			}
		}
		System.out.println(result);
	}

}
