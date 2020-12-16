package Section03;

/**
 * 풀이시간 : 1시간
 * 접근방식 : l1 수열로 l2 수열을 각 삽입하는 형태로 풀었습니다.
 * l1 수열의 값을 l2 수열의 기준값과 비교하고,
 * l1 수열의 값보다 기준값이 작으면 l1 수열의 값 앞에 l2 기준값을 삽입하고
 * 현재 링크된 l1수열의 노드를 새로운 노드 tail에 붙입니다.
 * 예상 시간 복잡도 : O(l1 * l2)
 */
public class leetcode_Merge_Two_Sorted_Lists_oht {

  public static void main(String[] args) {

    int[] l1Arr = new int[]{1, 2, 4};
    int[] l2Arr = new int[]{1, 3, 4};
    int[] answerArr = new int[]{1, 1, 2, 3, 4, 4};

    ListNode l1 = new ListNode(1, null);
    ListNode l2 = new ListNode(1, null);
    ListNode answer = new ListNode(1, null);

    for (int i=1; i<l1Arr.length; i++) {
      l1.add(l1Arr[i]);
    }

    for (int i=1; i<l2Arr.length; i++) {
      l2.add(l2Arr[i]);
    }

    for (int i=1; i<answerArr.length; i++) {
      answer.add(answerArr[i]);
    }

    if (!answer.toString().equals(mergeTwoLists(l1, l2).toString())) {

      throw new IllegalStateException("오답입니다.");
    } else {
      System.out.println("성공");
    }

  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if (l1 == null && l2 == null) { return null; }

    if (l1 == null) { return l2; }

    if (l2 == null) { return l1; }

    ListNode l1Head = l1;
    ListNode l2Head = l2;

    while (l2Head != null) {

      if (l1Head.val > l2Head.val) {

        addNodeToHeadFirst(l1Head, l2Head.val);

        l2Head = l2Head.next;

      } else if (l1Head.next == null) {

        l1Head.next = l2Head;
        break;
      }

      l1Head = l1Head.next;
    }

    return l1;
  }

  public static void addNodeToHeadFirst(ListNode head, int input) {

    head.next = new ListNode(head.val, head.next);
    head.val = input;
  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode() {

  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void add(int i) {

    ListNode head = this;

    while (head.next != null) {

      head = head.next;
    }
    head.next = new ListNode(i, null);
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    ListNode head = this;
    sb.append("{");

    while (head.next != null) {

      sb.append(head.val).append(", ");
      head = head.next;
    }

    sb.append(head.val).append("}");

    return sb.toString();
  }
}