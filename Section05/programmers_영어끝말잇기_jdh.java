/*
    풀이 시간: 15분
    예상 시간복잡도: for + get or contains() => O(n^2), 배열의 길이가 100이하이므로 시간 초과X
    풀이 방법: 끝말잇기 규칙에 따라 통과된 단어들을 LinkedList에 넣습니다. 만약 이전에 나온 단어이거나(contains로 판단)
                마지막으로 제시된 단어의 끝 글자와 제시할 단어의 첫 글자가 다르면 break로 탐색을 중단합니다.
                answer의 경우 [번호, 차례] 순으로 담아서 보내줘야 하는데 번호의 경우 LinkedList에 담긴 단어를 총 인원 수인
                n으로 나눈 나머지의 + 1이 되고 차례의 경우 / n의 + 1이 됩니다. + 1을 해주는 이유는 0번부터 배열이 시작되기 때문입니다.
 */

public class programmers_영어끝말잇기_jdh {

    public static int[] solution(int n, String[] words) {
        int answer[] = new int[2];
        LinkedList<String> list = new LinkedList<String>();

        for(int i = 0; i < words.length; i++){
            if(!list.isEmpty() && list.getLast().charAt(list.getLast().length() - 1) != words[i].charAt(0)
                    || !list.isEmpty() && list.contains(words[i])){
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
        String words[] = {"abb", "baa", "ccc", "cda", "abb"};
        System.out.println(Arrays.toString(solution(2, words)));
    }
}
