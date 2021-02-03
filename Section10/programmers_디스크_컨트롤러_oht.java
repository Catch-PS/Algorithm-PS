package Section10;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 풀이시간 : 초과
 *
 * 풀이 방식 :
 * 1. 입력된 작업들을 입력시간 순서로 정렬합니다.
 * 2. 반복문을 돌면서 현재 작업의 종료시간과 다음 작업의 입력 시간을 비교하고,
 * 종료 시간보다 작으면 pq 대기열에 삽입합니다.
 * 3. 현재 작업이 종료된 상태에서 jpq가 비었다면 현재 작업의 InputTime 을 endTime 으로 조정합니다.
 * 4. 대기열에 값이 한다면 제일 우선하는 작업을 수행하도록 합니다.
 * (우선 순위는 runTime 이 작은 순서로 Comparator 를 조정했습니다.)
 * 
 * 5. 평균값을 도출합니다.
 * 
 * 시간 복잡도 : 
 */
public class programmers_디스크_컨트롤러_oht {
  public int solution(int[][] jobs) {

    //input 된 배열을 입력 시간 순서로 정렬합니다.
    Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

    //처리 시간의 오름차순으로 정렬되는 우선순위 큐
    PriorityQueue<int[]> jpq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

    int sum = 0; //요청 대기 시간 + 처리시간의 합
    int endTime = 0; //현재 작업의 종료시간
    int id = 0; // 현재 입력된 job 의 id
    int cnt = 0; // 처리된 job 의 개수

    while (cnt < jobs.length) {

      //현재 입력된 job 이 전체 작업 범위 내에 존재해야 하고,
      // 현재 입력된 job 의 입력 시간이 현재 작업이 종료되기 전이면 pq에 job 을 넣고, 다음 입력을 받습니다.
      while (id < jobs.length && jobs[id][0] <= endTime) {

        jpq.add(jobs[id++]);
      }

      //jpq 가 비었다면 현재 입력된 작업의 inputTime 을 endTime 으로 설정합니다.
      //시작 시간이 endTime 보다 길 경우를 대비해서 해당 작업을 수행. 예를 들어 현재 종료시간이 18시간 경과 후인데
      //새로운 Input 시작 시간이 30시간 경과 후라면 종료 시간을 30시간 경과 후로 맞춰주고, 작업을 지속해야 합니다.
      //runTime 을 수행하는 작업은 위 반복문에서 설정됩니다.
      if (jpq.isEmpty()) {

        endTime = jobs[id][0];
      } else {
        //jpq 에 작업이 존재하면 우선순위 큐에서 대기 중인 job 을 꺼냅니다.
        int[] job = jpq.poll();

        //endTime 에 가져온 job 의 runTime 을 더합니다.
        endTime += job[1];

        //요청 대기 시간 + 처리시간을 최종 결과에 더합니다.
        sum += endTime - job[0];
        cnt++; //작업 하나가 처리되었으므로 카운트가 증가합니다.
      }

    }

    return sum / jobs.length;
  }
}
