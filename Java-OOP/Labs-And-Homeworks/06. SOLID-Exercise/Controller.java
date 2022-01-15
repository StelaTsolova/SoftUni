import enums.ReportLevel;
import interfaces.Appender;
import logger.MessageLogger;

public abstract class Controller {
    private static MessageLogger messageLogger ;
    private ReportLevel reportLevel;
    private String dateTime;
    private String message;

    public Controller(ReportLevel reportLevel, String dateTime, String message, Appender... appenders) {

        this.reportLevel = reportLevel;
        this.dateTime = dateTime;
        this.message = message;
    }


}
