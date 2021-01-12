/*
    풀이 시간: 1시간 초과
    예상 시간복잡도: O(2 * n) => O(n)
    풀이 방법: 가장 먼저 n 제한을 보게 되면 일반적으로 하나하나씩 매칭하는 완전 탐색은 시간 초과를 유도합니다. 따라서 선형 탐색이 가능한 알고리즘을 선택해야 하고
             트라이 구조를 생각하게 되었습니다. 이분탐색을 처음에 시도했으나 쉽게 되지 않아 트라이로 변경을 하게 되었습니다.
             words 배열을 순회하면서 word 하나하나의 길이로 트라이 구조를 생성하는데 이때 기존에 만든 트라이 구조 중에서 같은 길이의 트라이 구조가 없다면 새로
             생성을 해주고 있으면 그 길이의 트라이를 사용해봅니다. 만약 길이가 같더라도 알파벳이 다르면 해당 트라이 구조를 사용할 수 없으므로 새로이 생성해줍니다.
             따라서 정리하자면 word의 길이를 기준으로 트라이를 생성하고 하나의 문자열을 전위 순회하면서 서브 노드들을 생성합니다. 이때 노드의 구조는 해당 노드의
             자식의 수를 의미하며 이는 해당 노드에서 중복이 발생한다는 의미입니다.
 */

public class programmers_가사검색_jdh {

    public static class Trie {
        int cnt = 0;
        Trie children[];

        public Trie(){
            this.cnt = 0;
            this.children = new Trie[26];
        }

        public void insert(char chars[]){
            Trie current = this;

            for(char ch : chars){
                ++current.cnt;
                if(current.children[ch - 'a'] == null) current.children[ch - 'a'] = new Trie();
                current = current.children[ch - 'a'];
            }
        }

        public int find(char queries[]){
            Trie current = this;

            for(char query : queries){
                if(query == '?') return current.cnt;
                if(current.children[query - 'a'] != null) current = current.children[query - 'a'];
                else return 0;
            }

            return current.cnt;
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int answer[] = new int[queries.length];

        Trie front[] = new Trie[10001];
        Trie back[] = new Trie[10001];

        for(String word : words){
            int length = word.length();

            if(front[length] == null) front[length] = new Trie();
            front[length].insert(word.toCharArray());

            if(back[length] == null) back[length] = new Trie();
            back[length].insert((new StringBuffer(word)).reverse().toString().toCharArray());
        }

        for(int i = 0; i < queries.length; i++){
            String query = queries[i];

            if(query.indexOf('?') != 0){
                if(front[query.length()] != null)
                    answer[i] = front[query.length()].find(query.toCharArray());
            }
            else {
                if(back[query.length()] != null)
                    answer[i] = back[query.length()].find((new StringBuffer(query)).reverse().toString().toCharArray());
            }
        }

        return answer;
    }

    public static void main(String args[]){
        String words[] = {"frodo", "front", "frost", "frozen", "frame", "kakao", "friday"};
        String queries[] = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(solution(words, queries)));
    }
}
