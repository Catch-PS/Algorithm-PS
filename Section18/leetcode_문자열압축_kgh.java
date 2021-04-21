package 스터디.스터디_GN.스터디_GN_2주차;

/**
 * 1. 문제 풀이 시간: 초과
 * 2. 컴퓨팅 사고
 *
 * (1) 몇개 단위로 값을 자를것인지를 체크해야합니다. 문자열이 s일경우 압축이 되기위해서는 (s의 길이 / 2)까지만 최대 압축을 진행할 수 있습니다.
 * (2) 단위만큼 값을 증기시키면서 이전 문자열과 비교하기 위한 문자열을 저장시킵니다.
 * (3) 저장된 문자열과 이전문자열이 같다면 압축을 진행한것이므로 압축값을 증가시킵니다(+1)
 * (4) 저장된 문자열과 이전문자열이 같지 않다면 더이상 압축할것이 없으므로 압축값들을 문자열로 저장시킵니다.
 * (단 압축된 개수가 1보다 클 경우만 개수를 추가하고 그게 아니라면 해당 문자열 자체만을 저장시킵니다.)
 * 그리고, 이 경우에는 예를들어 a != b 경우이므로 aabbaccc의 문자열에서 로직이 진행되었다고 할때 b에서 부터 다시 단위만큼 진행해야하므로
 * compressionCnt값을 1로 초기화시키고 현재 b의 값을 compresssionFirst값에 갱신시켜줍니다.
 * (5) 한번의 단위검색이 모두 끝났을 경우 현재 compression에 담겨진 문자열의 길이와 answer(s의 길이와 비교)를 통해 더 작은값으로 갱신을 진행합니다.
 *
 */
public class 문자열압축 {
    public static void main(String[] args) {
        solution("aabbaccc");
    }
    static int solution(String s) {
        int answer = s.length();
        // 자를 부분 문자의 개수
        for(int i=1; i<=s.length()/2; i++){
            String compressionStr = "";
            String compFirst = s.substring(0, i);
            int compressionCnt = 1;
            // 단위만큼 크기를 증가시키며 이전 문자열과 비교
            for(int j=i; j<s.length(); j += i) {
                String compSecond = "";
                // 단위만큼 값을 가져온다.
                for(int k = j; k < j + i; k++){
                    if(k < s.length()) compSecond += s.charAt(k);
                }
                // 첫번째 기준값과 현재 나온 문자열의 값이 같다면 압축횟수 증가
                if(compFirst.equals(compSecond)) compressionCnt++;
                // 다른 문자열이 나왔던 경우라면(더 이상 압축하지 못하는 경우라면)
                else {
                    // 압축하는 부분 (숫자 + 문자열)
                    if (compressionCnt > 1) compressionStr += (compressionCnt + compFirst);
                    else compressionStr += compFirst;
                    compSecond = "";
                    // 다음으로 진행하기전 현재 다른 문자열이 나온값을 비교값으로 설정
                    for (int k = j; k < j + i; k++) {
                        if (k < s.length()) compSecond += s.charAt(k);
                    }
                    // 다음 로직 이동전 값 초기화 부분
                    compFirst = compSecond;
                    compressionCnt = 1;
                }
            }
            // 맨 마지막에 압축된 결과값이 들어가지 않으므로 이부분을 통해 최종 결과값을 붙여줍니다.
            if (compressionCnt > 1) compressionStr += (compressionCnt + compFirst);
            else compressionStr += compFirst;
            // 최솟값 갱신시켜줍니다.
            answer = Math.min(answer, compressionStr.length());
        }
        System.out.println(answer);
        return 0;
    }
}
/*
import java.util.*;

class Solution {

    public int solution(String s) {
        int answer = s.length();
        // 1개 단위(step)부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step); // 앞에서부터 step만큼의 문자열 추출
            int cnt = 1;
            // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < s.length(); j += step) {
                // 이전 상태와 동일하다면 압축 횟수(count) 증가
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt += 1;
                // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
                else {
                    compressed += (cnt >= 2)? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }
            // 남아있는 문자열에 대해서 처리
            compressed += (cnt >= 2)? cnt + prev : prev;
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}
 */