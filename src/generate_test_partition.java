import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class generate_test_partition {

    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("100000 2\n");
        StringBuilder line = new StringBuilder(1100000);
        for (int i = 1; i <= 100000; i++) {
            line.append("1000000000");
            if (i != 100000) {
                line.append(" ");
            }
        }
        lines.add(line.toString());
        Path file = Paths.get("test1.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);
    }
}
