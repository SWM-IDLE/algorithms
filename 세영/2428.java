import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] sizes;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        sizes = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            sizes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(sizes);

        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int index = getIndex(i);
            cnt += index - i - 1;
        }
        System.out.println(cnt);
    }

    static int getIndex(int startIndex) {
        int l = startIndex;
        int r = N - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            // System.out.println(l + " ~ " + r + " : " + mid );
            if ((sizes[mid] * 0.9) <= sizes[startIndex]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

}
