package Section08;

import java.util.HashMap;
import java.util.Map;

/**
 * 풀이시간 : 20분
 *
 * 풀이방식 :
 * Trie는 자식 노드의 key로 char를, value로 Trie를 가진 Map을 가집니다.
 * 추가적으로 현재 단어가 끝났는지 확인하는 isEnd 를 갖습니다.
 *
 * 1. insert 시에는 Map에서 character를 검색하고 있으면 다음 Trie를 가져오고, 없으면 새로운 Trie를 만듭니다.
 * 2. search 시에는 Map에서 character를 검색하고 있으면 다음 Trie를 가져오고, 없으면 false를 반환합니다.
 *    최종 노드에서는 현재 문자가 마지막 문자인지 여부를 확인합니다.
 *
 * 3. startsWith에서는  search와 동일하지만 노드의 마지막 문자를 확인하지 않습니다.
 *
 * 시간 복잡도 : O(N) 각 메소드가 문자열 길이만큼 걸림.
 */
public class leetcode_Implement_Trie_oht {

  public static void main(String[] args) {

    Trie obj = new Trie();

    String s = "hello";

    obj.insert(s);

    if (obj.search(s)) {
      System.out.println(s + "가 존재합니다.");
    }

    if (obj.startsWith("hell")) {

      System.out.println("prefix가 존재합니다.");
    }
  }
}

class Trie {

  Map<Character, Trie> childMap = new HashMap<>();

  boolean isEnd;

  /** Initialize your data structure here. */
  public Trie() {

  }

  /** Inserts a word into the trie. */
  public void insert(String word) {

    Trie trie = this;

    for (int i=0; i<word.length(); i++) {

      char ch = word.charAt(i);

      if (!trie.childMap.containsKey(ch)) {

        trie.childMap.put(ch, new Trie());
      }

      trie = trie.childMap.get(ch);
    }

    trie.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {

    Trie trie = this;

    for (int i=0; i<word.length(); i++) {

      char ch = word.charAt(i);

      if (trie.childMap.containsKey(ch)) {

        trie = trie.childMap.get(ch);
      } else {

        return false;
      }
    }

    return trie.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {

    Trie trie = this;

    for (int i=0; i<prefix.length(); i++) {

      char ch = prefix.charAt(i);

      if (trie.childMap.containsKey(ch)) {

        trie = trie.childMap.get(ch);
      } else {

        return false;
      }
    }

    return true;
  }
}
