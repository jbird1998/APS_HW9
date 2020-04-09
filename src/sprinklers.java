import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sprinklers {

    static ArrayList<Interval> total;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(read.readLine());

        int n = Integer.parseInt(tokens.nextToken());
        int l = Integer.parseInt(tokens.nextToken());
        int w = Integer.parseInt(tokens.nextToken());

        total = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(read.readLine());
            int p = Integer.parseInt(tokens.nextToken());
            int r = Integer.parseInt(tokens.nextToken());
            if (r <= w / 2) {
                continue;
            }
            double len = Math.sqrt(Math.pow(r, 2) - Math.pow((double) w / 2, 2));
            Interval in = new Interval(Math.max(p - len, 0), Math.min(p + len, l));
            total.add(in);
        }
        n = total.size();

        ArrayList<Interval> needed = new ArrayList<>();
        Comparator<Interval> comp = new fromLeftComp();
        total.sort(comp);
        double lastPos = 0.;
        int size;
        int index = 0;
        while (index < n) {
            //System.out.println(index);
            //System.out.println("\tTotal: " + total);
            //System.out.println("\tNeeded: " + needed + "\n");
            size = needed.size();
            Interval current = total.get(index);
            if (size == 0) {
                if (current.left <= lastPos) {
                    lastPos = current.right;
                    index++;
                    needed.add(current);
                    continue;
                } else {
                    break;
                }
            }
            double maxGain = Double.MIN_VALUE;
            Interval commit = null;
            for (int i = index; i < n; i++) {
                Interval look = total.get(i);
                if (look.left <= lastPos) {
                    double p = look.right - lastPos;
                    if (p > maxGain) {
                        maxGain = p;
                        commit = look;
                    }
                    index = i + 1;
                } else {
                    index = i;
                    break;
                }
            }
            if (commit != null) {
                needed.add(commit);
                lastPos = commit.right;
                size++;
            } else {
                break;
            }
            if (lastPos >= l) {
                //System.out.println("Needed: " + needed + "\n");
                System.out.println(size);
                return;
            }
        }
        //System.out.println("Needed: " + needed + "\n");
        if (lastPos >= l) {
            System.out.println(needed.size());
        } else {
            System.out.println(-1);
        }
    }

    public static class Interval {
        double left;
        double right;
        double size;

        public Interval(double l, double r) {
            this.left = l;
            this.right = r;
            this.size = right - left;
        }

        @Override
        public String toString() {
            return "(" + left + ", " + right + ")";
        }
    }

    public static class fromLeftComp implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.left < o2.left) {
                return -1;
            } else if (o1.left == o2.left) {
                return -1*Double.compare(o1.size, o2.size);
            }
            return 1;
        }
    }
}
