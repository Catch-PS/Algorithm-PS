/*
    풀이 시간: 30분
    예상 시간복잡도: O(n)
    풀이 방법: 이동하는 경로를 HashSet에 넣어서 중복을 제거, 객체를 hashSet에 넣었을 때 객체의 주소값이 다르기 때문에 같은 경로여도
                다른 객체로 인식해서 제대로 제거가 되지 않기 때문에 equals와 hashcode 함수를 재정의
 */

public class programmers_방문길이_jdh {

    public static class Loc {
        int startX, startY, endX, endY;

        public Loc(int startX, int startY, int endX, int endY){
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        @Override
        public boolean equals(Object o) {
            Loc loc = (Loc) o;
            return (this.startX == loc.startX && this.startY == loc.startY && this.endX == loc.endX && this.endY == loc.endY)
                    || (this.startX == loc.endX && this.startY == loc.endY && this.endX == loc.startX && this.endY == loc.startY);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    public static int solution(String dirs) {
        HashSet<Loc> visitedList = new HashSet<>();
        int curX = 0;
        int curY = 0;

        for(int i = 0; i < dirs.length(); i++){
            char dir = dirs.charAt(i);

            if(dir == 'U' && checkRange(curX - 1, curY)){
                visitedList.add(new Loc(curX, curY, --curX, curY));
            }
            else if(dir == 'D' && checkRange(curX + 1, curY)){
                visitedList.add(new Loc(curX, curY, ++curX, curY));
            }
            else if(dir == 'L' && checkRange(curX, curY - 1)){
                visitedList.add(new Loc(curX, curY, curX, --curY));
            }
            else if(dir == 'R' && checkRange(curX, curY + 1)){
                visitedList.add(new Loc(curX, curY, curX, ++curY));
            }
        }

        return visitedList.size();
    }

    public static boolean checkRange(int curX, int curY){
        return curX >= -5 && curX <= 5 && curY >= -5 && curY <= 5;
    }

    public static void main(String args[]){
        System.out.println(solution("ULURRDLLU"));
    }
}
