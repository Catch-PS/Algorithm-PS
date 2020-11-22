package week2;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_addTwonumbers_pcy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mok=0;
        ListNode answer = new ListNode();
        ListNode tmp = answer;
        Queue<Integer> q = new LinkedList<Integer>();
        
        int FirstNum=0;
        int SecondNum=0;
        while(l1 != null || l2 != null){
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
            mok=(sum)/10;
            q.add((sum)%10);
            
            
        }
        
        if(mok>0){
            q.add(mok);
        }
        
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

