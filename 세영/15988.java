import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int[] dp;
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        dp = new int[1000001];
        while(T-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(getDp(n)).append('\n');
        }

        System.out.println(stringBuilder.toString());

    }

    static int getDp(int x) {
        if(dp[x] != 0) {
            return dp[x];
        }

        if(x == 1) {
            return dp[x] = 1;
        }
        if(x == 2) {
            return dp[x] = 2;
        }
        if(x == 3) {
            return dp[x] = 4;
        }

        return dp[x] = ((getDp(x-1) + getDp(x-2)) % MOD + getDp(x-3)) % MOD;
    }

}
