/*
    풀이 시간: 20분
    풀이 방법: l1 또는 l2가 널이 아니거나 숫자의 합이 10이 넘어간 경우 while문을 반복한다
              각각 사이즈가 다를 수 있으니 next가 null일 경우 값은 0으로 둔다
              두 숫자의 합에 이전 숫자의 합이 10이 넘어갔을 경우(isOver) 1을 더해준다
              그리고 그 합들을 하나의 리스트에 담아준다
              while문 마지막으로 l1과 l2를 next 객체로 바꿔준 후, null 방어처리를 해준다
              결과로 나온 List를 문제 리턴값에 맞춰 ListNode로 변환해준다
    시간 복잡도: O(N) + O(N) = O(2N) -> O(N)
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> result = new ArrayList<>();
        boolean isOver = false;

        while (l1 != null || l2 != null || isOver) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = isOver ? value1 + value2 + 1 : value1 + value2;

            if (sum >= 10) {
                isOver = true;
                sum -= 10;
            } else {
                isOver = false;
            }

            result.add(sum);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        ListNode listNode = new ListNode(result.get(0));
        ListNode curNode = listNode;
        for (int i=1; i<result.size(); i++) {
            ListNode node = new ListNode(result.get(i));
            curNode.next = node;
            curNode = curNode.next;
        }

        return listNode;
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
