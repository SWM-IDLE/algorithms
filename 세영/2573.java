import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static ArrayList<Integer[]> ices;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N][M];
        ices = new ArrayList<>();
        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j] > 0) {
                    ices.add(new Integer[] {i, j});
                }
            }
        }

        int time = 0;
        while(ices.size() > 0) {
            time += 1;
            ArrayList<Integer[]> meltedIces = melt();
            ices = new ArrayList<>();
            for(Integer[] ice : meltedIces) {
                ices.add(ice);
            }

            if(ices.size() == 0) {
                time = 0;
                break;
            }

            if(isDivided(ices.get(0)[0], ices.get(0)[1])) {
                break;
            }

        }

        System.out.println(time);
    }

    static ArrayList<Integer[]> melt() {
        ArrayList<Integer[]> meltedIces = new ArrayList<>();
        ArrayList<Integer> meltCount = new ArrayList<>();

        for(Integer[] ice : ices) {
            int x = ice[0];
            int y = ice[1];

            int cnt = 0;
            for(int i=0; i<4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if(newx < 0 || newx >= N || newy < 0 || newy >= M) continue;
                if(arr[newx][newy] == 0) cnt++;
            }

            meltCount.add(cnt);

        }

        for(int i=0; i<ices.size(); i++) {
            int x = ices.get(i)[0];
            int y = ices.get(i)[1];

            arr[x][y] = Math.max(0, arr[x][y] - meltCount.get(i));

            if(arr[x][y] > 0) {
                meltedIces.add(new Integer[] {x, y});
            }
        }

        return meltedIces;
    }

    static boolean isDivided(int startX, int startY) {
        boolean[][] visited = new boolean[N][M];
        bfs(startX, startY, visited);

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] != 0 && !visited[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    static void bfs(int startX, int startY, boolean[][] visited) {
        Queue<Integer[]> queue = new LinkedList<>();

        visited[startX][startY] = true;
        queue.offer(new Integer[] {startX, startY});

        while(!queue.isEmpty()) {
            Integer[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int i=0; i<4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if(newx < 0 || newx >= N || newy < 0 || newy >= M || visited[newx][newy]) continue;
                if(arr[newx][newy] != 0) {
                    queue.offer(new Integer[] {newx, newy});
                    visited[newx][newy] = true;
                }
            }
        }
    }


}
