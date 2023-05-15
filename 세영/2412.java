import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int T;
    static ArrayList<Point> points;
    static ArrayList<ArrayList<Integer>> graph;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        points = new ArrayList<>();
        points.add(new Point(0, 0));

        boolean flag = true;
        for(int i=1; i<=N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            points.add(new Point(x, y));
            if(y == T) {
                flag = false;
            }
        }

        if(flag) {
            System.out.println(-1);
            return;
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) { // x, y 좌표 오름차순으로 정렬
                if(o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });


        for(int i=0; i<=N; i++) {
            Point now = points.get(i);
            for(int j=i+1; j<=N; j++) {
                Point next = points.get(j);
                if(Math.abs(next.x - now.x) <= 2 && Math.abs(next.y - now.y) <= 2) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
                else if(Math.abs(next.x - now.x) > 2 && Math.abs(next.y - now.y) > 2) {
                    break;
                }
            }
        }

        min = Integer.MAX_VALUE;
        bfs();
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);

    }

    static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        int[] visited = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = 1;
        queue.offer(0);

        while(!queue.isEmpty()) {
            int nowIndex = queue.poll();
            Point now = points.get(nowIndex);

            if(now.y == T) {
                min = visited[nowIndex] - 1;
                break;
            }

            for(int nextIndex : graph.get(nowIndex)) {
                if(visited[nextIndex] != 0) {
                    continue;
                }
                visited[nextIndex] = visited[nowIndex] + 1;
                queue.offer(nextIndex);
            }
        }
    }


}
