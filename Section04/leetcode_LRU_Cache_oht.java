package Section04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 풀이 시간 : 40분
 * 접근 방식 : LRU는 가장 최근에 접근한 노드를 가장 앞에 위치시켜야 하기 때문에
 * 삽입과 삭제의 복잡도가 높으면 전반적으로 처리 시간이 늘어날 것이라고 생각했습니다.
 * 상대적으로 삽입과 삭제의 복잡도가 적은 LinkedList를 사용하여 키를 보관하여 인덱스 테이블을 구성하고,
 * 인덱스를 통해 키를 찾으면 HashMap에서 조회할 수 있도록 했습니다.
 *
 * 시간복잡도: O(N) LinkedList의 키를 조회하는 복잡도가 O(N) 으로 예상되어 결국에는 O(N)이 되는 것 같습니다.
 */
public class leetcode_LRU_Cache_oht {

  public static void main(String[] args) {

    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 3);
    lruCache.put(2, 4);
    lruCache.put(1, 2);
    lruCache.put(3, 2);

  }
}

class LRUCache {

  LinkedList<Integer> keys = new LinkedList<>();
  Map<Integer, Integer> values = new HashMap<>();

  private final int capacity;

  protected LRUCache(int capacity) {

    this.capacity = capacity;
  }

  protected int get(int key) {

    int index = keys.indexOf(key);

    if (index < 0) { return -1; }

    keys.remove(index);
    keys.addFirst(key);

    return values.get(key);
  }

  protected void put(int key, int value) {

    if (get(key) != -1) {

      values.put(key, value);
      return;
    } //데이터 조회를 통해

    if (keys.size() == capacity) {

      values.remove(keys.pollLast());

    }

    keys.addFirst(key);
    values.put(key, value);
  }
}