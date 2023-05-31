import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<HashMap<Integer, Integer>> graph;
    static int[] distance;
    static int S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new HashMap<>());
        }

        for(int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if(graph.get(a).containsKey(b)) { // a-b 간선이 있는 경우 c가 더 작을 때만 추가
                graph.get(a).put(b, Math.min(graph.get(a).get(b), c));
                graph.get(b).put(a, Math.min(graph.get(b).get(a), c));
                continue;
            }

            graph.get(a).put(b, c);
            graph.get(b).put(a, c);
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        S = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(dijkstra());

    }

    static int dijkstra() {
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Integer[]> queue = new LinkedList<>();

        queue.offer(new Integer[] {S, 0});
        distance[S] = 0;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for(Integer key : graph.get(now[0]).keySet()) {
                Integer weight = graph.get(now[0]).get(key);
                if(distance[key] > distance[now[0]] + weight){
                    distance[key] = distance[now[0]] + weight;
                    queue.offer(new Integer[] {key, weight});
                }
            }
        }

        return distance[T];
    }

}
