package 스터디.스터디_SNU.Section18;

/**
 * 1. 문제풀이시간: 20분
 * 2. 컴퓨팅 사고
 * (1) 각 스킬트리들을 순회하면서 각문자들을 꺼냅니다.
 * (2) 꺼내어진 문자들을 가지고 skill에 위치를 찾아냅니다.
 * (3) 스킬은 순차적으로 배워야하기때문에 현재 위치해있는 스킬의 인덱스값의 범위보다 커버리면 올바른 스킬을 배운게 아닙니다.
 * (4) 올바른 스킬을 배웠다고 하는것은 찾아낸 인덱스가 계속 같아져야한다는뜻과 같습니다.
 * (5) indexOf함수를 사용하면 손쉽게 해당 문자의 위치 idx값을 찾아낼 수 있습니다.
 *
 * 3. 시간복잡도
 * O(N^2)
 */
public class programmers_스킬트리_kgh {
    public static void main(String[] args) {
        solution("CBD", new String[]{"BACDE","CBADF","AECB","BDA"});
    }
    static int solution(String skill, String[] skill_trees){
        int answer = 0;
        for(String skill_tree : skill_trees){
            int idx = 0;
            boolean isChecked = false;
            for(char c : skill_tree.toCharArray()){
                if(skill.indexOf(c) > idx) {
                    isChecked = true;
                    break;
                }
                if(skill.indexOf(c) == idx) idx++;
            }
            if(!isChecked) answer++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

}
