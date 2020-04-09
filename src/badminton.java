import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class badminton {


    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(read.readLine());

        int M = Integer.parseInt(tokens.nextToken());
        int F = Integer.parseInt(tokens.nextToken());

        int minSkill = 61;
        for (int i = 0; i < M; i++) {
            int skill = Integer.parseInt(read.readLine());
            if (skill < minSkill) {
                minSkill = skill;
            }
        }
        for (int i = 0; i < F; i++) {
            int skill = Integer.parseInt(read.readLine());
        }

        if (M <= F) {
            System.out.println("0");
        } else {
            System.out.println((M - F) + " " + minSkill);
        }

    }

}
