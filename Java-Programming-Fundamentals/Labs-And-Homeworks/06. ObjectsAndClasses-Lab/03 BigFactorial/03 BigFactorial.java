package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 int n = Integer.parseInt(scanner.nextLine());
        BigInteger  factorialOfN = new BigInteger(String.valueOf(1));
        for (int i = 2; i <= n ; i++) {
          factorialOfN = factorialOfN.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorialOfN);
    }
}