import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;
import interfaces.Logger;
import logger.MessageLogger;
import logger.appenders.ConsoleAppender;
import logger.appenders.FileAppender;
import logger.layouts.SimpleLayout;
import logger.layouts.XmlLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numAppenders = Integer.parseInt(scanner.nextLine());
        List<Appender> appenders = new ArrayList<>();
        while (numAppenders-- > 0) {
            String[] information = scanner.nextLine().split("\\s+");
            appenders.add(createAppender(information));
        }

        Logger logger = new MessageLogger(appenders);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] information = input.split("\\|");
            switch (information[0]) {
                case "INFO":
                    logger.logInfo(information[1], information[2]);
                    break;
                case "WARNING":
                    logger.logWarning(information[1], information[2]);
                    break;
                case "ERROR":
                    logger.logError(information[1], information[2]);
                    break;
                case "CRITICAL":
                    logger.logCritical(information[1], information[2]);
                    break;
                case "FATAL":
                    logger.logFatal(information[1], information[2]);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(logger.toString());

    }

    private static Appender createAppender(String[] information) {
        Layout layout = getLayout(information[1]);

        ReportLevel reportLevel = information.length == 3
                ? ReportLevel.valueOf(information[2].toUpperCase())
                : ReportLevel.INFO;

        switch (information[0]) {
            case "ConsoleAppender":
                return new ConsoleAppender(layout, reportLevel);
            case "FileAppender":
                return new FileAppender(layout, reportLevel);
            default:
                throw new IllegalArgumentException("Not found Appender");
        }
    }

    private static Layout getLayout(String information) {
        switch (information) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("Not found Layout");
        }
    }
}