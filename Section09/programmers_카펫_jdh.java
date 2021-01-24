/*
    풀이 시간: 10분
    예상 시간복잡도: O(n)
    풀이 방법: 세로의 길이를 임의로 정하고 가의 길이를 구합니다. 이렇게 정했을 때 안에 공간을 구합니다.
            구한 공간이 yellow의 수와 일치한다면 바로 answer에 답을 담고 탐색을 종료합니다.
            맞지 않는 경우 계속해서 세로의 길이를 하나씩 늘려가며 안의 공간을 구합니다.
 */

public class programmers_카펫_jdh {
    public static int[] solution(int brown, int yellow) {
        int answer[] = new int[2];

        // 세로의 길이는 최소 3부터 시작(가운 데에 하나의 yellow만 있어도 위 아래를 감싸야해서)
        // brown의 세로의 최대 길잉는 brown을 2로 나눴을 때로 가정, 세로의 길이가 가로의 길이보다 클 수 없으므로)
        for(int i = 3; i <= brown / 2; i++){
            int ver = (brown - (i * 2)) / 2; // 양 끝의 세로 블록 수를 빼고 남은 brown의 수의 / 2는 한 줄의 세로 블록 수
            int area = (i - 2) * ver; // 안의 yellow 공간은 세로 길이를 나타내는 i에서 2줄을 뺀 후 위에서 구한 세로 블록 수의

            if(area == yellow) {곱
                answer[0] = ver + 2;
                answer[1] = i;
                break;
             }
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(10, 2)));
    }
}
