package Loggers;

public class RepeatableLogger extends Logger {

    private final int repeat;
    public RepeatableLogger(int level, int repeat)
    {
        super(level);
        this.repeat = repeat;
    }

    @Override
    public void log(int level, String message) {
        for(int i = 0; i<repeat; i++)
        {
            super.log(level, message);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "repeat=" + repeat;
    }

    public static void main(String[] args) {
        RepeatableLogger logger = new RepeatableLogger(10, 5);
        logger.log(10, "Go");
    }
}
