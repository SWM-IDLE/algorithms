import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static ArrayList<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        answer = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, list);

        StringBuilder stringBuilder = new StringBuilder();
        for(String ans : answer) {
            stringBuilder.append(ans).append("\n");
        }
        System.out.println(stringBuilder.toString());


    }

    static void dfs(int depth, ArrayList<Integer> list) {
        if(depth == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int number : list) {
                if(number == 0) continue;
                stringBuilder.append(number).append(" ");
            }

            answer.add(stringBuilder.toString());
            return;
        }
        for(int i=0; i<N; i++) {
            if(list.get(list.size()-1) <= arr[i]) {
                list.add(arr[i]);
                dfs(depth+1, list);
                list.remove(list.size()-1); // 백트래킹
            }
        }

    }

}
