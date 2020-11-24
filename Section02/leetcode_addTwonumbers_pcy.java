package week2;

import java.util.LinkedList;
import java.util.Queue;



/*
 * #Ǯ�� �ð�
 * �뷫 1�ð�
 * 
 * # Ǯ�̹��
 * 
 * 
 * 1. �� �ڸ����� �޾ƿ� ���Ѵ�. ���࿡ 10�� �Ѿ�� 10�� �ڸ����ڸ� ���� ������ �����ؼ� �����ܰ迡 ���߽��ϴ�.
 * 
 * 2. ������ ���Ѱ��� Queue �� �־����ϴ�.
 * 
 * 3. ���࿡ ������ ���� ���곡�� ���� �ڸ��� �߻��� ��츦 ����� ���� �ڸ����ڸ� ���� mok ������ 0�� �ƴҰ�� Queue �־����ϴ�.
 * 
 * 4. Queue�� ���� ListNode�� �����Ͽ����ϴ�.
 * 
 *  
 * # �ð����⵵
 * 
 * O(l1)+O(l2) �� O(N) �����Դϴ�.
 *  
 * 
 * 
 * */
public class leetcode_addTwonumbers_pcy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	// �������� �����ڸ����� �� �����ϴ� ����,
        int mok=0;
        
        // ��ȯ�� ���亯��
        ListNode answer = new ListNode();
        
        // �ӽú���
        ListNode tmp = answer;
        
        // �����ڸ��� ���� Queue
        Queue<Integer> q = new LinkedList<Integer>();
        
        // l1 Node �� ���� ������ ����.
        int FirstNum=0;
        
        // l2 Node �� ���� ������ ����.
        int SecondNum=0;
        
        // l1 �� l2 �� ���̰� �ٸ��� �����Ƿ� �Ѵ� Null �϶� ���� ����.
        while(l1 != null || l2 != null){
        	
        	// �� �ܰ��� ���� �ڸ��� �̸� ������ ����
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
            
            // ���� �ڸ� ���ڸ� ����.
            mok=(sum)/10;
            
            // ������ ���ڸ� Queue�� ����
            q.add((sum)%10);
            
            
        }
        
        // ���� mok �� ����
        if(mok>0){
            q.add(mok);
        }
        
        // q�� ����� ���� temp �� ����
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

