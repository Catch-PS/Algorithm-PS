package 스터디.스터디_SNU.Section14;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 문제 풀이 시간: 초과 (그리디 알고리즘)
 * 2. 컴퓨팅 사고
 * (1)LastIdx[알파벳을 아스키코드로 표현된 값] = 현재 위치의 값을 구해줍니다.
 * 예) 'c' 일 경우 LastIdx['c'-'a'=2] = 현재 위치(i)
 * (2) S문자열을 모두 수행하면서 나오는 알파벳들의 위치와 비교하여 최대로 위치해있는 인덱스값을 구해줍니다.
 * (3) 만약 S문자열값을 모두 수행하면서 진행되는값이 S문자열에 최대로 위치해있는 인덱스값과 같을 경우
 * 파티셔닝 포인터를 현재 진행되는값+1로 갱신해줍니다. 이것이 뜻하는 바는 하나의 파티션이 생성되어 다음 파티션의 첫번째 인덱스값으로 초기화 시켜주는것을 뜻합니다.
 * 그리고, 현재까지 진행된 i번째 위치에서 - 파티션된 위치 + 1 을 처리합니다. 이렇게 처리하면 현재까지 하나의 파티션의 길이값을 구할 수 있습니다.
 * 즉, (최대로 진행된 위치 - 시작된 위치) + 1를 뜻합니다.
 * (4) 2,3번을 차례대로 진행하면 해당되는 최대길이의 파티션을 나눌 수 있게됩니다.
 *
 * 3. 시간복잡도
 * O(N)
 */
/* lastIdx 값
0 = 8
1 = 5
2 = 7
3 = 14
4 = 15
5 = 11
6 = 13
7 = 19
8 = 22
9 = 23
10 = 20
11 = 21
12 = 0
13 = 0
14 = 0
15 = 0
16 = 0
17 = 0
18 = 0
19 = 0
20 = 0
21 = 0
22 = 0
23 = 0
24 = 0
25 = 0
 */
public class leetcode_PartitionLabels_kgh {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
    static List<Integer> partitionLabels(String S) {
        int[] lastIdx = new int[26];
        // 문자의 마지막인덱스에 해당하는값을 구해줍니다. 소문자의 갯수는 26개이므로 알파벳의 위치가 idx가 되고, 값이 몇번째 인덱스의 값인지를 넣어줍니다.
        // lastIdx[a-z 알파벳의 인덱스] = 몇번째 위치에 해당되는지
        for (int i = 0; i < S.length(); i++) {
            lastIdx[S.charAt(i) - 'a'] = i;
        }
        int maxIdx = 0;
        int partitionPoint = 0;
        List<Integer> arrList = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            maxIdx = Math.max(maxIdx, lastIdx[S.charAt(i) - 'a']);
            // i가 파티션의 끝에 있는 경우 해당 i 인덱스의 값에서 파티셔닝 시작값을 빼주면 해당되는 길이가 리턴됩니다. +1을 해주는 이유는 인덱스가 0부터 시작하기 때문입니다.
            if (i == maxIdx) {
                // 최대 위치 - 시작 위치 + 1
                arrList.add(i-partitionPoint+1);
                // 하나의 파티션이 생성되었으므로 파티션 포인터값을 그 다음 파티션의 첫번째값으로 갱신합니다.
                partitionPoint = i + 1;
            }
        }
        return arrList;
    }
}
