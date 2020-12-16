package 스터디_SNU.Section03;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
#1 풀이 시간
35분

#2 접근방식
1) l1,l2가 동시에 null 일 경우 null 반환
2) l1이 null, l2가 null 아닌 경우, l2이 null, l1가 null 아닌 경우
3) 값이 있는 경우
총 세 가지 경우로 나눈후에 값들을 하나의 ArrayList에 add후 Collections.sort를 사용하여 값이 양수,음수에 따라
값을 정렬시킨후 Collections.reverse() 함수를 사용하여 answer에 맞게 답 노출

#3 시간복잡도
최대 O(l1 + l2), 노드수 range [0,50]이므로 충분히 O(N) 처리 가
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val= val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class leetcode_Merge_Two_Sorted_Lists_kgh {
    public static void main(String[] args) {
            ListNode l1 = new ListNode(0);
            ListNode l2 = new ListNode(0);
            ListNode l1_tmp = l1;
            ListNode l2_tmp = l2;

            l1_tmp.next = new ListNode(1);
            l1_tmp = l1_tmp.next;

            l1_tmp.next = new ListNode(2);
            l1_tmp = l1_tmp.next;

            l1_tmp.next = new ListNode(4);
            l1_tmp = l1_tmp.next;

            l2_tmp.next = new ListNode(1);
            l2_tmp = l2_tmp.next;

            l2_tmp.next = new ListNode(3);
            l2_tmp = l2_tmp.next;

            l2_tmp.next = new ListNode(4);
            l2_tmp = l2_tmp.next;

            ListNode res = mergeTwoLists(l1.next, l2.next);

            while(res != null){
                System.out.println(res.val);
                res = res.next;
            }

    }
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sort_arr = new ListNode(0);
        ListNode answer = sort_arr;
        ArrayList<Integer> arr = new ArrayList<>();
        if(l1 == null && l2 == null){
            ListNode ret = new ListNode();
            //System.out.print(ret.next);
            return ret.next;
        }else if(l1 == null && l2 != null){
            while(l2 != null){
                arr.add(l2.val);
                if(l2 != null){
                    l2 = l2.next;
                }
            }
        }else if(l1 != null && l2 == null){
            while(l1 != null){
                arr.add(l1.val);
                if(l1 != null){
                    l1 = l1.next;
                }
            }
        }else {

            while(l1 != null){
                arr.add(l1.val);
                if(l1 != null || l2 != null){
                    l1 = l1.next;
                }
            }
            while(l2 != null){
                arr.add(l2.val);
                if(l2 != null){
                    l2 = l2.next;
                }
            }

        }


        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 음수일때 오름차순
                if(o1 < 0 && o2 < 0){
                    if (o1 - o2> 0) {
                        return -1;
                    }else {
                        return 1;
                    }
                }
                // 양수일때 내림차순
                else {
                    if (o1 - o2> 0) {
                        return 1;
                    }else {
                        return -1;
                    }
                }

            }
        });

        for(int value : arr){
            System.out.println(value);
        }

        Collections.sort(arr);
        for(int a : arr){
            sort_arr.next = new ListNode(a);
            sort_arr = sort_arr.next;
        }
        return answer.next;
    }
}
