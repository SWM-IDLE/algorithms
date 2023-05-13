import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer> limits;
    static int M;
    static ArrayList<Integer> weights;
    static int available[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        limits = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            limits.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        Collections.sort(limits);

        available = new int[N];
        M = Integer.parseInt(bufferedReader.readLine());
        weights = new ArrayList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            weights.add(Integer.parseInt(stringTokenizer.nextToken()));
            for (int j = 0; j < N; j++) {
                if (limits.get(j) >= weights.get(i)) {
                    available[j] += 1;
                }
            }
        }

        if (available[N - 1] < M) {
            System.out.println(-1);
            return;
        }
        
        for (int i = N - 1; i > 0; i--) {
            available[i] -= available[i - 1];
        }

        int time = 0;
        while (!isEnd()) {

            time += 1;
            for (int i = N - 1; i >= 0; i--) {
                if (available[i] == 0) {
                    int maxIndex = getMaxIndex(i);
                    if (maxIndex == -1) {
                        continue;
                    } else {
                        available[maxIndex] -= 1;
                    }
                } else {
                    available[i] -= 1;
                }
            }
        }

        System.out.println(time);

    }

    static boolean isEnd() {
        for (int i = 0; i < N; i++) {
            if (available[i] != 0) {
                return false;
            }
        }
        return true;
    }

    static int getMaxIndex(int until) {
        for (int i = until - 1; i >= 0; i--) {
            if (available[i] > 0) {
                return i;
            }
        }
        return -1;
    }

}
