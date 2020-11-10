public class FineSquare {
    public static void main(String[] args) {
        System.out.println(solution(8,12));
    }
    public static long solution(int w, int h) {
        long answer = 0;
        for (int x=0; x<w; x++) {
            long y = ((long) h * x) / (long) w;
            answer+=y;
        }
        return answer*2;
    }
}