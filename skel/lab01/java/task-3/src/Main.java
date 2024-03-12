import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static class Task {
        public final static String INPUT_FILE = "in";
        public final static String OUTPUT_FILE = "out";

        int n, x, y;

        public void solve() {
            readInput();
            writeOutput(getResult(n, x, y));
        }

        private void readInput() {
            try {
                Scanner sc = new Scanner(new File(INPUT_FILE));
                n = sc.nextInt();
                x = sc.nextInt();
                y = sc.nextInt();
                sc.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void writeOutput(int answer) {
            try {
                PrintWriter pw = new PrintWriter(new File(OUTPUT_FILE));
                pw.printf("%d\n", answer);
                pw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int getResult(int n, int x, int y) {
    // Calculate the value at position (x, y) in the matrix of size 2^n x 2^n

    // Base case.
    if (n == 1) {
        if (x == 1 && y == 1)
            return 1;
        if (x == 1 && y == 2)
            return 2;
        if (x == 2 && y == 1)
            return 3;
        if (x == 2 && y == 2)
            return 4;
    }

    int step = (int) Math.pow(2, (2 * n - 2));
    int mid = (int) Math.pow(2, (n - 1));

    if (x <= mid && y <= mid)
        return getResult(n - 1, x, y);
    if (x <= mid)
        return step + getResult(n - 1, x, y - mid);
    if (y <= mid)
        return 2 * step + getResult(n - 1, x - mid, y);
    return 3 * step + getResult(n - 1, x - mid, y - mid);

        }
    }

    public static void main(String[] args) {
        new Task().solve();
    }
}
