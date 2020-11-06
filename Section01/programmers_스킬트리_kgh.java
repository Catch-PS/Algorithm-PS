package Study;
// comment: 1주차 알고리즘 Programmers 스킬트리 문제
// comment: https://programmers.co.kr/learn/courses/30/lessons/49993

/*
풀이시간: 18분 16초
*/
public class programmers_스킬트리_kgh {
    public static void main(String[] args) {
        solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            int idx = 0;
            boolean tf = false;
            for(int j=0; j<skill_trees[i].length(); j++){
                int search = skill.indexOf(skill_trees[i].charAt(j));
                if(idx < search){
                    tf = true;
                    break;
                }else if(idx == search){
                    idx++;
                }
            }
            if(tf == false){
                answer++;
            }
        }
        return answer;
    }
}
