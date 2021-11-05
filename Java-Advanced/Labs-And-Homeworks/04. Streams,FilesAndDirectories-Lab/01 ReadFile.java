import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_1 {
    public static void main(String[] args) {
        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int readByte = fileInputStream.read();
            while (readByte != -1){
                System.out.print(Integer.toBinaryString(readByte) + " ");
                readByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
