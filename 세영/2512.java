import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] requests;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        requests = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++) {
            requests[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        M = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(requests);

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int l = 0;
        int r = requests[requests.length-1];

        if(isEnough(r)) {
            return r;
        }

        while(l < r) {
            int mid = (l + r + 1) / 2;
            // System.out.println(l + " ~ " + r + " : " + mid);
            if(isEnough(mid)) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }

        return l;
    }

    static boolean isEnough(int mid) {
        int total = 0;
        for(int i=0; i<N; i++) {
            total += Math.min(requests[i], mid);
        }
        if(total <= M){
            return true;
        }
        return false;
    }
}
