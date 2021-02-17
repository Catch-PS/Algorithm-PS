import java.util.*;
/*
 * 1. 풀이시간 : 1시간 30분
 * 2. 풀이방법
     이전에 등장했던 단어 or 앞에 사람이 말한 단어의 끝 문자와 일치하지 않는 시작 문자의 단어
     hello, one / even, never / "now", world / draw -> [1번 사람, 3번째 회차]
       0     1      2     3       4      5      6
     
     (1) for문 -> 앞, 뒤 단어의 문자 일치 여부 판단
         s마지막 문자 : words[i].charAt(words.length() - 1)
         첫번재 문자 : words[i+1].charAt(0)
     (2) 지나간 단어 ArrayList에 삽입 -> 해당 단어가 ArrayList에 포함되어 있는지 확인해서 있다면 멈춤
     
     조건에 부합하지 않는 단어인 now의 index : 4
     ★ 몇 변째 사람인지 구하는 방법 : ((4 + 1) % 2) + 1 -> ((index+1) % n) + 1
        -> index 기준으로 index+1 인 문자열을 구해야하므로 (index+1)을 해줌
     ★ 몇 회차인지 구하는 방법 : for문 돌면서 (index % n) == 0 이면 rotationCnt를 증가
        -> rotationCnt의 초기값을 1로 둬야함(index 기준 다음 index, 즉 index+1 일 때 구해야하기 때문)
        -> 앞, 뒤 단어의 문자가 다르거나, 앞에 나왔던 단어를 말한 경우 break로 빠져나가는데
            이 전 단계에서 turnSeq를 하나 증가시켜줘야함
            (같은 회차의 마지막 순번의 사람은 break로 인해 위로 올라가서 turnSeq를 증가시켜줄 수 없음)
 * 3. 예상 시간복잡도 : O(n)
 */
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        ArrayList<String> check = new ArrayList<String>();  // 지나간 문자들을 넣어두는 list
        int personSeq = 0;  // 몇 번째 사람인지
        int turnSeq = 0;    // 몇 회차인지
        
        // 앞, 뒤 단어 문자 일치 여부 확인
        for(int i=0; i<words.length-1; i++){
            if( (i%n) == 0 ){
                turnSeq++;
            }
            
            System.out.println("if 직전");
            System.out.println("★★★ i : " + i);
            System.out.println("★★★ turnSeq : " + turnSeq);
            // 앞, 뒤 단어의 문자가 일치하고, 앞에 나왔던 단어를 말하지 않으면 -> list에 단어 삽입(검증 용도)
            if( (words[i].charAt(words[i].length() - 1) == words[i+1].charAt(0)) && (!check.contains(words[i+1])) ) {
                System.out.println("조건에 부합");
                System.out.println("words[" + i + "] : " + words[i] + " / " + "words[" + (i+1) + "] : " + words[i+1]);
                check.add(words[i]);
            }
            // 앞, 뒤 단어의 문자가 다르거나, 앞에 나왔던 단어를 말하면 -> 몇 번째 사람인지, 몇 회차인지 구함
            else if( (words[i].charAt(words[i].length() - 1) != words[i+1].charAt(0)) || (check.contains(words[i+1])) ) {
                System.out.println("조건에 부합X");
                System.out.println("words[" + i + "] : " + words[i] + " / " + "words[" + (i+1) + "] : " + words[i+1]);
                personSeq = ((i+1) % n) + 1;
                
                System.out.println("break 직전");
                System.out.println("★★★ turnSeq : " + turnSeq);
                // 회차의 마지막 순번이면 turnSeq를 하나 더 증가시켜줌(break로 인해 빠져나감으로써 뒤에서 turnSeq를 못 증가시켜주므로)
                if(i%n == n-1) {
                    turnSeq++;
                }
                break;
            }
        }
        // 탈락자가 발생하지 않는다면
        if(personSeq == 0){
            answer = new int[] {0, 0};
        }
        // 탈락자가 발생했다면
        else {
            answer = new int[] {personSeq, turnSeq};
        }

        return answer;
    }
}