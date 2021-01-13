package Section07;

import java.util.HashMap;
import java.util.Map;

/**
 * 풀이 시간 : 시간 초과
 * 풀이 방식 : 우선 주어진 입력이 100000이상이기 때문에 O(N^2)의 방식으로 완전 탐색을 하는 것은 불가능하다고 생각했습니다.
 * Trie 자료구조를 사용하여 검색하는 방식으로 풀었습니다.
 * Trie 자료구조는 문자열을 저장하고 효율적으로 탐색하기 위한 트리형태의 자료구조를 말합니다.
 * 데이터가 저장되는 형태는 다음과 같습니다.
 *  1        f
 *  2        r
 *  3        o
 *  4     d  z  n
 *  5    o   e   t
 *  6        n
 *  트리의 깊이는 문자열의 길이를 의미합니다.
 *  탐색 시에는 dfs 방식으로 문자열을 가져올 수 있습니다.
 *
 *  1. Trie 자료구조의 문자열을 각 길이를 나타내는 배열에 삽입합니다.
 *  2. '????o'와 같은 패턴을 처리하기 위해 반대로 된 형태도 배열을 생성하여 삽입합니다.
 *  3. '?????'와 같은 패턴을 처리하기 위해 쿼리 길이가 같은 문자열의 총 수를 담는 배열을 생성합니다.
 *  4. 삽입할 때에는 Trie 노드에 현재까지 일치하는 문자열의 개수를 함께 저장합니다.
 *  5. 모든 문자열을 삽입하고, Query 배열을 반복하고 '?'가 나타나게 되면 저장된 문자열 카운트를 반환합니다.
 *
 *  시간 복잡도 : O(N)
 *  공간 복잡도 : O(N)
 */
public class programmers_가사검색_oht {

  public int[] solution(String[] words, String[] queries) {
    int[] answer = new int[queries.length];
    Root[] tries = new Root[100001];
    Root[] reverseTries = new Root[100001];
    int[] queryCounts = new int[100001];

    for (String word : words) {
      int length = word.length();
      if (tries[length] == null) {
        tries[length] = new Root();
        reverseTries[length] = new Root();
      }
      tries[length].insert(word);
      reverseTries[length].insert(new StringBuilder(word).reverse().toString());
      queryCounts[length]++;
    }

    for (int i=0; i<queries.length; i++) {

      String query = queries[i];

      if (tries[query.length()] == null) {

        answer[i] = 0;
        continue;
      }

      if (query.charAt(0) == '?') {
        if (query.charAt(query.length() -1) == '?') {

          answer[i] = queryCounts[query.length()];
          continue;
        }
        query = new StringBuilder(query).reverse().toString();
        answer[i] = reverseTries[query.length()].search(query);
      } else {

        answer[i] = tries[query.length()].search(query);
      }
    }
    return answer;
  }
}

class Root {

  private Trie trie;

  public Root() {
    this.trie = new Trie();
  }

  public Trie getTrie() {
    return trie;
  }

  public void insert(String word) {

    Trie current = this.trie;

    for (int i = 0; i < word.length(); i++) {
      current = current.getChildMap().computeIfAbsent(word.charAt(i), c -> new Trie());
      current.count++;
    }
  }

  public int search(String prefix) {

    Trie current = this.trie;

    for (int i=0; i< prefix.length(); i++) {

      char ch = prefix.charAt(i);

      if (ch == '?') {
        break;
      }

      if (!current.getChildMap().containsKey(ch)) {
        return 0;
      }

      current = current.getChildMap().get(ch);
    }

    return current.count;
  }
}

class Trie {

  Map<Character, Trie> childMap = new HashMap<>();

  int count;

  public Map<Character, Trie> getChildMap() {
    return childMap;
  }

}