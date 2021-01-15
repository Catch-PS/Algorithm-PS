package 스터디.스터디_SNU.Section08;
import java.util.*;

/**
 * 🔥Amazon CodingInterview🔥
 * 1.풀이시간: 초과
 * 2.컴퓨팅사고
 * (1) 하나의 배열을 만들어서 인덱스값에는 해당 알파벳의 숫자(a일 경우 0, b일경우 1 ...)를 담고 배열의 값에는 인덱스를 담습니다.
 * (2)해당 알파벳이 위치해있는 값을 계속 갱신하여 마지막인덱스를 찾아줍니다.
 * (3) start,end 포인트점을 하나두어 처음시작값부터 가장 마지막 인덱스에 있는 값을 갱신하여 end에 업데이트 해줍니다.

 예시) ababcbacadefegdehijhklij
 각 문자별 가지고 있는 배열의 값이 주어졌다고 할때 다음과 같이 배열에 담겨있는것을 확인할 수 있습니다.
 ababcbaca defegde hijhklij
 ---------------------------------------------------------------------------------
 a = [0] = 8, b = [1] = 5, c = [2] = 7, d = [3] = 14, e = [4] = 15, f = [5] = 11, g = [6] = 13
 h = [7] = 19, i = [8] = 22, j = [9] = 23, k = [10] = 20, l = [11] = 21
 ---------------------------------------------------------------------------------
 a,b 비교 => 8,5 => max = 8
 max,c 비교 => 8,7 => max = 8 .....
 ----------------------------------------------------------------------------------
 a부터 진행하면서 Math.max() end인덱스 값을 갱신하면서 어디지점까지 파티션을 나눌 것인지를 확인합니다.
 다음과 진행하면서 end값이 문자의 개수 i까지 정확히 도달하였다는것은 파티션으로 나눌 수 있는 의미가 됩니다.
 해당 조건에서 파티션의 개수 (end-start+1)를 넣어주고, start의 범위를 end+1 다음파티션 시작점으로 옮겨줍니다.
 계속해서 값들을 갱신해나가면서 구해준다면 최종적으로 answer 리스트에는 값들이 모두 담겨있게 될 것입니다.

 3.시간복잡도
 O(S), S^3일 경우 1억2천 정도이므로 O(S^3) 미만까지 가능
 */

public class leetcode_Partition_Labels_kgh {
    public static void main(String[] args) {
            partitionLabels("ababcbacadefegdehijhklij");
    }
    static List<Integer> partitionLabels(String S) {
        List<Integer> answer = new ArrayList<>();

        // 알파벳 개수만큼 할당. a-z
        int[] lastIdx = new int[26];
        for(int i=0; i<S.length(); i++){
            lastIdx[S.charAt(i)-'a'] = i;           // 숫자로 변경
        }
        int start = 0;
        int end = 0;

        // 모든 문자에 대해서 확인
        for(int i=0; i<S.length(); i++){
            // 처음부터 시작하는 모든문자의 마지막 인덱스값의 최댓값을 끝지점으로 설정
           end = Math.max(end, lastIdx[S.charAt(i)-'a']);
           // 제대로 값이 도달하였으면(그 하위문자들이 모두 포함되는 경우)
           if(i == end){
               answer.add(end-start+1);
               System.out.println(end-start+1);
               // 다음 파티션을 처리
               start = end+1;
           }
        }
        return answer;
    }
}

// 4 , 3, 2 => 9
// 2, 3 , 1 ,1 => 7
// 2,2,2,1,1 => 8