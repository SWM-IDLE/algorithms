import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] parent;
    static int deleteNumber;
    static int countLeaf;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        parent = new int[N];

        int root = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (parent[i] == -1) {
                root = i;
            }
        }

        deleteNumber = Integer.parseInt(bufferedReader.readLine());
        deleteNode(deleteNumber);

        countLeaf = 0;
        visited = new boolean[N];
        getCountLeaf(root);

        System.out.println(countLeaf);
    }

    static void deleteNode(int deleteNumber) { // 재귀적으로 삭제
        parent[deleteNumber] = -2; // 삭제 표시
        for (int i = 0; i < N; i++) {
            if (parent[i] == deleteNumber) {
                deleteNode(i);
            }
        }
    }

    static void getCountLeaf(int number) {
        boolean isLeaf = true;
        visited[number] = true;
        if (parent[number] != -2) { // 삭제되지 않은 노드에 대해
            for (int i = 0; i < N; i++) {
                if (parent[i] == number && !visited[i]) { // 방문하지 않은 자식 노드들에서 리프 탐색
                    getCountLeaf(i);
                    isLeaf = false; // 자식이 있기 때문에 리프 노드가 아님
                }
            }
            if (isLeaf) { // 리프 노드인 경우
                countLeaf += 1;
            }
        }
    }


}
