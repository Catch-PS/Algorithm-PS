package 스터디.스터디_SNU.Section17;

/**
 * 1. 문제풀이시간: 20분
 * 2. 컴퓨팅사고
 * 문제에서 주어진대로 N - 1000001까지의 값을 하나씩 확인하면서
 * N의 1의 개수와 N+1 - 1000001의 값을 비교하면서 이진법으로 변환후 '1'의 개수를 확인합니다.
 * 그게 아닐경우 N의 값을 증가시키면서 확인을 진행합니다.
 *
 */
public class 다음큰숫자 {
    public static void main(String[] args) {
        solution(78);
    }
    static int solution(int n){
        String nToBinartStr = Integer.toBinaryString(n);
        int nCount = countFunction(nToBinartStr);
        int start = n+1;
        while(start < 1000001){
            String startToBinaryStr = Integer.toBinaryString(start);
            int startCount = countFunction(startToBinaryStr);
            if(nCount == startCount && n < start){
//                System.out.println("start = " + start);
                return start;
            }
            start++;
        }
//        System.out.println("start = " + start);
        return start;
    }
    static int countFunction(String binaryStr){
        int count = 0;
        for(char c : binaryStr.toCharArray()){
            if(c == '1') count++;
        }
        return count;
    }

}
