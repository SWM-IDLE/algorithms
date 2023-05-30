import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static int farNode;
    static int max;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList<>();
        for(int i = 0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<N-1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        distance = new int[N+1];
        distance[1] = 1;
        max = -1;
        farNode = 0;
        getFarNode(1);
        int farNode1 = farNode;

        distance = new int[N+1];
        distance[farNode1] = 1;
        max = -1;
        farNode = 0;
        getFarNode(farNode1);

        max -= 1;
        int maxDistance = (max%2 == 0) ? max/2 : max/2 + 1;
        System.out.println(maxDistance);
    }

    static void getFarNode(int x) {
        for(int connected : graph.get(x)) {
            if(distance[connected] == 0) {
                distance[connected] = distance[x] + 1;
                if(max < distance[connected]) {
                    max = distance[connected];
                    farNode = connected;
                }
                getFarNode(connected);
            }
        }
    }

}
