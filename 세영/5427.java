import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int W, H;
    static char[][] map;
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};
    static int[][] fireVisited;
    static int[][] manVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            W = Integer.parseInt(stringTokenizer.nextToken());
            H = Integer.parseInt(stringTokenizer.nextToken());

            map = new char[H][W];
            fireVisited = new int[H][W];
            manVisited = new int[H][W];

            int startX = 0;
            int startY = 0;
            ArrayList<Integer[]> fires = new ArrayList<>();

            for(int i=0; i<H; i++) {
                String str = bufferedReader.readLine();
                for(int j=0; j<W; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '@') {
                        manVisited[i][j] = 1;
                        startX = i;
                        startY = j;
                    }
                    if(map[i][j] == '*') {
                        fireVisited[i][j] = 1;
                        fires.add(new Integer[] {i, j});
                    }
                }
            }

            int answer = getAnswer(startX, startY, fires);
            if(answer == -1) {
                stringBuilder.append("IMPOSSIBLE").append('\n');
            }
            else {
                stringBuilder.append(answer).append('\n');
            }

        }

        System.out.println(stringBuilder.toString());

    }

    static int getAnswer(int startX, int startY, ArrayList<Integer[]> fires) {
        Queue<Integer[]> manQueue = new LinkedList<>();
        manQueue.offer(new Integer[] {startX, startY});

        Queue<Integer[]> fireQueue = new LinkedList<>();
        for(Integer[] fire : fires) {
            fireQueue.add(fire);
        }

        int manUnit = 1;
        int fireUnit = fireQueue.size();

        while(!manQueue.isEmpty() || !fireQueue.isEmpty()) {
            for(int uf=0; uf<fireUnit; uf++) {
                Integer[] now = fireQueue.poll();
                int x = now[0];
                int y = now[1];

                for(int i=0; i<4; i++) {
                    int newx = x + dx[i];
                    int newy = y + dy[i];

                    if(newx < 0 || newx >= H || newy < 0 || newy >= W) {
                        continue;
                    }
                    if(fireVisited[newx][newy] != 0 || map[newx][newy] == '#') {
                        continue;
                    }



                    fireVisited[newx][newy] = fireVisited[x][y] + 1;
                    map[newx][newy] = '*';
                    fireQueue.add(new Integer[] {newx, newy});
                }
            }
            fireUnit = fireQueue.size();


            for(int um=0; um<manUnit; um++) {
                Integer[] now = manQueue.poll();
                int x = now[0];
                int y = now[1];

                for(int i=0; i<4; i++) {
                    int newx = x + dx[i];
                    int newy = y + dy[i];

                    if(newx < 0 || newx >= H || newy < 0 || newy >= W) {
                        // 이제 탈출하니까 그냥 답 리턴
                        return manVisited[x][y];
                    }
                    if(manVisited[newx][newy] != 0 || map[newx][newy] == '*' || map[newx][newy] == '#') {
                        continue;
                    }
                    manVisited[newx][newy] = manVisited[x][y] + 1;
                    manQueue.add(new Integer[] {newx, newy});
                }
            }
            manUnit = manQueue.size();
            if(manUnit == 0) {
                return -1;
            }

        }

        return -1;

    }
}
