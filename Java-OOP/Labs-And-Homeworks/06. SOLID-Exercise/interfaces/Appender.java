package interfaces;

import enums.ReportLevel;

public interface Appender {
    void append(String dateTime, ReportLevel reportLevel, String massage);

    void setReportLevel(ReportLevel reportLevel);

    ReportLevel getReportLevelThreshold();
}
