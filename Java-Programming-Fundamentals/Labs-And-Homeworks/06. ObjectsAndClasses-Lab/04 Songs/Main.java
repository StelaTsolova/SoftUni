package com.company;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
        int numSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < numSongs; i++) {
            String[] date = scanner.nextLine().split("_");
            String type = date[0];
            String name = date[1];
            String time = date[2];

            Song song = new Song(type, name, time);

            songs.add(song);
        }
        String lastLine = scanner.nextLine();
        if (lastLine.equals("all")){
            for (Song song:songs){
                System.out.println(song.getName());
            }
        } else {
            for (Song song:songs){
                if(lastLine.equals(song.getTypeList())){
                    System.out.println(song.getName());
                }
            }
        }
    }
}
