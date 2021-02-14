package 스터디.스터디_SNU.Section12;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 문제풀이시간: 15분
 * 2. 이진변환시 재귀함수를 통하여 0을 제거 개수와 몇번 재귀를 돌았는지를 체크해서 반환시켜주면 되는 문제
 * 3. 시간복잡도
 * O(DFS)
 */
public class programmers_이진변환하기_kgh {
    static int zeroCnt = 0;
    static int loopCnt = 0;
    public static void main(String[] args) {
        solution("01110");
        solution("110010101001");
    }
    static int[] solution(String s) {
        int[] answer = new int[2];
        // 1. 이진변환 진행
        getConvertBinary(s);
        if(zeroCnt != 0 && loopCnt != 0){
            answer[0] = loopCnt;
            answer[1] = zeroCnt;
        }
        return answer;
    }
    private static void getConvertBinary(String s) {
        // 1. 이진변환 0 제거
        int originLen = s.length();
        s = s.replaceAll("0","");
        int removeLen = s.length();
        // 2. 이진변환 0 제거 개수
        zeroCnt += originLen - removeLen;
        // 3. 이진변환 몇번의 과정 개수 체크
        loopCnt++;
        List<Integer> arrList = new ArrayList<>();
        int num = s.length();
        // 4. 이진변환 리스트에 담아주기
        while(num > 0){
            int div = num % 2;
            num = num / 2;
            arrList.add(div);
        }
        // 5. 이진변환후 반전
        Collections.reverse(arrList);
        if(arrList.size() == 1 && arrList.get(0) == 1){
            return;
        }else {
            String str = "";
            for(int i=0; i<arrList.size(); i++){
                str += arrList.get(i);
            }
            getConvertBinary(str);
        }
    }
}
