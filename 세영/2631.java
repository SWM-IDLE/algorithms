import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] numbers;
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        lis = new int[N + 1];
        System.out.println(N - getLis());
    }

    static int getLis() {
        int max = -1;
        for (int i = 1; i <= N; i++) {
            int num = numbers[i];
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < num) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            max = Math.max(max, lis[i]);
        }

        return max;
    }

}
