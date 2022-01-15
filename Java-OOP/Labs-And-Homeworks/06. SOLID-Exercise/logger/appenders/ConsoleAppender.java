package logger.appenders;

import enums.ReportLevel;
import interfaces.Layout;

public class ConsoleAppender extends AbstractAppender {

    public ConsoleAppender(Layout layout, ReportLevel reportLevelThreshold) {
        super(layout, reportLevelThreshold);
    }

    @Override
    protected String getType() {
        return "ConsoleAppender";
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String massage) {
        System.out.println(super.getLayout().format(dateTime, reportLevel, massage));
        super.incrementCountAppended();
    }
}
