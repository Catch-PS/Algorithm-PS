package Study;

/*
문제 접근법
 */
public class programmers_멀쩡한사각형_kgh {
    public static void main(String[] args) {
        System.out.print(solution(8,12));
    }
    static int gcd(int w,int h){
        if(h == 0){
            return w;
        }
        return gcd(h, w % h);
    }
    static long solution(int w, int h) {
        int gcd_num = gcd(w,h);
        long squreArea = (long)w * (long)h;
        long answer = (squreArea - ((long)w + (long )h)) + gcd_num;

        return answer;
    }
}
