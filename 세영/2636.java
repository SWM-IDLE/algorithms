import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[][] cheese;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        cheese = new int[R][C];

        for(int i=0; i<R; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<C; j++) {
                cheese[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        ArrayList<Integer[]> melting = getMelting();
        int time = 0;
        int meltingCount = 0;

        while(melting.size() > 0) {
            time += 1;
            meltingCount = melting.size();
            melt(melting);
            melting = getMelting();
        }

        System.out.println(time);
        System.out.println(meltingCount);
    }

    static ArrayList<Integer[]> getMelting() {
        boolean[][] visited = new boolean[R][C];
        Queue<Integer[]> queue = new LinkedList<>();
        ArrayList<Integer[]> melting = new ArrayList<>();

        visited[0][0] = true;
        queue.offer(new Integer[] {0, 0});

        while(!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for(int i=0; i<4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if(newx < 0 || newx >= R || newy < 0 || newy >= C || visited[newx][newy]) continue;
                if(cheese[newx][newy] == 1) { // 공기와 인접한 치즈일 때
                    visited[newx][newy] = true;
                    melting.add(new Integer[] {newx, newy}); // 녹는 좌표 추가
                } else { // 인접한 공기일 때
                    visited[newx][newy] = true;
                    queue.offer(new Integer[] {newx, newy});
                }
            }
        }

        return melting;
    }

    static void melt(ArrayList<Integer[]> melting) {
        for(Integer[] m : melting) {
            cheese[m[0]][m[1]] = 0;
        }
    }

}
