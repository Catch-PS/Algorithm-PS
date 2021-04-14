package 스터디.스터디_SNU.Section17;

import java.util.*;

/**
 * 1. 문제풀이시간: 30분
 * 2. 컴퓨팅사고
 * (1) map을 사용하여 모든 값에 대한 등장 횟수를 넣어줍니다.
 * (2) 모든값에 대해서 내림차순정렬로 높은값부터 정렬을 진행합니다.
 * (3) 내림차순 정렬된 상태이므로 첫번째원소부터 ~ K번째 원소까지의 값을 answer에 담아 리턴합니다.
 */
public class leetcode_top_k_frequent_elements_kgh {
    public static void main(String[] args) {
        topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2);
//        topKFrequent(new int[] {1,1,1,2,2,3}, 2);
//        topKFrequent(new int[] {1,2}, 2);
    }
    /* 풀이 1 - Map, Collections */
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            m.compute(nums[i], (key, value) -> value == null ? 1 : value + 1);
        }
        List<Node> arrList = new ArrayList<>();
        for(Integer key : m.keySet()){
            arrList.add(new Node(key, m.get(key)));
        }
        Collections.sort(arrList);
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = arrList.get(i).key;
        }
        return answer;
    }
    static class Node implements Comparable<Node> {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.value, this.value);
        }
    }
}
