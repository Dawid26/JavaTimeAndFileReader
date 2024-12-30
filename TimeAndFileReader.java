import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeAndFileReader {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time: " + now.format(formatter));
        String filePath = "C://temp//test.txt";

        try {
            appendDateTimeToFile(filePath, now.format(formatter));
            System.out.println("Current System Time appended to file: " + filePath);

            try (FileReader fileReader = new FileReader(filePath)) {
                char[] buffer = new char[200];
                int bytesRead;
                System.out.println("Reading content of the file: " + filePath);
                while ((bytesRead = fileReader.read(buffer)) != -1) {
                    System.out.print(new String(buffer, 0, bytesRead));
                }
            }
        } catch (IOException error) {
            System.err.println("Error: " + error.getMessage());
        }
    }

    private static void appendDateTimeToFile(String filePath, String dateTime) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(System.lineSeparator());
            writer.write(System.lineSeparator()+dateTime  +System.lineSeparator());
        }
    }
}
