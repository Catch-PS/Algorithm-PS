/*
    풀이 시간: 4분
    예상 시간복잡도: O(n)
    풀이 방법: Trie의 자식으로 LinkedList를 사용하여 최대한 많이 라이브러리를 사용하여 해결했습니다.
 */

public class leetcode_Implement_Trie_jdh {
    public static class Trie {
        LinkedList<String> children;

        public Trie() {
            children = new LinkedList<String>();
        }

        public void insert(String word) {
            children.add(word);
        }

        public boolean search(String word) {
            if(children.contains(word)) return true;
            else return false;
        }

        public boolean startsWith(String prefix) {
            for(String current : children){
                if(current.length() < prefix.length()) continue;
                if(current.substring(0, prefix.length()).equals(prefix)) return true;
            }

            return false;
        }
    }
    public static void main(String agrs[]){
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
