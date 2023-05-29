import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int[] ranks;
    static int M;
    static ArrayList<ArrayList<Integer>> inbounds;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while(T-- > 0) {
            N = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ranks = new int[N];
            for(int i=0; i<N; i++) {
                ranks[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            // 작년 기준 inbound 기록
            getInbounds();

            M = Integer.parseInt(bufferedReader.readLine());
            for(int i=0; i<M; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                modifyInbounds(a, b);
            }

            // inbound 정보가 모두 업데이트 되었다면 위상정렬 실행
            String answer = topologicalSort();
            stringBuilder.append(answer).append('\n');
        }
        System.out.println(stringBuilder.toString());
    }

    static void getInbounds() {
        inbounds = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            inbounds.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                inbounds.get(ranks[j]).add(ranks[i]);
            }
        }
    }

    static void modifyInbounds(int a, int b) {
        if(inbounds.get(a).contains(b)) { // b -> a 이면
            inbounds.get(a).remove((Integer) b);
            inbounds.get(b).add(a); // a -> b로 변경
            return;
        } // 아니면 반대로
        inbounds.get(b).remove((Integer) a);
        inbounds.get(a).add(b);
    }

    static String topologicalSort() {
        boolean[] checked = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(inbounds.get(i).isEmpty()) {
                queue.offer(i);
                checked[i] = true;
            }
        }
        if(queue.size() > 1) { // 확실한 순위를 찾을 수 없다면
            return "?";
        }
        else if(queue.isEmpty()) { // 데이터에 일관성이 없어서 순위를 정할 수 없는 경우
            return "IMPOSSIBLE";
        }

        StringBuilder answer = new StringBuilder();
        while(!queue.isEmpty()) {
            int now = queue.poll();
            answer.append(now + " ");

            for(int i=1; i<=N; i++) {
                if(inbounds.get(i).contains(now)) {
                    inbounds.get(i).remove((Integer) now);
                }
            }

            for(int i=1; i<=N; i++) {
                if(!checked[i] && inbounds.get(i).isEmpty()) {
                    queue.offer(i);
                    checked[i] = true;
                }
            }

            if(queue.size() > 1) { // 확실한 순위를 찾을 수 없다면
                return "?";
            }
            else if(!isEnd(checked) && queue.isEmpty()) { // 데이터에 일관성이 없어서 순위를 정할 수 없는 경우
                return "IMPOSSIBLE";
            }
        }
        return answer.toString();
    }

    static boolean isEnd(boolean[] checked) {
        for(int i=1; i<checked.length; i++) {
            if(!checked[i]) {
                return false;
            }
        }
        return true;
    }

}
