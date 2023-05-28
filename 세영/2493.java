import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // Integer[] {높이, 인덱스} : 수신을 기다리는 탑
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) { // 높이를 기준으로 우선순위 큐 형성
                return o1[0] - o2[0];
            }
        });
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=N-1; i>=0; i--) { // 맨 오른쪽 탑부터 탐색
            while(!priorityQueue.isEmpty()) { // 우선순위 큐가 빌 때까지
                if(priorityQueue.peek()[0] <= arr[i]) { // 큐에서 peek한 높이가 현재 탑의 높이 이하라면
                    Integer[] received = priorityQueue.poll(); // 큐에서 poll,
                    hashMap.put(received[1], i+1); // map에 {송신한 탑의 인덱스 : 현재 수신한 탑의 인덱스} 저장
                }
                else { // 현재 탑의 높이 이상이라면 탐색 종료
                    break;
                }
            }
            priorityQueue.offer(new Integer[] {arr[i], i}); // 현재 탑의 인덱스와 높이 큐에 삽입
        }

        int[] answer = new int[N];
        for(Integer key : hashMap.keySet()) { // map에 저장된 좌표들을 answer 배열에 기록
            answer[key] = hashMap.get(key);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<N; i++) {
            stringBuilder.append(answer[i] + " ");
        }

        System.out.println(stringBuilder.toString());
    }

}
