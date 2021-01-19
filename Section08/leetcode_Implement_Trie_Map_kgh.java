package 스터디.스터디_SNU.Section08;
import java.util.HashMap;
import java.util.Map;
/**
 * 1. 문제 풀이 시간: 40분
 * 내부클래스로 this 처리하다가 시간소요 ㅠㅠ, 외부 클래스로 변경
 * 2. 컴퓨팅사고
 * 트라이 알고리즘을 사용하는 문제, TridNode는 (TrieNode 자식노드, 현재 문자열의 끝지점에 도달하였는지 체크하는 변수)
 * (1)insert 기능
 * 현재 자식노드에 문자가가 없으면 -> 노드 생성, 있으면 값 다음 노드
 * (2)search 기능
 * 검색후 노드가 null이면 찾지 못하는 경우이므로 false, 아니면 마지막 노드의 끝 상태 반환
 * (3)startWith
 * 접두사를 찾아야하므로 계속진행하다가 문자없으면 false, 있으면 true
 * 3. 시간복잡도 O(N)
 */
public class leetcode_Implement_Trie_Map_kgh {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app"));         // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
class Trie{
    Map<Character, Trie> children;
    boolean isLeafNode;
    public Trie() {
        children = new HashMap<>();
        isLeafNode = false;         // 끝 지점 도달 체크
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for(char c: word.toCharArray()){
            curr.children.put(c, curr.children.getOrDefault(c, new Trie()));
            curr = curr.children.get(c);
        }
        curr.isLeafNode = true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for(char c : word.toCharArray()){
            // 문자 검색
            curr = curr.children.get(c);
            // 해당 문자가 없는 경우 false
            if(curr == null){
                return false;
            }
        }
        return curr.isLeafNode;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(char c : prefix.toCharArray()){
            // 문자 검색
            curr = curr.children.get(c);
            // 문자가 없는 경우
            if(curr == null){
                return false;
            }
        }
        return true;
    }
}
