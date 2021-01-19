package 스터디.스터디_SNU.Section08;

/**
 * 1. 문제 풀이 시간: 30분
 * 2. 컴퓨팅사고
 * 트라이 알고리즘을 사용하는 문제, TridNode는 (TrieNode 자식노드, 현재 문자열의 끝지점에 도달하였는지 체크하는 변수)
 * 배열로 character 변환하여 0~26인덱스 처리하는 방식
 * 3. 시간복잡도 O(N)
 */
public class leetcode_Implement_Trie_Array_kgh {
    public static void main(String[] args) {
        leetcode_Implement_Trie_Array_kgh trie = new leetcode_Implement_Trie_Array_kgh();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
    /** Initialize your data structure here. */
    public leetcode_Implement_Trie_Array_kgh() {
        root = new TrieNode();
    }

    class TrieNode{
        static final int ALPHA = 26;
        TrieNode[] child = new TrieNode[ALPHA];
        boolean isLeaf;
    }
    TrieNode root;


    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordArr = word.toCharArray();
        TrieNode tmpNode = root;

        for(char c : wordArr){
            int idx = c-'a';        // a = 0, b = 1 ...
            if(tmpNode.child[idx] == null){
                tmpNode.child[idx] = new TrieNode();
            }
            tmpNode = tmpNode.child[idx];
            System.out.println(tmpNode);

        }
        // 마지막 노드까지 도달했을경우 leaf노드에 도달한지 표시
        tmpNode.isLeaf = true;
        System.out.println("root=> " + root);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordArr = word.toCharArray();
        TrieNode tmpNode = root;

        for(char c : wordArr){
            int idx = c - 'a';      // a = 0, b = 1 ...
            if(tmpNode.child[idx] == null){
                return false;
            }
            tmpNode = tmpNode.child[idx];
        }
        // 끝 노드에 도착하였을때 null이 아니고 끝값이 아니면 false리턴
        if(tmpNode != null && tmpNode.isLeaf == false){
            return false;
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] prefixArr = prefix.toCharArray();
        TrieNode tmpNode = root;
        for(char c : prefixArr){
            int idx = c -'a';
            if(tmpNode.child[idx] == null){
                return false;
            }
            tmpNode = tmpNode.child[idx];
        }
        return true;
    }
}
