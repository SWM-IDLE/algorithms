import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int arr[];
    static boolean[] isRobot;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[2*N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<2*N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        isRobot = new boolean[2*N];
        System.out.println(getAnswer());
    }

    static int getAnswer() {
        int cnt = 0;
        int numK = 0;

        while(numK < K) {
            cnt ++; // 단계 증가
            rotate(); // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.

            for(int i=N-2; i>=0; i--) { // 가장 먼저 벨트에 올라간 로봇부터,
                if(isRobot[i] && !isRobot[i+1] && arr[i+1] >= 1) { // 이동하려는 칸에 로봇이 없고, 내구도가 1 이상이라면
                    isRobot[i] = false;
                    isRobot[i+1] = true; // 한 칸 이동한다.
                    arr[i+1] -= 1; // 움직인 칸의 내구도를 감소한다.

                    if(i+1 == N-1) {
                        isRobot[i+1] = false;
                    }

                    if(arr[i+1] == 0) { // 칸의 내구도가 0이면 numK 증가
                        numK += 1;
                    }
                } // 만약 이동할 수 없다면 가만히 있는다.
            }

            if(arr[0] != 0) { // 올리는 위치에 있는 칸의 내구도가 0이 아니면
                arr[0] -= 1;
                if(arr[0] == 0) { // 칸의 내구도가 0이면 numK 증가
                    numK += 1;
                }
                isRobot[0] = true; // 올리는 위치에 로봇을 올린다.
            }

        }

        return cnt;
    }

    static void rotate() {
        int tmp = arr[2*N-1];
        for(int i=2*N-1; i>0; i--) { // 컨베이어 벨트 회전
            arr[i] = arr[i-1];
        }
        arr[0] = tmp;

        for(int i=N-1; i>0; i--) { // 로봇 위치 업데이트
            if(isRobot[i-1]) {
                isRobot[i-1] = false;
                isRobot[i] = true;
                if(i == N-1) {
                    isRobot[i] = false;
                }
            }
        }

    }

}
