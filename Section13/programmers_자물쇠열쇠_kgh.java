package 스터디.스터디_SNU.Section13;

/*

(1) 문제풀이시간: 초과
(2) 컴퓨팅사고
1. 4가지 방향으로 90도 => 360도까지 회전이 가능하므로 네번까지 가능합니다.
2. 키를 90도 회전하고난 값들을 새로운 배열값에 저장합니다.
3. 그리고 새로운배열값에 있는것들을 다시 갱신시켜줍니다
4. 자물쇠를 만들때 큰 lock을 만들어서 전체 범위를 탐색할 수 있도록합니다.
즉, 4개의 key의 값을 모서리값이 겹치게 하나씩이동하면서 최소의 경우를 구해줍니다.
newlcok과 newkey의 값을 합쳐서 하나의 맵을 구해줍니다.
5. 가운데부분에서부터 시작해서 cnt값 즉 홈인경우에 정확히 일치하는지를 확인합니다.
6. cnt 값이 자물쇠의 길이 * 2와 같다는것은 모든값들이 맞다는것을 의미합니다. 즉, true를 리턴하면서 진행합니다.

0 = {int[7]@437} [0, 0, 0, 0, 0, 0, 0]
1 = {int[7]@444} [0, 0, 0, 0, 0, 0, 0]
2 = {int[7]@436} [0, 0, 1, 1, 1, 0, 0]
3 = {int[7]@440} [0, 0, 1, 1, 0, 0, 0]
4 = {int[7]@442} [0, 0, 1, 0, 1, 0, 0]
5 = {int[7]@445} [0, 0, 0, 0, 0, 0, 0]
6 = {int[7]@446} [0, 0, 0, 0, 0, 0, 0]

상하좌우 다음과같이 중앙부분에 LOCK을 두고 외곽부분에 Key를 처리합니다.

3. 시간복잡도
O(N^4)? 너무 브루트포스방식이라 최대의 복잡도가 발생할것을 예상



 */
public class programmers_자물쇠열쇠_kgh {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}},
                new int[][]{{1,1,1},{1,1,0},{1,0,1}}));
    }
    static boolean solution(int[][] key, int[][] lock) {
        int keySize = key.length;
        int lockSize = lock.length;

        // 4방향 rotate2
        for(int k=0; k<4; k++){
            int[][] newKey = new int[keySize][keySize];

            // 키 회전 90도
            for(int i=0; i<keySize; i++){
                for(int j=0; j<keySize; j++){
                    newKey[j][keySize-1-i] = key[i][j];
                }
            }
            // 키 업데이트
            for(int i=0; i<keySize; i++){
                for(int j=0; j<keySize; j++){
                    key[i][j] = newKey[i][j];
                }
            }
            // 자물쇠 맞추는 작업 진행
            for(int i=0; i<lockSize+keySize-1; i++){
                for(int j=0; j<lockSize+keySize-1; j++){
                    int[][] newLock = new int[(2*keySize-2)+lockSize][(2*keySize-2)+lockSize];
                    // 큰 자물쇠 초기화
                    for(int a = 0; a<lockSize; a++){
                        for(int b = 0; b<lockSize; b++){
                            newLock[a + keySize - 1] [b + keySize -1] = lock[a][b];
                        }
                    }
                    // newlock이랑 newkey합치기
                    for(int a=0; a<keySize; a++){
                        for(int b=0; b<keySize; b++){
                            newLock[a+i][b+j] += newKey[a][b];
                        }
                    }
                    // newlock의 가운데부분 확인하기, 체크하기
                    int cnt = 0;
                    for(int a=keySize-1; a<keySize+lockSize-1; a++){
                        for(int b=keySize-1; b<keySize+lockSize-1; b++){
                            if(newLock[a][b] == 1){
                                cnt++;
                            }
                        }
                    }
                    if(cnt ==lockSize*lockSize){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
