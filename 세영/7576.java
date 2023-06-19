import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] tomatos;
    static Queue<Integer[]> queue;
    static int[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        tomatos = new int[N][M];

        boolean isDone = true;
        visited = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                tomatos[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (tomatos[i][j] == 1) {
                    queue.offer(new Integer[]{i, j});
                    visited[i][j] = 1;

                } else if (tomatos[i][j] == 0) {
                    isDone = false;
                }
            }
        }

        if (isDone) {
            System.out.println(0);
            return;
        }

        runBFS();
        System.out.println(getAnswer());
    }

    static void runBFS() {
        while (!queue.isEmpty()) {
            Integer[] polled = queue.poll();
            int x = polled[0];
            int y = polled[1];

            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if (newx < 0 || newx >= N || newy < 0 || newy >= M
                        || visited[newx][newy] > 0 || tomatos[newx][newy] == -1) {
                    continue;
                }

                visited[newx][newy] = visited[x][y] + 1;
                queue.offer(new Integer[]{newx, newy});
            }
        }
    }

    static int getAnswer() {
        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatos[i][j] != -1 && visited[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, visited[i][j]);
            }
        }
        return max - 1;
    }
}
