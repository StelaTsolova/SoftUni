package logger.layouts;

import enums.ReportLevel;
import interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String massage) {
        StringBuilder builder = new StringBuilder("<log>").append(System.lineSeparator());
        builder.append(String.format(" <date>%s</date>", dateTime)).append(System.lineSeparator());
        builder.append(String.format(" <level>%s</level>", reportLevel)).append(System.lineSeparator());
        builder.append(String.format(" <messages>%s</messages>", massage)).append(System.lineSeparator());
        builder.append("</log>");

        return builder.toString();
    }

    @Override
    public String getType() {
        return "XmlLayout";
    }
}
