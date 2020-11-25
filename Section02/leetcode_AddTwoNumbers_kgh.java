package Study.Section02;
/*
#1 풀이 시간
35분

#2 접근방식
- 자리 올림수 처리와 나머지 값들을 구해주면서 합이 10이 넘어가는경우 처리를 진행합니다.
- remain값에는 sum / 10을 진행하면서 최종적으로 올림수가 발생하는경우 저장시켜놓고, sum % 10값(자리수)를 계속해서 StringBuilder 문자열에 추가시켜줍니다.
- 모든 값을 계산하고나서도 remain값이 남아 있는 경우는 마지막에 들어가는 값을 의미하므로 remain값이 0보다 클 경우에 마지막값을 추가시켜줍니다.
- 최종적으로 StringBuilder의 값을 하나씩 반환하여 ListNode를 만들어서 값을 넣어주었습니다.


#3 시간복잡도
N의 크기가 100이므로 O(l1+l2) 즉, O(N)에 수행이 가능합니다.
Node의 val값이 9이하이므로 StringBuilder 수행시에도 O(N)입니다. 자리수가 증가된다면 수행되는 횟수가 늘어날 것으로 예상합니다.
즉, O(N)에 모든 경우를 처리할 수 있습니다.
 */
public class leetcode_AddTwoNumbers_kgh {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remain = 0;
        StringBuilder sb = new StringBuilder();
        while(l1 != null || l2 != null){
            int x = 0;
            int y = 0;
            if(l1 != null){
                x = l1.val;
            }
            if(l2 != null){
                y = l2.val;
            }
            int sum = x + y + remain;
            remain = sum / 10;
            sb.append((sum % 10)+"");
            // l1 next value
            if(l1 != null){
                l1 = l1.next;
            }
            // l2 next value
            if(l2 != null){
                l2 = l2.next;
            }
        }
        // 나머지 값 존재시
        if(remain > 0 ){
            sb.append(remain+"");
        }

        // 결과
        ListNode answer = new ListNode(0);
        ListNode tmp_list = answer;
        for(int i=0; i<sb.length(); i++){
            tmp_list.next = new ListNode(Integer.parseInt(sb.charAt(i)+""));
            tmp_list = tmp_list.next;
        }

        return answer.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode tmp_l1 = l1;
        ListNode tmp_l2 = l2;

        tmp_l1.next = new ListNode(2);
        tmp_l1 = tmp_l1.next;
        tmp_l1.next = new ListNode(4);
        tmp_l1 = tmp_l1.next;
        tmp_l1.next = new ListNode(3);


        tmp_l2.next = new ListNode(5);
        tmp_l2 = tmp_l2.next;
        tmp_l2.next = new ListNode(6);
        tmp_l2 = tmp_l2.next;
        tmp_l2.next = new ListNode(4);


        ListNode answer = addTwoNumbers(l1.next, l2.next);

        while(answer != null){
            System.out.println(answer.val);
            answer = answer.next;
        }

    }
}
