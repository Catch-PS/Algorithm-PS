package Leetcode;
//https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 1. 문제 풀이 시간: 15분
 * 2. 풀이 방법
 *   1) 배열 오름차순으로 정렬
 *   2) 리스트에 배열 추가
 *   3) 리스트 순서 reverse
 *   4) k-1번째 인덱스 출력
 */

public class kthLargest {
    public static int findKthLargest(int[] nums, int k) {
        int answer = 0;
        //우선 순서대로 정렬
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        for(int number : nums){
            //리스트에 추가
                list.add(number);

        }
        //내림차순으로 정렬
        Collections.reverse(list);
        //k-1번째 출력
        answer = list.get(k-1);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}
