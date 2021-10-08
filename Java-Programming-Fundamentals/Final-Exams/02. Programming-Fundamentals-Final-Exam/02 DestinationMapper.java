import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_2_02 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String places = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=|\\/])(?<place>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(places);
        List<String> validPlaces = new ArrayList<>();
        int points = 0;
        while (matcher.find()){
            String place = matcher.group("place");
            validPlaces.add(place);
            points += place.length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", validPlaces));
        System.out.printf("Travel Points: %d", points);
    }
}