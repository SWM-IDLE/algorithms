import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] scores;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        scores = new int[N+1];
        for(int i=1; i<=N; i++) {
            scores[i] = Integer.parseInt(bufferedReader.readLine());
        }

        if(N == 1) {
            System.out.println(scores[1]);
            return;
        }

        dp = new int[N+1][2];

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = scores[1];
        dp[1][1] = scores[1];
        dp[2][1] = scores[2];

        System.out.println(Math.max(getDp(N, 0), getDp(N, 1)));

    }

    static int getDp(int n, int gap) {
        if(dp[n][gap] != 0) {
            return dp[n][gap];
        }

        if(gap == 0) {
            return dp[n][gap] = getDp(n-1, 1) + scores[n];
        }
        return dp[n][gap] = Math.max(getDp(n-2, 0), getDp(n-2, 1)) + scores[n];

    }
}
