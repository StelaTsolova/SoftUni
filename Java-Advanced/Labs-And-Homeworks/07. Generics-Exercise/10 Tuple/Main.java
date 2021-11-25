package Tuple_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Tuple> output = new ArrayList<>();

        String[] input = reader.readLine().split("\\s+");
        String item11 = input[0] + " " + input[1];
        String item21 = input[2];
        Tuple<String, String> tuple = new Tuple<>(item11, item21);
        output.add(tuple);

        input = reader.readLine().split("\\s+");
        String item12 = input[0];
        int item22 = Integer.parseInt(input[1]);
        Tuple<String, Integer> tuple1 = new Tuple<>(item12, item22);
        output.add(tuple1);

        input = reader.readLine().split("\\s+");
        int item31 = Integer.parseInt(input[0]);
        double item32 = Double.parseDouble(input[1]);
        Tuple<Integer, Double> tuple2 = new Tuple<>(item31, item32);
        output.add(tuple2);

        StringBuilder stringBuilder = new StringBuilder();
        output.forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }
}