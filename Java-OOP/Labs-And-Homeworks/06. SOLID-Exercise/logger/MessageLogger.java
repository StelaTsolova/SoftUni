package logger;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(List<Appender> appenders) {
        this.appenders = new ArrayList<>(appenders);
    }

    @Override
    public void logInfo(String dateTime, String message) {
        this.callAppenders(dateTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.callAppenders(dateTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateTime, String message) {
        this.callAppenders(dateTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.callAppenders(dateTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.callAppenders(dateTime, ReportLevel.FATAL, message);
    }

    private void callAppenders(String dateTime, ReportLevel reportLevel, String message) {
        for (Appender appender : this.appenders) {
            if (appender.getReportLevelThreshold().ordinal() <= reportLevel.ordinal()) {
                appender.append(dateTime, reportLevel, message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info").append(System.lineSeparator());
        appenders.forEach(a -> builder.append(a.toString()).append(System.lineSeparator()));

        return builder.toString();
    }
}
