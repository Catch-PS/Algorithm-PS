package Study.Section02;
import java.util.*;
/*
    풀이 시간: 시간초과
    풀이 방법: 그래프와 Set을 이용해 해결
              Enum에 각 좌표의 이동거리를 정의
              시작점과 도착점을 Set에 넣고 중복되는 길은 제거하고, 최종 set의 size를 리턴

    시간 복잡도: O(N)
 */
public class programmers_방문길이_js {
    public static void main(String[] args) {
        System.out.println((solution("UDU")));
    }

    public static int solution(String dirs) {
        Graph graph = new Graph();
        for (char dir : dirs.toCharArray()) graph.move(dir);
        System.out.println(graph.distanceSet);
        return graph.distanceSet.size();
    }

    static class Graph {
        Point point;
        Set<Set<Point>> distanceSet;

        public Graph() {
            point = new Point(0,0);
            this.distanceSet = new HashSet<>();
        }

        public void move(char location) {
            Point start = new Point(this.point.x, this.point.y);
            this.point.x += Math.abs(this.point.x + Location.findByLocation(location).x) > 5 ? 0 : Location.findByLocation(location).x;
            this.point.y += Math.abs(this.point.y + Location.findByLocation(location).y) > 5 ? 0 : Location.findByLocation(location).y;
            Point end = new Point(this.point.x, this.point.y);
            Set<Point> historySet = new HashSet<>();
            historySet.add(start);
            historySet.add(end);
            if (!(start.x == end.x && start.y == end.y)) distanceSet.add(historySet);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    enum Location {
        U('U', 0,1),
        D('D',0,-1),
        R('R',1,0),
        L('L',-1,0);

        char name;
        int x;
        int y;

        Location(char name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        static Location findByLocation(char name) {
            return Arrays.stream(Location.values())
                    .filter(location -> location.name == name)
                    .findAny().orElseThrow();
        }
    }
}
