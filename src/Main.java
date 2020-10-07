
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Sms();
//        write("Some more sentences...");
//        write("Some more sentences 2...");
//        write("Some more sentences 3...");

        System.out.println(read(5));
        System.out.println(read2(5));
    }

    static Collection<String> read(int linesNumber) {
        File fileToRead = new File("src/test.txt");
        try (FileReader rd = new FileReader(fileToRead);
             BufferedReader br = new BufferedReader(rd)) {

            List<String> lines = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                lines.add(str);
            }

            List<String> lastLines = new ArrayList<>();
            for (int i = lines.size() - linesNumber; i < lines.size(); i++) {
                lastLines.add(lines.get(i));
            }

            return lastLines;
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

    static String read2(int linesNumber) {
        File fileToRead = new File("src/test.txt");
        try {
            RandomAccessFile raf = new RandomAccessFile(fileToRead, "r");
            StringBuilder sb = new StringBuilder();
            int readedLines = 0;
            for (long i = raf.length() - 1; i >= 0; i--) {
                raf.seek(i);
                char c = (char) raf.read();
                if (c == '\n') {
                    readedLines++;
                    if (readedLines == linesNumber) {
                        break;
                    }
                }
                sb.append(c);
            }
            return sb.reverse().toString();
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }

    }

    static void write(String sentence) {
        File fileToWrite = new File("src/test.txt");
        try (FileWriter fw = new FileWriter(fileToWrite, true);
             BufferedWriter bf = new BufferedWriter(fw)) {
            bf.newLine();
            bf.write(sentence);
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

}
