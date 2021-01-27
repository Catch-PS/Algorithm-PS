/*
 * 1. 풀이시간 : 시간 초과
 * 2. 풀이방법
 * grid의 각 위치에서 가질 수 있는 가장 작은 값을 구하는 식을 세움
 * 가로, 세로의 가장자리는 올 수 있는 위치가 정해져 있으므로 경우를 나눠서 생각해줌
 * 가로 가장자리 :  시작 -> -> -> ->
 * 세로 가장자리 :   ㅣ
                    ㅣ
                    ㅣ
                    ㅣ
 * 3. 예상 시간복잡도 : O(n^2)
 */
class Solution {
    public int minPathSum(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i==0 && j==0){   //시작위치이면 다시 인덱스 재탐색
                    continue;
                } else if(i==0){    //세로 가장자리 부분은 위에서 오는 값을 더해야 함
                    grid[i][j] += grid[i][j-1];
                } else if(j==0){    //가로 가장자리 부분은 왼쪽에서 오는 값을 더해야 함
                    grid[i][j] += grid[i-1][j];
                } else {            //가장자리 쪽이 아닌 부분은 올 수 있는 값 중 작은 것을 더해줌
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}