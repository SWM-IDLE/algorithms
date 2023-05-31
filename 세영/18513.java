import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static Queue<Integer> queue;
    static HashSet<Integer> set;
    static int dist;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        queue = new LinkedList<>();
        set = new HashSet<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++) {
            int sam = Integer.parseInt(stringTokenizer.nextToken());
            queue.offer(sam);
            set.add(sam);
        }

        dist = 1;
        cnt = 0;
        runBfs();
        System.out.println(cnt);

    }

    static void runBfs() {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int now = queue.poll();
                int left = now-1;
                int right = now+1;

                if(!set.contains(left)) {
                    cnt += dist;
                    set.add(left);
                    queue.offer(left);
                    K -= 1;

                    if(K == 0) {
                        return;
                    }
                }

                if(!set.contains(right)) {
                    cnt += dist;
                    set.add(right);
                    queue.offer(right);
                    K -= 1;

                    if(K == 0) {
                        return;
                    }
                }
            }

            dist += 1;
        }
    }

}
