import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] num;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        num = new int[N + 1];
        stringBuilder = new StringBuilder();
        dfs(0);

        System.out.println(stringBuilder.toString());
    }

    static void dfs(int depth) {
        if (stringBuilder.toString().length() != 0) {
            return;
        }

        if (!isGood(depth + 1)) {
            return;
        }
        if (depth == N) {
            for (int i = 1; i <= N; i++) {
                stringBuilder.append(num[i]);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (num[depth] != i) {
                num[depth + 1] = i;
                dfs(depth + 1);
                num[depth + 1] = 0; // 백트래킹
            }
        }

    }

    static boolean isGood(int len) {
        for (int size = 1; size <= len / 2; size++) {
            for (int i = 1; i <= (len - 2 * size); i++) {
                StringBuilder str1 = new StringBuilder();
                StringBuilder str2 = new StringBuilder();
                for (int j = i; j < i + size; j++) {
                    str1.append(num[j]);
                    str2.append(num[j + size]);
                }
                if (str1.toString().equals(str2.toString())) {
                    return false;
                }
            }
        }
        return true;
    }

}
