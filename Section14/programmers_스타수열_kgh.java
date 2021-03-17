package 스터디.스터디_SNU.Section14;

import java.util.*;

/**
 * 1.문제풀이시간: 초과
 * 2. 컴퓨팅사고
 * (1)틀린 접근 방법
 * DFS로 모든 조합을 구해줍니다.
 * 중복되는 값을 방지하기위해 Set에 넣어줍니다.
 * Set에 있는 값을 하나씩 확인하면서
 * a[2*i-2] != a[2*i-1] 의 경우를 확인하여 이게 아닌경우 break를 진행합니다.
 * 해당되는 교집합을 찾기위해서 map을 이용하여 개수를 체크하여 증가를 시켜준 후 개수값이 해당되는 length와 같은 경우가 하나일경우에만 max값을 갱신시켜줍니다.
 * (1)올바른 접근 방법
 *
 * 조건 1: 스타수열은 길이가 반드시 2이상
 * 조건 2: 스타수열은 인접한 2개의 값을 묶었을때 하나의 집합
 * [idx0, idx1] ....
 * 조건 3: 조건2와 같이 인접한 2개의 값씩 묶었을때 각 집합에 있는 2개의 값은 서로 다른값
 *
 * (1) 가장많이 등장하는 숫자를 찾습니다. 이 값을 기준으로 스타수열을 만듭니다.
 * 공통된 원소는 원소의 갯수가 1개이상이여야하고 공통된 원소는 1개이상은 있어야한다.
 * 즉, 공통된 원소를 배열에서 가장 많이 등장하는 숫자로 선택
 * (2) 배열에 등장하는 횟수를 하나씩 꺼내면서 공통된 원소로 설정합니다.
 * (3) 공통된 원소로 사용할 값을 구했다면 배열을 탐색하면서 스타수열의 길이를 구합니다.
 * (4) Math.max를 사용하여 스타수열의 최대 길이를 구합니다.
 *
 테스트 케이스 예시)

 * Array = {1,2,1,3,2,4,3,5,6,7,3,8}
 * '1' 스타수열의 공통된 원소일 경우
 * [ 1 , 2 , 1 , 3 ] 으로 스타수열을 만들면, 길이가 4인 스타수열
 * '2'를 스타수열의 공통된 원소로 삼았을 때는 [ 2 , 1 , 2 , 4 ] 로 길이가 4인 스타수열
 * '3'을 스타수열의 공통된 원소로 삼았을 때는 [ 3 , 2 , 3 , 5 , 3 , 8 ] 로 길이가 6 스타수열
 * '4'를 스타수열의 공통된 원소로 삼았을 때는 [ 4 , 3 ] 으로 길이가 2인 스타수열
 * '5'를 ... '6'을... '7'을... '8'을 공통된 원소로 삼았을 때의 스타수열을 만들게 되면 길이가 '2'인 스타수열
 * 즉, 우리가 구한 스타수열의 길이들은 [ 4 , 4 , 6 , 2 , 2 , 2 , 2 ... ]
 */
public class programmers_스타수열_kgh {

    public static void main(String[] args) {
        solution(new int[]{5,2,3,3,5,3});
        solution(new int[]{0,3,3,0,7,2,0,2,2,0});
    }

    static int solution1(int[] a) {
        int answer = -1;
        int[] startArr = new int[a.length+1];
        // 가장 많이 등장한 숫자 횟수를 저장해줍니다.
        for(int i=0; i<a.length; i++){
            startArr[a[i]]++;
        }
        for(int i=0; i<startArr.length; i++) {
            // 등장횟수가 0인경우 더이상 볼필요가 없으므로 continue
            if (startArr[i] == 0) {
                continue;
            }
            // 등장횟수가 answer 이하인값은 스타수열의 길이를 더이상 체크할 필요없으므로
            if (startArr[i] <= answer) {
                continue;
            }
            // 해당 숫자가 사용된 횟수
            int numberCnt = 0;
            for (int j = 0; j < a.length - 1; j++) {
                // 인접한 2개의 값 중 어느하나라도 공통된 원소를 가지고 있어야하기 때문에 그렇지 않으면 다음값으로 진
                if (a[j] != i && a[j + 1] != i) {
                    continue;
                }
                // 인접한 두값이 같으면 안되므로 다음 값 진
                if (a[j] == a[j + 1]) {
                    continue;
                }

                numberCnt++;
                // 인접한 두값을 확인했으므로 증가
                j++;
            }
            answer = Math.max(answer, numberCnt);
        }
        // 해당숫자가 공통적으로 사용한 횟수이고 인접한 값을 하나씩 더 가지고 있으므로 answer*2
        return answer*2;
    }
    /**
     * 틀린 솔루션
     * @param a
     * @return
     */
    static boolean[] check;
    static LinkedList<Integer> arrList;
    static List<List<Integer>> answer = new ArrayList<>();
    static Set<String> hs = new HashSet<>();
    static int solution(int[] a) {
        check = new boolean[a.length];
        arrList = new LinkedList<>();

        dfs(a, 0);
        int max = 0;
        for (String s : hs) {
            boolean isCheck = false;
            Map<Character, Integer> m = new HashMap<>();
            System.out.println(s);
            for(int i=1; i<=s.length()/2; i++){
                if(s.charAt(2*i-2) != s.charAt(2*i-1)){
                    if(!m.containsKey(s.charAt(2*i-2))){
                        m.put(s.charAt(2*i-2),1);
                    }else if(m.containsKey(s.charAt(2*i-2))){
                        m.put(s.charAt(2*i-2),m.get(s.charAt(2*i-2))+1);
                    }

                    if(!m.containsKey(s.charAt(2*i-1))){
                        m.put(s.charAt(2*i-1),1);
                    }
                    else if(m.containsKey(s.charAt(2*i-1))){
                        m.put(s.charAt(2*i-1),m.get(s.charAt(2*i-1))+1);
                    }
                    System.out.println(s.charAt(2*i-2) + " " + s.charAt(2*i-1));
                }else {
                    isCheck = true;
                    System.out.println(isCheck);
                    break;
                }
            }
            int cnt = 0;
            // 모든값이 스타수열을 만족하는 경우
            if(!isCheck){
                for(Character c : m.keySet()){
                    int value = m.get(c);
                    if(value >= s.length()/2){
                        cnt++;
                    }
                }
                if(cnt == 1){
                    max = Math.max(max, s.length());
                }
            }
        }
        System.out.println(max);
        return max;
    }

    private static void dfs(int[] a, int cnt) {
        if(a.length == cnt){
            String tmpStr = "";
            for (Integer value : arrList) {
                tmpStr += Integer.toString(value);
            }
            hs.add(tmpStr);
            if(arrList.size() % 2  == 0) answer.add(new ArrayList<>(arrList));
            return;
        }
        check[cnt] = true;
        arrList.add(a[cnt]);
        dfs(a, cnt+1);
        arrList.removeLast();
        check[cnt] = false;
        dfs(a, cnt+1);
    }
}
