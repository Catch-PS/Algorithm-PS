/*
    풀이 시간: 25분
*/

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = skill_trees.length;

        for(int i = 0; i < skill_trees.length; i++){
            String tmp_skill = skill_trees[i];
            boolean isSuccess = true;
            boolean isSelected[] = new boolean[skill.length()];

            for(int j = 0; j < tmp_skill.length(); j++){
                int idx = skill.indexOf(tmp_skill.charAt(j));

                if(idx >= 0){
                    for(int k = 0; k < idx; k++){
                        if(!isSelected[k]){
                            isSuccess = false;
                            break;
                        }
                    }

                    if(isSuccess){
                        isSelected[idx] = true;
                    } else {
                        result--;
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}
