package Study.Section02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
#1 풀이시간 : 30분

#2 접근방식
l1과 l2를 받아서 해당 인스턴스가 null이 아닐때까지 while을 돌린다
결과를 반환하는 ListNode 객체의 인스턴스인 result 하나 생성한다
현재 위치를 표시하는 ListNode 객체의 인스턴스인 curNode 하나 생성한다
l1이나 l2가 null인 경우, null이 아닌 곳에 값을 가져온다. 그리고 next로 이동
둘 다 null이 아닌 경우 값이 작은 곳에서 가져온다. 그리고 next로 이동
curNode.next에 값을 넣어준다
그리고 현재 노드를 next로 이동시켜준다
최종적으로 result.next를 리턴한다 (초기에 빈 인스턴스로 생성하였고 값은 next부터 넣었다)

#3 시간복잡도
최대 O(l1 + l2) -> O(N)
 */

public class leetcode_Merge_Two_Sorted_Lists_js {
    public static void main(String[] args) {
        System.out.println(">>>");
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);

        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node3.next = node4;

        mergeTwoLists(node1, node3);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode curNode;
        curNode = result;

        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                if (l1 == null) {
                    curNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else if (l2 == null) {
                    curNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                curNode = curNode.next;
                continue;
            }

            if (l1.val <= l2.val) {
                curNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
