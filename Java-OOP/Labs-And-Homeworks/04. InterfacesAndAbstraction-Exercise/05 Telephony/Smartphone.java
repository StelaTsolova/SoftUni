package Telephony_5;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d");
        for (int i = 0; i < this.urls.size(); i++) {
            Matcher matcher = pattern.matcher(this.urls.get(i));
            if (matcher.find()) {
                stringBuilder.append("Invalid URL!");
            } else {
                stringBuilder.append(String.format("Browsing: %s!", this.urls.get(i)));
            }
            if (i != this.urls.size() - 1) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("\\D");
        for (int i = 0; i < this.numbers.size(); i++) {
            Matcher matcher = pattern.matcher(this.numbers.get(i));
            if (matcher.find()) {
                stringBuilder.append("Invalid number!");
            } else {
                stringBuilder.append(String.format("Calling... %s", this.numbers.get(i)));
            }
            if (i != this.numbers.size() - 1) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }
}