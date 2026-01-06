import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Backup {

    public static boolean backupFile(String source, String destination) {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        backupFile("data.txt", "backup/data.bak");
    }
}
