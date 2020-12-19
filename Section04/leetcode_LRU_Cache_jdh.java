/*
    풀이 시간: 30분
    예상 복잡도: O(1)
    풀이 방법: 가장 접근한 지 오래된 데이터부터 삭제해야 하고 [key, value] 방식으로 데이터에 접근할 수 있어야 함.
              [key, value] 방식의 hashmap을 사용하면서 순서를 보장해주는 LinkedHashMap을 사용
              접근할 때마다 삭제하고 다시 넣어주는 방식으로 접근 순서를 보장할 수 있음.
 */
public class leetcode_LRU_Cache_jdh {

    public static class LRUCache {
        LinkedHashMap<Integer, Integer> hm;
        int capacity, idx;

        public LRUCache(int capacity) {
            this.hm = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(hm.get(key) == null) return -1;
            else {
                int value = hm.get(key);
                hm.remove(key);
                hm.put(key, value);
                return hm.get(key);
            }
        }

        public void put(int key, int value) {
            if(hm.containsKey(key)){
                hm.remove(key);
            }
            else {
                if(hm.size() >= capacity) {
                    int rmKey = hm.keySet().iterator().next();
                    hm.remove(rmKey);
                }
            }
            hm.put(key, value);
        }
    }
}
