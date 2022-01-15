package logger.appenders;

import enums.ReportLevel;
import interfaces.File;
import interfaces.Layout;
import logger.LogFile;

public class FileAppender extends AbstractAppender  {
    private File file;

    public FileAppender(Layout layout, ReportLevel reportLevelThreshold) {
        super(layout, reportLevelThreshold);
        this.file = new LogFile();
    }

    @Override
    protected String getType() {
        return "FileAppender";
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String massage) {
            String formatted = super.getLayout().format(dateTime, reportLevel, dateTime);
            this.file.write(formatted);
            super.incrementCountAppended();
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() +", File size: " + this.file.size();
    }
}
