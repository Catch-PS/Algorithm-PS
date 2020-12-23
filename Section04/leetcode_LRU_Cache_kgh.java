package 스터디.스터디_SNU.Section04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 문제 풀이 시간: 40분
 *
 * 컴퓨팅 사고:
 * LRU Cache는 가장 오래 사용하지 않은 페이지값을 교체해주는 알고리즘, 계산시 프레임 사이즈만큼 폴트 처리값을 확인해주면서 없을 경우 확장시켜나갑니다.
 * 입력이 어떻게 들어오는지 처음에 테스트하느라 시간을 좀 소모하였습니다.(Key,Value)맵중에서 순서가 유지되야 하므로 LinkedHashMap을 사용하였습니다.
 * get(): 페이지 캐시값을 얻어오는 함수
 * 문제의 조건에서 키값이 존재하지 않으면 return -1을 처리하였고, 기존에 가지고 있던 키를 제거하고 우선순위를 가장 높게 설정(사용하였기때문에)
 * put(): 페이지 캐시값을 넣는 함수
 * 맵에 이미 들어가있는 키인경우 해당 키값을 제거해주고 다시 우선순위를 갱신시켜줍니다.(사용하였기때문에)
 * 그리고 페이지 프레임 개수보다 큰 경우에는 가장오래된 페이지(가장 맨 앞에 사용되지 않은 페이지)를 제거해줍니다. keyset을 사용하여 맨 처음값을 제거하고 우선순위를 갱신해줍니다.
 * 시간복잡도: O(N) N:입력 사이즈
 * 평균적으로 O(N) 최악의 경우 삽입삭제 O(N), 검색의 경우 O(1) 체이닝, Open Addressing, Chaining 기법을 적용하면 최적의 해를 가질 수 있을 것이라고 생각합니다.
 */
public class leetcode_LRU_Cache_kgh {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1); // cache is {1=1}
        System.out.print("null ");
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.print("null ");
        System.out.print(lRUCache.get(1)+" ");    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.print("null ");
        System.out.print(lRUCache.get(2)+" ");    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.print("null ");
        System.out.print(lRUCache.get(1)+" ");    // return -1 (not found)
        System.out.print(lRUCache.get(3)+" ");    // return 3
        System.out.print(lRUCache.get(4)+" ");    // return 4
    }

    public static class LRUCache{

        private Map<Integer, Integer> m = new LinkedHashMap<>();
        private int capacity = 0;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }
        public int get(int key) {
            // 포함되어 있지 않으면
            if(!m.containsKey(key)) return -1;
            // 포함되어 있으면
            else {
                // 우선순위 변경
                int target = m.get(key);
                m.remove(key);
                m.put(key, target);
            }
            return m.get(key);
        }
        public void put(int key, int value) {
            // 포함되어 있는 경우
            if(m.containsKey(key)){
                m.remove(key);
            }else {
                // 페이지 프레임 개수 보다 클 경우
                if(capacity <= m.size()) {
                    // 가장 오래된 페이지 제거
                    for(Integer k : m.keySet()) {
                        m.remove(k);
                        break;
                    }
                }
            }
            m.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
