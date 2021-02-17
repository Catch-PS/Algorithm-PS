/*
    풀이 시간: 10분
    예상 시간복잡도: ..... O(n)...?
    풀이 방법: while 문 안에서 0제거 작업과 진법 변환을 두어 한 스텝으로 처리하게 구현했습니다.
            0를 따로 셀 필요없이 기존 문자의 길이와 0이 제거된 문자의 길이를 빼면 즉 0의 개수가 나오기 때문에 더해주었고,
            진법 변환은 Integer 클래스의 함수를 이용하여 변환했습니다.
 */

public class programmers_이진변환반복하기_jdh {

    public static int[] solution(String s) {
        int answer[] = new int[2];

        int cnt = 0;
        int zero = 0;
        while(true){
            if(s.length() == 1) break;

            // 0 제거
            String tmp = s.replace("0", "");
            zero += s.length() - tmp.length();

            // 진법 변환
           s = Integer.toBinaryString(tmp.length());

           cnt++;
        }

        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(solution("110010101001")));
    }
}
