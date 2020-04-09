import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no_change {

    public static void main(String[] args) throws IOException {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tokens = new StringTokenizer(read.readLine());

        int[] prices = new int[15001];

        int M = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(tokens.nextToken());
        int coin;
        for (int i = 0; i < N; i++) {
            coin = Integer.parseInt(read.readLine());
            for (int j = 15000 - coin; j >= 1; j--) {
                int next = prices[j] + 1;
                if (prices[j] > 0 && (prices[j + coin] == 0 || next < prices[j + coin])) {
                    prices[j + coin] = next;
                }
            }
            prices[coin] = 1;
        }
//        for (int i = 1; i < 10001; i++) {
//            if (prices[i] > 0) {
//                System.out.println(i + " " + prices[i]);
//            }
//        }
//        System.out.println("Ans:");
        for (int i = M; i < 15001; i++) {
            if (prices[i] > 0) {
                System.out.println(i + " " + prices[i]);
                return;
            }
        }
    }
}
