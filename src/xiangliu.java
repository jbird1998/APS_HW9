import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class xiangliu {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        PriorityQueue<Integer> heads = new PriorityQueue<>(N);
        PriorityQueue<Integer> archers = new PriorityQueue<>(M);

        for (int i = 0; i < N; i++) {
            heads.offer(Integer.parseInt(read.readLine()));
        }
        for (int i = 0; i < M; i++) {
            archers.offer(Integer.parseInt(read.readLine()));
        }

        int headsEliminated = 0;
        long cost = 0L;
        if (N > M) {
            System.out.println("Xia is doomed!");
        } else {
            while (headsEliminated < N && !archers.isEmpty()) {
                int headToKill = heads.peek();
                int archer = archers.poll();
                if (archer >= headToKill) {
                    headsEliminated++;
                    heads.poll();
                    cost += archer;
                }
            }
            if (headsEliminated == N) {
                System.out.println(cost);
            } else {
                System.out.println("Xia is doomed!");
            }
        }
    }
}
