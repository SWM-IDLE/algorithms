import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        dp = new long[N+1][2];

        System.out.println(getDp(N , 0) + getDp(N, 1));

    }

    /*
    dp[n][0] : 길이가 n 이면서 맨 끝이 0으로 끝나는 이친수의 개수
    dp[n][1] : 길이가 n 이면서 맨 끝이 1로 끝나는 이친수의 개수

    1. 끝이 0으로 끝나는 이친수는 뒤에 0 또는 1을 붙여서 길이가 1 늘어난 이친수를 만들 수 있음
        dp[n][0] = dp[n-1][0] + dp[n-1][1]
    2. 끝이 1로 끝나는 이친수는 뒤에 1을 붙일 수 없기 때문에 0만 붙여서 길이가 1 늘어난 이친수를 만들 수 있음
        dp[n][1] = dp[n-1][0]

    길이가 n인 이친수의 수는 dp[n][0] + dp[n][1]

     */

    static long getDp(int n, int type) {
        if(dp[n][type] != 0) {
            return dp[n][type];
        }

        if(n == 1) {
            return dp[n][type] = type;
        }

        if(type == 0) {
            return dp[n][type] = getDp(n-1, 0) + getDp(n-1, 1);
        }
        return dp[n][type] = getDp(n-1, 0);
    }

}
