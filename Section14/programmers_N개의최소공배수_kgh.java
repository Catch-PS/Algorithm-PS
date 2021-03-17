package 스터디.스터디_SNU.Section14;

/**
 * 1.문제풀이시간:10분
 * 2.컴퓨팅사고
 * (1) GCD 최대공약수를 구한후에 g * (a/g) * (b/g) 의 공식을 이용하여 LCM 최소공배수 값을 구해줍니다.
 * (2) 값들을 하나씩 계속 비교해 나가면서 해당되는 최소공배수를 갱신하면서 최소공배수값을 기준으로 해서 최댓값을 구해줍니다.
 * 즉, LCM을 구해주면서 최종적으로 answer에는 결과값이 담기게 됩니다.
 * 예)
 * GCD
 * 12 8
 * 8 4
 * 4 0
 */
public class programmers_N개의최소공배수_kgh {
    public static void main(String[] args) {
        solution(new int[]{2,6,8,14});
    }
    static int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1; i<arr.length; i++){
            int gcdNumber = gcd(arr[i], answer);
            answer = Math.max(answer,gcdNumber * (arr[i] / gcdNumber) *(answer / gcdNumber));
        }
        System.out.println(answer);
        return answer;
    }
    // GCD
    static int gcd(int w,int h){
        if(h==0){
            return w;
        }
        return gcd(h, w % h);
    }
}
