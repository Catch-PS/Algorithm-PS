package Section13;

import java.util.*;

/**
 * 풀이 시간 : 1시간
 *
 * 풀이 방식 :
 *
 * 1. 우선 문자열을 파싱해서 2차원 배열에 tuple을 분리합니다.
 * {{2}
 *  {2, 1},
 *  {1, 2, 3},
 *  {1, 2, 3, 4}}
 *
 * 2. 2차원 배열 tuples 를 내부 배열의 크기로 정렬합니다.
 * 3. 튜플의 크기가 1인 배열부터 차례로 Set 넣에서 중복 체크를 하고 중복된 값은 삽입하지 않습니다.
 * 4. List 로 만든 배열을 int[] 배열로 변환합니다.
 *
 * 시간 복잡도 : O(N^2)
 *
 */
public class programmers_튜플_oht {

  public int[] solution(String s) {

    List<List<Integer>> tuples = new ArrayList<>();
    List<Integer> answers = new ArrayList<>();
    classify(s, tuples);

    tuples.sort(Comparator.comparingInt(List::size));

    Set<Integer> check = new HashSet<>();

    for (List<Integer> tuple : tuples) {

      for (int element : tuple) {

        if (!check.contains(element)) {

          answers.add(element);
          check.add(element);
        }
      }
    }

    return answers.stream().mapToInt(Integer::intValue).toArray();
  }

  private void classify(String s, List<List<Integer>> tuples) {

    String tmp = s.substring(1, s.length() - 1);
    List<Integer> tuple = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean check = false;

    for (int i = 0; i < tmp.length(); i++) {

      char ch = tmp.charAt(i);

      if (ch == '{') {

        sb = new StringBuilder();
        tuple = new ArrayList<>();
        check = true;
      } else if (ch == '}') {

        check = false;
        tuple.add(Integer.valueOf(sb.toString()));
        tuples.add(tuple);
      } else if (0 <= ch - '0' && ch - '0' <= 9){

        sb.append(ch);
      } else if (ch == ',' && check){

        tuple.add(Integer.valueOf(sb.toString()));
        sb = new StringBuilder();
      }

    }
  }
}
