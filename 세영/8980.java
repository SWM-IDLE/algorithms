import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N, C, M;
    static ArrayList<Integer[]> list;
    static int[] truck;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(bufferedReader.readLine());

        list = new ArrayList<>();
        for(int i=0; i<M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int amount = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new Integer[] {from, to, amount});
        }


        /*
        1) to - from 이 작은 순
        2) from 이 작은 순
        3) amount 가 큰 순
        으로 정렬했을 때 52점

        1) 도착지가 빠른 순
        으로 정렬하면 100점

        반례
        7 10
        3
        1 4 10
        3 5 5
        4 7 10
         */
        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1]; // to가 작은 순
            }
        });

        int sum = 0;
        truck = new int[N+1]; // M개의 정보에 대해, 1 ~ N마을 까지 짐을 나를 때의 용량
        for(int i=0; i<M; i++) {
            Integer[] now = list.get(i);
            int from = now[0];
            int to = now[1];
            int amount = now[2];
            int min = Integer.MAX_VALUE;
            for(int j=from; j<to; j++) {
                int available = Math.min(amount, C - truck[j]);
                min = Math.min(min, available);
                if(min == 0) {
                    break;
                }
            }

            if(min == 0) {
                continue;
            }
            sum += min;
            for(int j=from; j<to; j++) {
                truck[j] += min;
            }
        }

        System.out.println(sum);

    }

}
