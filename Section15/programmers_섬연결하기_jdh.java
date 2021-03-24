/*
    풀이 시간: 18분
    예상 시간복잡도: for...n ....보다 크겠죠?
    풀이 방법: n개의 정점이 있고 경유를 하더라도 갈 수만 있으면 되기 때문에 최소 신장 비용 트리로 접근하게 되었습니다.
            그래서 크루스칼 알고리즘으로 해결했고 이미 주어지는 배열 자체가 각 정점의 관계와 가중치를 가지고 있어 따로 자료를 변환하지 않았습니다.
            가중치를 중심으로 정렬을 수행한 후 정점을 하나씩 이어가는데 이때 union-find 알고리즘을 이용해서 해결했습니다.
 */
public class programmers_섬연결하기_jdh {
    public static int parents[];

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int V = n;
        parents = new int[V];

        Arrays.sort(costs, new Comparator<int []>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        Arrays.fill(parents, -1);

        int cnt = 0;
        for(int i = 0; i < costs.length; i++){
            if(cnt == V - 1) break;

            if(union(costs[i][0], costs[i][1])){
                answer += costs[i][2];
                cnt++;
            }
        }

        return answer;
    }

    public static int find(int x){
        if(parents[x] < 0) return x;
        return parents[x] = find(parents[x]);
    }

    public static boolean union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot != yRoot){
            parents[yRoot] = xRoot;
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        int costs[][] = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4, costs));
    }
}
