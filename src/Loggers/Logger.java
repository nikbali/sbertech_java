package Loggers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final int ERROR = 0;
    private static final int INFO = 10;
    private static final int DEBUG = 20;
    private final int  level;
    private int num;

    public Logger(int level) {
        switch (level)
        {
            case ERROR :
                this.level = ERROR;
                break;
            case INFO :
                this.level = INFO;
                break;
            case DEBUG :
                this.level = DEBUG;
                break;
            default:
                throw new IllegalArgumentException("Input incorrect logger level");
        }
    }

    public int getLevel() {
        return level;
    }

    public void log(int level, String message)
    {
        if(level <= this.level)
        {
            num++;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            System.out.println(String.format("%s %s %s: %s",this.num, dateFormat.format(new Date()), this.level, message));
        }
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "level=" + level +
                ", num=" + num;
    }

    public static void main(String[] args) {
        Logger logger = new Logger(10);
        logger.log(2, "Error1");
        logger.log(4, "Error2");
        logger.log(9, "Error3");
        logger.log(20, "Error2");
    }
}
