package week2;

import java.util.LinkedList;
import java.util.Queue;



/*
 * #풀이 시간
 * 대략 1시간
 * 
 * # 풀이방식
 * 
 * 
 * 1. 각 자리수를 받아와 더한다. 만약에 10이 넘어가면 10의 자리숫자만 따로 변수에 저장해서 다음단계에 더했습니다.
 * 
 * 2. 기존에 더한값은 Queue 에 넣었습니다.
 * 
 * 3. 만약에 마지막 숫자 연산끝에 십의 자리가 발생할 경우를 대비해 십의 자리숫자를 넣은 mok 변수가 0이 아닐경우 Queue 넣었습니다.
 * 
 * 4. Queue의 값을 ListNode에 삽입하였습니다.
 * 
 *  
 * # 시간복잡도
 * 
 * O(l1)+O(l2) 로 O(N) 연산입니다.
 *  
 * 
 * 
 * */
public class leetcode_addTwonumbers_pcy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	// 더했을때 십의자리숫자 를 저장하는 변수,
        int mok=0;
        
        // 반환할 정답변수
        ListNode answer = new ListNode();
        
        // 임시변수
        ListNode tmp = answer;
        
        // 일의자리를 더할 Queue
        Queue<Integer> q = new LinkedList<Integer>();
        
        // l1 Node 의 값을 저장할 변수.
        int FirstNum=0;
        
        // l2 Node 의 값을 저장할 변수.
        int SecondNum=0;
        
        // l1 과 l2 의 길이가 다를수 있으므로 둘다 Null 일때 까지 연산.
        while(l1 != null || l2 != null){
        	
        	// 전 단계의 십을 자리를 미리 저장해 놓음
            int sum = mok;
            
            if(l1 != null) {
                FirstNum=l1.val;
                sum+=FirstNum;
                l1=l1.next;
            }
            
            if(l2 != null) {
                SecondNum=l2.val;
                sum+=SecondNum;
                l2=l2.next;
            }         
            
            // 십의 자리 숫자를 저장.
            mok=(sum)/10;
            
            // 나머지 숫자를 Queue에 저장
            q.add((sum)%10);
            
            
        }
        
        // 남은 mok 을 저장
        if(mok>0){
            q.add(mok);
        }
        
        // q에 저장된 값을 temp 에 저장
        while(!q.isEmpty()){
            tmp.next=new ListNode(q.poll());
            tmp=tmp.next;
        }
        
        return answer.next;
        
        
        
    }

}




class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

