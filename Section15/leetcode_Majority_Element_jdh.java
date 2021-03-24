/*
    풀이 시간: 12분
    예상 시간복잡도: O(n)... 찾아보니까 hashmap의 contains의 경우 O(1)이라고 합니다.
    풀이 방법: 처음에는 LinkedList로 풀려고 했으나 시간 복잡도를 줄이기 위해 HashMap을 사용했습니다.
            key를 3, 2와 같은 숫자로 사용했고 value를 해당 숫자가 몇번 등장했는지 cnt를 저장하는 형태로 사용했습니다.
            iterator를 얻어서 저장된 cnt를 보면서 기준이 되는 base 이상인 cnt의 key를 담아 반환하는 방식으로 구현했습니다.
 */
public class leetcode_Majority_Element_jdh {

    public static int majorityElement(int[] nums) {
        int result = 0;
        int base = (int) Math.ceil(nums.length / 2.0);
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!hm.isEmpty() && hm.keySet().contains(nums[i])){
                int cnt = hm.get(nums[i]);
                hm.put(nums[i], cnt + 1);
            }
            else {
                hm.put(nums[i], 1);
            }
        }

        Iterator<Integer> it = hm.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            int num = hm.get(key);
            if(num >= base) result = key;
        }

        return result;
    }

    public static void main(String args[]){
        int nums[] = {6,5,5};
        System.out.println(majorityElement(nums));
    }
}
