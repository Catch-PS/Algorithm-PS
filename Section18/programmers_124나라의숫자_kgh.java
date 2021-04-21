package 스터디.스터디_SNU.Section18;

/**
 * 1. 문제풀이시간: 30분
 * 2. 컴퓨팅 사고
 * (1) 10진법을 1,2,4나라 규칙에 따라 변경해야한다. 따라서, 해당 규칙을 찾아야한다.
 * 4 / 3 = 1 ,    4 % 3 = 1
 * 5 / 3 = 1 ,    5 % 3 = 2
 * 6 / 3 = 2(-1을 해주어야 규칙생성),     6 % 3 = 0
 *
 * 1,2,4나라의 규칙을 잘 살펴보면 n % 3의 값이 0일 경우 4로 바꾸어야 주어야하는 규칙을 찾을 수 있습니다.
 * 따라서, n%3이 0인 경우와 아닌 경우를 나누어주어야합니다.
 *
 * n%3이 0인 경우 해당 나머지값을 4로 변경합니다.
 * n%3이 0이 아닌 경우 3을 나누었을때 몫의 규칙이 맞지 않으므로 0인경우에만 현재 n/3을 해준 값에 -1을 해줍니다.
 *
 * (3) 시간복잡도
 * O(N)
 */
public class programmers_124나라의숫자_kgh {
    public static void main(String[] args) {
        solution(11);
    }
    static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        if(n == 1) return "1";
        else if(n == 2) return "2";
        else if(n == 3) return "4";
        while(n > 0){
            int r = n % 3;
            if(r == 0){
                r = 4;
                n = (n/3)-1;
            }else {
                n = (n/3);
            }
            sb.append(Integer.toString(r));
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
