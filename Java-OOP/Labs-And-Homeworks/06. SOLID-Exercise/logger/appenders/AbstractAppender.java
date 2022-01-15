package logger.appenders;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

public abstract class AbstractAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevelThreshold;
    private int countAppended;

    public AbstractAppender(Layout layout, ReportLevel reportLevelThreshold) {
        this.layout = layout;
        this.reportLevelThreshold = reportLevelThreshold;
    }

    protected Layout getLayout() {
        return layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevelThreshold = reportLevel;
    }

    @Override
    public ReportLevel getReportLevelThreshold() {
        return this.reportLevelThreshold;
    }

    protected void incrementCountAppended(){
        this.countAppended++;
    }

    protected abstract String getType();

    @Override
    public String toString() {
        //Appender type: FileAppender, Layout type: XmlLayout, Report level: INFO, Messages appended: 5, File size: 37526
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getType(), this.layout.getType(), reportLevelThreshold.toString(), this.countAppended);
    }
}
