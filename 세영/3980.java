import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int C;
    static int[][] stats;
    static int[] selected; // selected[i] = j -> i 포지션에 j 선수 선택
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(bufferedReader.readLine());
        while(C-- > 0) {
            // 테스트케이스마다 stat 초기화
            stats = new int[12][12];
            for(int i=1; i<=11; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=1; j<=11; j++) {
                    stats[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            selected = new int[12];
            max = -1;
            backtracking(0);
            System.out.println(max);
        }

    }

    static void backtracking(int position) {
        if(position == 11) {
            int sum = 0;
            for(int i=1; i<=11; i++) {
                sum += stats[i][selected[i]];
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=1; i<=11; i++) {
            // stat이 0이 아니고 지금까지 선택되지 않은 선수라면
            if(stats[position+1][i] != 0 && !contains(i, position)) {
                selected[position+1] = i;
                backtracking(position + 1);
                selected[position+1] = -1; // 백트래킹
            }
        }
    }

    static boolean contains(int x, int until) {
        for(int i=1; i<=until; i++) {
            if(selected[i] == x) {
                return true;
            }
        }
        return false;
    }
    
}
