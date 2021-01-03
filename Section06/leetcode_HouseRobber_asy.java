/*
 * 1. 풀이시간 : 50분
 * 2. 풀이방법 : 연속된 집을 털면 경찰이 알게 되니까 짝수 인덱스와 홀수 인덱스 이렇게 나눠서 최대값을 구했음.
                그런데 이렇게 되면 무조건 한칸씩 뛰어넘어서 더했을 때보다, 두칸씩 뛰어넘어서 더했을 때 더 큰값이 나오기도 함.
                따라서 홀수 인덱스, 짝수 인덱스 이렇게 나눠서 더하되
                홀수 인덱스를 더한 값보다 짝수 인덱스틀 더한 값이 더 크다면 홀수 인덱스끼리 더한 값에 짝수 인덱스끼리 더한 값을 넣습니다.
                즉, 홀수 인덱스끼리 더하든, 짝수 인덱스끼리 더하든 누적 최대값을 유지시키면서 비교하는 방법을 사용했습니다.
 * 3. 예상 시간복잡도 : O(n)
 */
class Solution {
    public int rob(int[] num) {
        int sumEven = 0;
        int sumOdd = 0;
        
        for(int i=0; i<num.length; i++){
            //짝수 인덱스일 경우
            if(i%2 == 0){
                sumEven = Math.max(sumEven + num[i], sumOdd);
            }
            //홀수 인덱스일 경우
            else{
                sumOdd = Math.max(sumOdd + num[i], sumEven);
            }
        }
        
	    return Math.max(sumEven, sumOdd);
    }
}