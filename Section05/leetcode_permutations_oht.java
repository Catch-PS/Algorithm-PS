package Section05;

import java.util.*;

/**
 * 풀이시간 : 40분
 * 풀이방식 : 정점에 비교 배열과 타겟 배열을 두고,
 * 비교 배열에 존재하는 엘리먼트를 위치할 수 있는 순서에 따라 타겟에 배열에 삽입하여 순열을 만들었습니다.
 * 시간 복잡도 : O(N!) 구하는 순열의 개수만큼 시간이 걸릴 것이라고 생각됩니다.
 */
public class leetcode_permutations_oht {

  public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> permutations = new ArrayList<>();
    dfs(permutations, nums);

    return permutations;
  }

  private void dfs(List<List<Integer>> permutations, int[] nums) {

    Stack<Vertex> stack = new Stack();
    LinkedList<Integer> cmpList = new LinkedList<>();
    LinkedList<Integer> targetList = new LinkedList<>();

    Arrays.stream(nums).forEach(cmpList::add);

    stack.push(new Vertex(cmpList, targetList));

    while (!stack.isEmpty()) {

      Vertex v = stack.pop();
      LinkedList<Integer> cmp = v.getCmp();
      LinkedList<Integer> target = v.getTarget();
      if (cmp.isEmpty()) {

        permutations.add(target);
        continue;
      }

      /*
      Vertex({1, 2, 3}, {})
      Vertex({2, 3}, {1})  Vertex({3, 1}, {2})  Vertex({1, 2}, {3})
      Vertex({3}, {1,2}) Vertex({2} {1,3}) Vertex({1}, {2,3}) Vertex({3} {2,1}) Vertex({2}, {3,1}) Vertex({1} {3,2})
      ...
       */
      for (int i=0; i<cmp.size(); i++) {

        int value = cmp.pollFirst();
        target.offerLast(value);
        stack.push(new Vertex(new LinkedList<>(cmp), new LinkedList<>(target)));
        cmp.offerLast(value);
        target.pollLast();
      }
    }
  }
}

class Vertex {

  LinkedList<Integer> cmp;

  LinkedList<Integer> target;

  public Vertex (LinkedList<Integer> cmp, LinkedList<Integer> target){

    this.cmp = cmp;
    this.target = target;
  }

  public LinkedList<Integer> getCmp() {

    return this.cmp;
  }

  public LinkedList<Integer> getTarget() {

    return this.target;
  }
}
