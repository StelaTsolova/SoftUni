import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject_9 {
    public static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Cube cube = new Cube("green", 15.3d, 12.4d, 3d);
        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\09.SerializeCustomObject.txt";
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(path));
            objectOutput.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
