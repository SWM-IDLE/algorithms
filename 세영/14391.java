import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static String[][] arr;
    static boolean[][] horizontal;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new String[N][M];
        for(int i=0; i<N; i++) {
            String str = bufferedReader.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.substring(j, j+1);
            }
        }

        horizontal = new boolean[N][M];
        max = -1;
        search(0, 0);

        System.out.println(max);
    }

    static void check() {
        // 가로로 묶인 숫자들을 구해서 더하기
        int horizontalSum = 0;
        String tmp = "";
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(horizontal[i][j]) { // 가로로 세야 하면
                    tmp += arr[i][j]; // 문자를 이어붙임
                }
                else if(!tmp.isEmpty()) { // 이전까지 이어진 문자들을 숫자로 변환해서 누적 합산
                    horizontalSum += Integer.parseInt(tmp);
                    tmp = ""; // 문자열 초기화
                }
            }
            if(!tmp.isEmpty()) { // 다음 행 탐색 전에 이어진 문자 합산
                horizontalSum += Integer.parseInt(tmp);
                tmp = "";
            }
        }

        // 세로로 묶인 숫자들을 구해서 더하기
        int verticalSum = 0;
        tmp = "";
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!horizontal[j][i]) { // 세로로 세야 한다면
                    tmp += arr[j][i]; // 문자를 이어 붙임
                }
                else if(!tmp.isEmpty()) { // 이전까지 이어진 문자들을 숫자로 변환해서 누적 합산
                    verticalSum += Integer.parseInt(tmp);
                    tmp = ""; // 문자열 초기화
                }
            }
            if(!tmp.isEmpty()) { // 다음 열 탐색 전에 이어진 문자 합산
                verticalSum += Integer.parseInt(tmp);
                tmp = "";
            }
        }

        int result = horizontalSum + verticalSum;
        max = Math.max(max, result);
    }

    static void search(int r, int c) {
        if(r == N) {
            check();
            return;
        }

        if(c == M) {
            search(r+1, 0);
            return;
        }

        horizontal[r][c] = true;
        search(r, c+1);

        horizontal[r][c] = false;
        search(r, c+1);
    }

}
