package AdvertisementMessage_1;

import java.util.Arrays;
import java.util.List;

public class Message {
    private List<String> phrases = Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.",
            "Best product of its category.", "Exceptional product.", "I can’t live without this product.");
    private List<String> events = Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
            "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!") ;
    private List<String> authors = Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
    private List<String> cities = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

    public String generatesMessage(int numberPhrase, int numberEvent, int numberAuthor, int numberCity){
        return phrases.get(numberPhrase) + " " + events.get(numberEvent) + " " + authors.get(numberAuthor) + " - " + cities.get(numberCity);
    }
}
