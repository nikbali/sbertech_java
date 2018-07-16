package Loggers;


public class NameableLogger extends Logger {

    private final String name;
    public NameableLogger(int level, String name) {
        super(level);
        this.name = name;
    }

    @Override
    public void log(int level, String message) {
        if(level <= getLevel())
        {
            System.out.print(this.name+": ");
            super.log(level, message);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s" , this.name, super.toString());
    }

    public static void main(String[] args) {
        NameableLogger logger= new NameableLogger(20, "Best");
        logger.log(20, "Its OK");
    }
}
