/*
    풀이 시간: 8분
    예상 시간복잡도: O(n^2)
    풀이 방법: LinkedList를 이용하여 구현했습니다. contains로 이미 나온 단어인지 확인하고,
            getLast()를 이용하여 가장 최근에 나온 단어를 추출해 마지막 글자가 제시하는 첫 글자와 일치하는지 확인합니다.
 */
public class programmers_영어끝말잇기_jdh {
    public static int[] solution(int n, String[] words) {
        int answer[] = new int[2];
        LinkedList<String> list = new LinkedList<>();

        for(int i = 0; i < words.length; i++){
            if(!list.isEmpty() && list.contains(words[i])
                    || !list.isEmpty() && list.getLast().charAt(list.getLast().length() - 1) != words[i].charAt(0)) {
                answer[0] = (list.size() % n) + 1;
                answer[1] = (list.size() / n) + 1;
                break;
            }
            else {
                list.add(words[i]);
            }
        }

        return answer;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }
}
