package 스터디.스터디_SNU.Section12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 문제풀이시간: 50분
 * 이진트리 오랜만에 복습
 * 2. 컴퓨팅사고
 * (1) 이진트리를 생성하기 위한 Node클래스 선언후 y값이 상위에 있는 루트노드부터 진행하기 위하여 sort
 * (2) 루트노드(y값이 상위)인값을 가져와서 insertNode()함수를 호출하여 이진트리를 구성합니다.
 * (3) 부모보다 x값이 더 큰것이 오른쪽 노드이고, 작은것이 왼쪽노드인것을 파악해서 분기문을 처리하였습니다. null이면 자식노드 생성, 아니면 재귀호출로 계속해서 이진트리 구성
 * (4) 전위,후위 이진트리 순회방식을 사용 (전위: root left right, 후위: left right root)
 * (5) 전위 후위 리스트 두개를 사용하여 정답 리턴
 *
 */
public class programmers_길찾기게임_kgh {
    static List<Node> nodeList = new ArrayList<>();
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();
    public static void main(String[] args) {
        solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
    }
    static List<List<Integer>> solution(int[][] nodeinfo) {
        // 노드값을 초기화(x,y,level)
        for(int i=0; i<nodeinfo.length; i++){
            nodeList.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        Collections.sort(nodeList);

        Node root = nodeList.get(0);

        // 이진트리 생성
        for(int i=1; i<nodeList.size(); i++){
            Node child = nodeList.get(i);
            insertNode(root, child);
        }
        preOrder(root);
        postOrder(root);
        for (Integer integer : preOrderList) {
            System.out.print(integer + " ");
        }
        for (Integer integer : postOrderList) {
            System.out.print(integer + " ");
        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(preOrderList);
        answer.add(postOrderList);
        return answer;
    }

    // 후위 순회
    private static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        postOrderList.add(node.data);

    }
    // 전위 순회
    private static void preOrder(Node node) {
        preOrderList.add(node.data);
        if(node.left != null){
            preOrder(node.left);
        }
        if(node.right != null){
            preOrder(node.right);
        }

    }

    // 이진트리 구
    private static void insertNode(Node parent, Node child) {
        // right
        if(parent.x < child.x){
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
        // left
        else {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        }
    }
    static class Node implements Comparable<Node>{
        Node left = null;
        Node right = null;
        int x;
        int y;
        int data;
        public Node(int x, int y, int data) {
            this.x = x;
            this.y = y;
            this.data = data;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.y,this.y);
        }
    }
}
