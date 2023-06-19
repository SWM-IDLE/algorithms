import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] answers;
    static int[] selected;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer answer = new StringTokenizer(bufferedReader.readLine());
        answers = new int[10];
        for(int i=0; i<10; i++) {
            answers[i] = Integer.parseInt(answer.nextToken());
        }

        count = 0;
        selected = new int[11];
        select(0);
        System.out.println(count);
    }

    static int getScore() {
        int score = 0;
        for(int i=1; i<=10; i++) {
            if(selected[i] == answers[i-1]) {
                score += 1;
            }
        }
        return score;
    }

    static void select(int x) {
        if(x == 10) { // 10번까지 모두 고름
            int score = getScore();
            if(score >= 5) {
                count +=1 ;
            }
            return;
        }

        int impossible = check(x+1);
        for(int i=1; i<=5; i++) {
            if(i != impossible) {
                selected[x+1] = i;
                select(x+1);
                selected[x+1] = 0;
            }
        }

    }

    static int check(int x) { // 인덱스 x에서 선택할 수 없는 수 반환
        if(x < 2) {
            return -1;
        }

        if(selected[x-1] == selected[x-2]) {
            return selected[x-1];
        }

        return -1;
    }
}
