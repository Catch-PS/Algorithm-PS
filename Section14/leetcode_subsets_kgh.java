package 스터디.스터디_SNU.Section14;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 문제풀이시간: 52분
 * 2. 컴퓨팅 사고
 * (1) 중복되는 subsets이 존재하지 않아야하기때문에 조합으로 진행
 * (2) 중복되는값을 방지하기 위하여 체크배열 선언
 * (3) return 조건은 진행된값이 num의 길이와 같을 경우 종료
 여기서 중요한 점은 만약 num길이가 3이라면 무조건 3개의 원소들만 반환시켜야한다고 생각할 수 있다.
 하지만, 우리가 구해야할것은 1개의원소, 2개의원소, 3개의원소...의 조합을 구해야하기때문에
 하나의 리스트에 해당되는 원소들을 담아주고 마지막에 있는값들을 빼주면서 경우의 수를 다시 체크해야합니다.
 즉, 원소의 마지막을 제거 후 한번의 Recursive를 진행하게 되면 하나의 리스트에는 마지막 값을 뺀 나머지 원소들이 들어가있기 대문에
 원하는 1개의원소, 2개의원소, 3개의 원소의 값들을 구할 수 있게됩니다.
 어려웠던점은 basement 조건 nums.length >= cnt && cnt !=0을 주면서 처리하였지만, Recursive과정에서 1개이상의 원소조합을 구할 수 없었습니다.
 따라서, basement 조건을 nums 길이에 맞춰주고, 마지막 원소를 제거한 후 다시 recursive를 돌려주는 로직으로 변경하였습니다.
 */

public class leetcode_subsets_kgh {
    static List<Integer> arrList = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();
    static boolean[] check;
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }
    static List<List<Integer>> subsets(int[] nums) {
        check = new boolean[nums.length];
        dfs(nums,0);
        return answer;
    }
    static void dfs(int[] nums, int cnt) {
        // basement condition
        if(nums.length == cnt){
            answer.add(new ArrayList<>(arrList));
            System.out.println(arrList);
            return;
        }
        check[cnt] = true;
        arrList.add(nums[cnt]);
        dfs(nums, cnt+1);
        arrList.remove(arrList.size()-1);
        check[cnt] = false;
        // 마지막 원소 제거후 다시 Recursive
        dfs(nums, cnt+1);
    }
}
