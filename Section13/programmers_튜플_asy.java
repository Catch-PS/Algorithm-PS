package kakao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * 1. 풀이시간 : 
 * 2. 예상 시간복잡도 : O(n)
 * 3. 풀이방법
 * {{4,2,3},{3},{2,3,4,1},{2,3}} -> [3,2,4,1]
 * {3} : 하나의 값만 있는 것은 무조건 "첫번째 튜플"(= 3)
 * {2,3} : 두 개의 값이 있는 것에서 첫번째 튜플을 제외하면 "두번째 튜플"(= 2)
 * {4,2,3} : 세 개의 값이 있는 것에서 첫번째, 두번째 튜플을 제외하면 "세번째 튜플"(= 4)
 * {2,3,4,1} : 네 개의 값이 있는 것에서 첫번째, 두번째, 세번째 튜플을 제외하면 "네번재 튜플"(=1)
 * -> 원소가 2개인 집합의 경우에 원소의 순서가 뒤바뀌어져 있어도, 원소가 1개인 집합의 값을 가지고 2번째 튜플이 무엇인지 유추 가능
 * -> n번째 튜플은 n-1개의 집합에서 유추 가능
 * 
 * 문자열 처리
 * {{4,2,3},{3},{2,3,4,1},{2,3}} -> {4,2,3},{3},{2,3,4,1},{2,3} -> {4,2,3#3#2,3,4,1#2,3} -> 4,2,3#3#2,3,4,1#2,3
 * 
 * arr[0] = 4,2,3
 * arr[1] = 3
 * arr[2] = 2,3,4,1
 * arr[3] = 2,3
 * 
 * -> TreeMap 사용 (자동으로 Key 기준 오름차순 정렬 -> 집합의 개수가 작은것이 가장 앞에 옴)
 *    key : 집합의 개수, value : 해당 집합의 배열
 * arr[0] = 3
 * arr[1] = 2,3
 * arr[2] = 4,2,3
 * arr[3] = 2,3,4,1
 * 
 * -> arr배열 각각에 있는 숫자들을 잘라서 TreeMap에 개수와 함께 넣어줌
 * TreeMap -> {1=[3], 2=[2,3], 3=[4,2,3], 4=[2,3,4,1]}
 * 
 * -> LinkedHashSet 사용 (삽입된 순서대로 접근, 데이터 중복 허용 X)
 */
public class programmers_튜플 {
	
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		s = s.substring(1, s.length()-1);
		s = s.replaceAll("\\}\\,\\{", "#");
		s = s.substring(1, s.length()-1);
		
		String[] arr = s.split("#");
		
		Map<Integer, Object> map = new TreeMap<Integer, Object>();
		for(int i=0; i<arr.length; i++) {
			String[] tuple = arr[i].split(",");
			map.put(tuple.length, tuple);
		}
		
		Iterator<Integer> mapItr = map.keySet().iterator();
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		while(mapItr.hasNext()) {
			int key = mapItr.next();
			String[] tupleTemp = (String[]) map.get(key);
			
			// 이전 값과 중복되면 넣지 않음
			// 이전 값 : 2, 3 / 현재 값 : 4, 2, 3 -> 2, 3(이전 값) + 4(현재 값)
			// 현재 값에서 4 뒤에 오는 2, 3은 이전 값과 중복되므로 넣지 않음
			for(String tuple : tupleTemp) {
				set.add(Integer.valueOf(tuple));
			}
		}
		
		//answer에 값 넣기
		int[] answer = new int[set.size()];
		Iterator<Integer> setItr = set.iterator();
		int i = 0;
		while(setItr.hasNext()) {
			answer[i] = setItr.next();
			i++;
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
