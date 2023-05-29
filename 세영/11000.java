import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer[]> times;
    static PriorityQueue<Integer> endTimes;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        times = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int T = Integer.parseInt(stringTokenizer.nextToken());
            times.add(new Integer[] {S, T});
        }

        // 시작 시간이 빠른 순으로 정렬 (시작 시간이 같다면, 종료 시간이 빠른 순으로)
        Collections.sort(times, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        // 수업들의 종료 시간을 저장하는 우선순위 큐
        endTimes = new PriorityQueue<>();
        endTimes.add(times.get(0)[1]);
        for(int i=1; i<N; i++) {
            int S = times.get(i)[0];
            int T = times.get(i)[1];

            if(endTimes.peek() <= S) { // 제일 빠른 수업 종료 시간보다 현재 수업 시작 시간이 크거나 같다면
                endTimes.poll();
                endTimes.add(T); // 수업 종료 시간을 업데이트 -> 우선순위 큐로 하여금 다시 정렬
            }
            else { // 그렇지 않다면
                endTimes.add(T); // 새로운 수업 종료 시간을 하나 추가
            }
        }

        System.out.println(endTimes.size()); // 우선순위 큐의 사이즈가 곧 최소 강의실의 개수

    }

}
