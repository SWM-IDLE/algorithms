import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while(N != 0) {
            dp = new long[N+1][N+1];

            stringBuilder.append(getDp(N, 0)).append('\n');
            N = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(stringBuilder.toString());

    }

    static long getDp(int w, int h) {
        if(dp[w][h] != 0) {
            return dp[w][h];
        }

        if(w == 0) { // 남은게 전부 반쪽짜리 알약이면 경우의 수는 1
            return dp[w][h] = 1;
        }
        if(h == 0) { // 반쪽짜리 알약이 없다면 반쪽짜리 알약을 먹는 경우의 수는 제외
            return dp[w][h] = getDp(w-1, h+1);
        }
        // 그게 아니라면 통 알약을 먹는 경우의 수 + 반쪽짜리 알약을 먹는 경우의 수의 합
        return dp[w][h] = getDp(w-1, h+1) + getDp(w, h-1);
    }

}
