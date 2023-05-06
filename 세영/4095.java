import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[][] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while(true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());
            if(N == 0 && M == 0) {
                break;
            }

            arr = new int[N+1][M+1];
            sums = new int[N+1][M+1];
            for(int i=1; i<=N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=1; j<=M; j++) {
                    arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + arr[i][j];
                }
            }

            stringBuilder.append(getAnswer()).append('\n');
        }
        System.out.println(stringBuilder.toString());
    }

    static int getAnswer() {
        int maxK = -1;
        int K = -1;
        while(K++ < N) {

            for(int i=1; i< N - K + 1; i++) {
                for(int j=1; j< M - K + 1; j++) {
                    // (i,j) ~ (i+K, j+K) 배열의 누적합
                    int sumK = sums[i+K][j+K] - sums[i-1][j+K] - sums[i+K][j-1] + sums[i-1][j-1];
                    // System.out.println("[" + K + "]" + i + " , " + j + " ~ " + (i+K) + " , " + (j+K) + " > " + sumK);
                    if(sumK == (K+1) * (K+1)) {
                        maxK = Math.max(maxK, K+1);
                    }
                }
            }
        }

        if(maxK == -1) {
            return 0;
        }
        return maxK;
    }

}
