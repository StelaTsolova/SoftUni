package logger.layouts;

import enums.ReportLevel;
import interfaces.Layout;

public class SimpleLayout implements Layout {
    public SimpleLayout() {
    }

    @Override
    public String format(String dateTime, ReportLevel reportLevel, String massage) {
        return String.format("%s - %s - %s", dateTime, reportLevel.toString(), massage);
    }

    @Override
    public String getType() {
        return "SimpleLayout";
    }
}
