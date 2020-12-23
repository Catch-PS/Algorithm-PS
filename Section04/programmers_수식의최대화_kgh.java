package 스터디.스터디_SNU.Section04;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 풀이시간: 초과
 * 2. 컴퓨팅 사고
 * +, -, * 에 대한 모든 조합의 경우를 구해준다.
 * 조합의 매번의 경우의 값에 대한 연산을 처리를 진행한다. 이때, 기존에 숫자, 연산자를 담고있는 값들의 변경이 있어서는 안되기 때문에
 * copy를 통하여 새로운 리스트에 담아주면서 연산을 처리한다.
 * 3. 값을 재 갱신하여 처리하는 부분에 있어서 꼼꼼히 체크하고 절대값을 씌운 최댓값을 계속 갱신하여 진행합니다.
 * 시간복잡도: O(수식의 길이 + 연산자 3가지 모든 경우의 재귀함수 + (3 * 수식에서 연산자의 개수))
 */
public class programmers_수식의최대화_kgh {
    static int[] check = new int[3];
    static char[] combination = {'+','-','*'};
    static Long answer = 0L;
    static List<Long> numbers = new ArrayList<>();
    static List<Character> cals = new ArrayList<>();
    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }
    private static void solution(String expression) {
        String expression_number = "";
        for(int i=0; i<expression.length(); i++){
            // 숫자인 경우
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                expression_number += expression.charAt(i);
            }else {
                numbers.add(Long.parseLong(expression_number));
                cals.add(expression.charAt(i));
                expression_number = "";
            }
        }
        numbers.add(Long.parseLong(expression_number));
        dfs("",0);
        System.out.println(answer);
    }

    private static void dfs(String op, int cnt) {

        if(cnt == 3){

            List<Long> numbersCopy = new ArrayList<>(numbers);
            List<Character> calsCopy = new ArrayList<>(cals);

            for(int i=0; i<op.length(); i++){
                for(int j=0; j<calsCopy.size(); j++){
                    if(op.charAt(i) == calsCopy.get(j)){

                        Long start_num = numbersCopy.get(j);
                        numbersCopy.remove(j);
                        Long end_num = numbersCopy.get(j);
                        numbersCopy.remove(j);
                        Long res = 0L;
                        // 연산자 계산
                        if(op.charAt(i) == '+') res = start_num + end_num;
                        else if(op.charAt(i) == '-') res = start_num - end_num;
                        else if(op.charAt(i) == '*') res = start_num * end_num;

                        // 연산값 넣어주기 갱신
                        numbersCopy.add(j, res);
                        calsCopy.remove(j);
                        // 값을 하나 제거했으므로 이전부터 다시 값을 처리
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(numbersCopy.get(0)));
            return;
        }

        for(int i=0; i<combination.length; i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            dfs(op+combination[i], cnt+1);
            check[i] = 0;
        }
    }
}
