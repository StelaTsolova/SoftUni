package Threeuple_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Threeuple> output = new ArrayList<>();

        String[] input = bufferedReader.readLine().split("\\s+");
        String item11 = input[0] + " " + input[1];
        String item21 = input[2];
        String item31 = input[3];
        Threeuple<String, String, String> threeuple = new Threeuple<>(item11, item21, item31);
        output.add(threeuple);

        input = bufferedReader.readLine().split("\\s+");
        String item12 = input[0];
        int ite22 = Integer.parseInt(input[1]);
        boolean item32 = input[2].equals("drunk");
        Threeuple<String, Integer, Boolean> threeuple1 = new Threeuple<>(item12, ite22, item32);
        output.add(threeuple1);

        input = bufferedReader.readLine().split("\\s+");
        String item13 = input[0];
        double ite23 = Double.parseDouble(input[1]);
        String item33 = input[2];
        Threeuple<String, Double, String> threeuple2 = new Threeuple<>(item13, ite23, item33);
        output.add(threeuple2);

        StringBuilder stringBuilder = new StringBuilder();
        output.forEach(stringBuilder::append);

        System.out.println(stringBuilder);
    }
}