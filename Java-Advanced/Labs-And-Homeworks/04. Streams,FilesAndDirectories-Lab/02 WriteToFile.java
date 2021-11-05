import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile_2 {
    public static void main(String[] args) {
        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt");
            int readByte = inputStream.read();
            while (readByte != -1) {
                if (readByte != ',' && readByte != '.' && readByte != '!' && readByte != '?') {
                    outputStream.write((char) readByte);
                }
                readByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
