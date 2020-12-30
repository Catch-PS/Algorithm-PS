package 스터디.스터디_SNU.Section05;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 문제풀이시간: 15분
 * 2. 조합이란 순서에 상관없이 수를 뽑는 방식을 일컫는 방식을 말합니다. 조합을 구할때 recursive를 이용하여 모든 조합을 구해주었습니다.
 * basement조건은 cnt 값이 nums의 길이만큼 도달하였을때 해당되는 리스트를 add시켜주는 형식으로 진행하였습니다.
 * check변수를 두어 recursive시에 값이 중복되는것을 방지하였고, remove를 통해 기존에 선택된 값을 삭제시키고 방문하지 않은 다른 경우를 선택할 수 있게 구현하였습니다.
 *
 * 실수하였던 점은 static변수를 두어 값을 선언시 초기화하게 되면 static변수는 전역변수와 같이 data영역에 할당되는 영역이기때문에 릿코드에서 값을 동시에 할당받는 버그가 발생합니다.
 * 따라서, 값을 함수에 들어올때마다 값을 초기화하는 형식으로 진행하면 버그를 방지할 수 있습니다.
 *
 * 3. 시간복잡도
 * N= 주어진 수의 길이  모든 조합의 합은 이항계수의 성질에 따라 한번 재귀호출시마다 2개의 함수를 호출하기 때문에 시간복잡도는 O(2^N)을 가집니다.
 */
public class leetcode_permutation_kgh {
    static boolean[] check;
    static List<Integer> arrList;
    static List<List<Integer>> answer;
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
        permute(new int[]{0,1});
    }
    static List<List<Integer>> permute(int[] nums) {
        arrList = new ArrayList<>();
        answer = new ArrayList<>();
        int len = nums.length;
        check = new boolean[len];
        dfs(nums, len, 0);
        for(int i=0; i<answer.size(); i++){
            for(int j=0; j<answer.get(i).size(); j++){
                System.out.print(answer.get(i).get(j));
            }
            System.out.println();
        }
        return answer;
    }
    static void dfs(int[] nums, int len, int cnt) {
        if(cnt == len){
            answer.add(new ArrayList<>(arrList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(check[i]){
                continue;
            }
            check[i] = true;
            arrList.add(nums[i]);
            dfs(nums,len, cnt+1);
            arrList.remove(arrList.size()-1);
            check[i] = false;
        }
    }
}
