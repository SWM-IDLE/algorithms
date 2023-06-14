import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;
    static List<Integer[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        edges = new ArrayList<>();
        long totalCost = 0;
        for(int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            edges.add(new Integer[] {a, b, c});
            totalCost += c;
        }

        Collections.sort(edges, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[2] - o2[2];
            }
        });

        parents = new int[N+1];
        for(int i=1; i<=N; i++) {
            parents[i] = i;
        }

        long minCost = 0;
        int edgeCount = 0;
        for(Integer[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];

            if(find(a) != find(b)) {
                union(a, b);
                minCost += c;
                edgeCount += 1;
                if(edgeCount == N-1) {
                    break;
                }
            }
        }

        if(edgeCount < N-1) {
            System.out.println(-1);
            return;
        }
        System.out.println(totalCost - minCost);


    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a <= b) {
            parents[b] = a;
            return;
        }
        parents[a] = b;
    }

    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}
