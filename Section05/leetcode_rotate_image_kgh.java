package 스터디.스터디_SNU.Section05;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 문제풀이 시간: 5분
 * 2. 컴퓨팅 사고
 * 예를 들어, 회전시킬 경우
 * 1(0,0) 2(0,1) 3(0,2) -> 회전시 (0, matrix.length), (1, matrix.length), (2, matrix.length)
 * 이것을 for문으로 규칙을 세우면 rotate_answer[j][(matrix.length-1)-i] = matrix[i][j] 다음과 같은 식으로 치환할 수 있습니다.
 *
 * 3. 시간복잡도
 * O(matrix * matrix) -> O(matrix^2)
 */
public class leetcode_rotate_image_kgh {
    static int[][] rotate_answer;
    static List<List<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) {
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    static void rotate(int[][] matrix) {
        rotate_answer = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                rotate_answer[j][(matrix.length-1)-i] = matrix[i][j];
            }
        }

        for(int i=0; i<rotate_answer.length; i++){
            for(int j=0; j<rotate_answer[i].length; j++){
                arr.get(i).add(rotate_answer[i][j]);
            }
        }

        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.get(i).size(); j++){
                System.out.print(arr.get(i).get(j));
            }
            System.out.println();
        }
        /*
         정답을 위한 코드
         for(int i=0; i<rotate_answer.length; i++){
            for(int j=0; j<rotate_answer[i].length; j++){
                matrix[i][j] = rotate_answer[i][j];
            }
         }
        */
    }
}

class Solution {
    static int[][] rotate_answer;
    static List<List<Integer>> arr = new ArrayList<>();
    static List<List<Integer>> rotate(int[][] matrix) {
        rotate_answer = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                rotate_answer[j][(matrix.length-1)-i] = matrix[i][j];
            }
        }
        for(int i=0; i<rotate_answer.length; i++){
            for(int j=0; j<rotate_answer[i].length; j++){
                arr.get(i).add(rotate_answer[i][j]);
            }
        }
         for(int i=0; i<arr.size(); i++){
             for(int j=0; j<arr.get(i).size(); j++){
                 System.out.print(arr.get(i).get(j));
             }
             System.out.println();
         }
        return arr;
    }
}