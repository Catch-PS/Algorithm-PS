package 스터디.스터디_SNU.Section18;

/**
 * 1. 문제풀이시간:5분
 * 2. 컴퓨팅사고
 * (1) 주어진 num값을 binary로 변경한 후 변경된 값중에서 1의 개수를 카운팅후 answer로 반환
 */
public class leetcode_counting_bits_kgh {
    public static void main(String[] args) {
        countBits(2);
        countBits(5);
    }
    static int[] countBits(int num) {

        int[] answer = new int[num+1];
        for(int i=0; i<=num;i ++){
            int cnt = 0;
            String s = Integer.toBinaryString(i);
            for(char c : s.toCharArray()){
                if(c == '1') cnt++;
            }
            answer[i] = cnt;
        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
        return answer;
    }
}
