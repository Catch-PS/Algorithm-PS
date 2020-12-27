/*
    풀이 시간: 8분
    예상 시간복잡도:
    풀이 방법: 재귀적인 방법을 사용했습니다. isSelected 배열을 통해서 선택되었던 원소를 다시 선택하지 못하게 했습니다.
            기저 조건으로는 선택한 원소의 수가 nums수와 동일해지면 결과에 저장하고 return 했습니다.
 */
public class leetcode_Permutations_jdh {
    public static boolean isSelected[];
    public static List<List<Integer>> result;
    public static int tmpNum[];

    public static List<List<Integer>> permute(int[] nums) {
        isSelected = new boolean[nums.length];
        tmpNum = new int[nums.length];
        result = new LinkedList<>();

        permutation(0, nums);

        return result;
    }

    public static void permutation(int cnt, int nums[]){
        if(cnt == nums.length){
            LinkedList<Integer> tmpList = new LinkedList<Integer>();
            for(int i = 0; i < tmpNum.length; i++){
                tmpList.add(tmpNum[i]);
            }
            result.add(tmpList);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(isSelected[i]) continue;
            tmpNum[cnt] = nums[i];
            isSelected[i] = true;
            permutation(cnt + 1, nums);
            isSelected[i] = false;
        }
    }
}
