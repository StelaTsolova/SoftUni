package interfaces;

import enums.ReportLevel;

public interface Layout {
    String format(String dateTime, ReportLevel reportLevel, String massage);

    String getType();
}
