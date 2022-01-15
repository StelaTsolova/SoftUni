package logger;

import interfaces.File;

public class LogFile implements File {
    private StringBuilder builder;

    public LogFile() {
        this.builder = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.builder.append(text);
    }

    @Override
    public int size() {
        int sum = 0;
        for (char symbol : this.builder.toString().toCharArray()) {
            if (Character.isAlphabetic(symbol)) {
                sum += symbol;
            }
        }
        return sum;
    }
}
