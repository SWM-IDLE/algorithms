import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int startH, startM;
    static int endH, endM;
    static int quitH, quitM;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 3; i++) {
            String str = stringTokenizer.nextToken();
            String[] time = str.split(":");
            int H = Integer.parseInt(time[0]);
            int M = Integer.parseInt(time[1]);

            switch (i) {
                case 0:
                    startH = H;
                    startM = M;
                    break;
                case 1:
                    endH = H;
                    endM = M;
                    break;
                case 2:
                    quitH = H;
                    quitM = M;
                    break;
            }
        }

        Set<String> enterMembers = new HashSet<>();
        Set<String> exitMembers = new HashSet<>();

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            // if(str.isEmpty()) break; -> 로컬 실행 시 이게 있어야 NumberFormatException이 나지 않음. 그러나 채점 시에는 빼도 되는 듯
            String[] Log = str.split(" ");
            String[] timeLog = Log[0].split(":");
            int H = Integer.parseInt(timeLog[0]);
            int M = Integer.parseInt(timeLog[1]);
            if ((H < startH) || (H == startH && M <= startM)) { // 개총 시작 전
                enterMembers.add(Log[1]);
            }

            else if ((H > endH) || (H == endH && M >= endM)) { // 개총 종료 후
                if ((H < quitH) || (H == quitH && M <= quitM)) { // 스트리밍 종료 전
                    exitMembers.add(Log[1]);
                }
            }
        }

        enterMembers.retainAll(exitMembers);
        System.out.println(enterMembers.size());
    }

}
