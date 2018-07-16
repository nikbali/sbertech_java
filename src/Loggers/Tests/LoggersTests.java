package Loggers.Tests;

import Loggers.Logger;
import Loggers.NameableLogger;
import Loggers.RepeatableLogger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LoggersTests {

    private final int ERROR = 0;
    private  final int INFO = 10;
    private  final int DEBUG = 20;
    String message0 = "Error message";
    String message1 = "Worked message";
    String message2 = "Working message";
    OutputStream outputStream;
    @Before
    public void initData()
    {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

    }

    /**
     * Tests for Logger
     */
    @Test
    public void testIsOutputMessageLoggerERROR()
    {
        Logger logger = new Logger(ERROR);
        int num = 0;
        logger.log(ERROR, message0);
        String [] actual = outputStream.toString().split(" ");
        StringBuilder actual_message = new StringBuilder();
        for(int i = 3; i<actual.length; i++)
        {
            actual_message.append(actual[i]).append(" ");
        }
        Assert.assertEquals(++num, Integer.parseInt(actual[0]));
        Assert.assertTrue(LoggersTests.checkTime(actual[1]));
        Assert.assertEquals(ERROR, Integer.parseInt(actual[2].replace(":","")));
        Assert.assertEquals(message0, actual_message.toString().trim());

    }

    @Test
    public void testIsOutputMessageLoggerINFO()
    {
        Logger logger = new Logger(INFO);
        int num = 0;
        logger.log(8, message1);
        String [] actual = outputStream.toString().split(" ");
        StringBuilder actual_message = new StringBuilder();
        for(int i = 3; i<actual.length; i++)
        {
            actual_message.append(actual[i]).append(" ");
        }
        Assert.assertEquals(++num, Integer.parseInt(actual[0]));
        Assert.assertTrue(LoggersTests.checkTime(actual[1]));
        Assert.assertEquals(INFO, Integer.parseInt(actual[2].replace(":","")));
        Assert.assertEquals(message1, actual_message.toString().trim());

    }

    @Test
    public void testIsOutputMessageLoggerDEBUG()
    {
        Logger logger = new Logger(DEBUG);
        int num = 0;
        logger.log(17, message2);
        String [] actual = outputStream.toString().split(" ");
        StringBuilder actual_message = new StringBuilder();
        for(int i = 3; i<actual.length; i++)
        {
            actual_message.append(actual[i]).append(" ");
        }
        Assert.assertEquals(++num, Integer.parseInt(actual[0]));
        Assert.assertTrue(LoggersTests.checkTime(actual[1]));
        Assert.assertEquals(DEBUG, Integer.parseInt(actual[2].replace(":","")));
        Assert.assertEquals(message2, actual_message.toString().trim());

    }

    @Test
    public void testIsOutputMessageLoggerEmpty()
    {
        Logger logger = new Logger(DEBUG);
        logger.log(DEBUG+1, message0);
        String actual = outputStream.toString();
        Assert.assertEquals("",actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionLogger() {
        Logger logger = new Logger(DEBUG+1);
    }

    /**
     * Tests for NameableLogger
     */
    @Test
    public void testIsOutputMessageNameableLoggerERROR()
    {
        //имя логгера может быть только строкой без пробелов
        String name = "NameLogger";
        NameableLogger logger = new NameableLogger(ERROR, name);
        int num = 0;
        logger.log(ERROR, message0);
        String [] actual = outputStream.toString().split(" ");
        StringBuilder actual_message = new StringBuilder();
        for(int i = 4; i<actual.length; i++)
        {
            actual_message.append(actual[i]).append(" ");
        }

        Assert.assertEquals(name, actual[0].replace(":",""));
        Assert.assertEquals(++num, Integer.parseInt(actual[1]));
        Assert.assertTrue(LoggersTests.checkTime(actual[2]));
        Assert.assertEquals(ERROR, Integer.parseInt(actual[3].replace(":","")));
        Assert.assertEquals(message0, actual_message.toString().trim());

    }

    @Test
    public void testIsOutputMessageNameableLoggerINFO()
    {
        //имя логгера может быть только строкой без пробелов
        String name = "NameLogger";
        NameableLogger logger = new NameableLogger(INFO, name);
        int num = 0;
        logger.log(7, message1);
        String [] actual = outputStream.toString().split(" ");
        StringBuilder actual_message = new StringBuilder();
        for(int i = 4; i<actual.length; i++)
        {
            actual_message.append(actual[i]).append(" ");
        }

        Assert.assertEquals(name, actual[0].replace(":",""));
        Assert.assertEquals(++num, Integer.parseInt(actual[1]));
        Assert.assertTrue(LoggersTests.checkTime(actual[2]));
        Assert.assertEquals(INFO, Integer.parseInt(actual[3].replace(":","")));
        Assert.assertEquals(message1, actual_message.toString().trim());

    }

    @Test
    public void testIsOutputMessageNameableLoggerDEBUG()
    {
        //имя логгера может быть только строкой без пробелов
        String name = "NameLogger";
        NameableLogger logger = new NameableLogger(DEBUG, name);
        int num = 0;
        logger.log(17, message2);
        String [] actual = outputStream.toString().split(" ");
        StringBuilder actual_message = new StringBuilder();
        for(int i = 4; i<actual.length; i++)
        {
            actual_message.append(actual[i]).append(" ");
        }

        Assert.assertEquals(name, actual[0].replace(":",""));
        Assert.assertEquals(++num, Integer.parseInt(actual[1]));
        Assert.assertTrue(LoggersTests.checkTime(actual[2]));
        Assert.assertEquals(DEBUG, Integer.parseInt(actual[3].replace(":","")));
        Assert.assertEquals(message2, actual_message.toString().trim());

    }
    @Test
    public void testIsOutputMessageNameableLoggerEmpty()
    {
        //имя логгера может быть только строкой без пробелов
        String name = "NameLogger";
        NameableLogger logger = new NameableLogger(ERROR, name);
        logger.log(ERROR+1, message0);
        String actual = outputStream.toString();
        Assert.assertEquals("",actual);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionNameableLogger() {
        NameableLogger logger = new NameableLogger(DEBUG+1, "Logger");
    }


    /**
     * Tests for RepeatableLogger
     */
    @Test
    public void testIsOutputMessageRepeatableLoggerERROR()
    {
        int count = new Random().nextInt(10);
        RepeatableLogger logger = new RepeatableLogger(ERROR, count);
        int num = 0;
        logger.log(ERROR, message0);
        String[] actual_all = outputStream.toString().split("\n");
        for(int i = 0; i<count; i++)
        {
            String[] actual = actual_all[i].split(" ");
            StringBuilder actual_message = new StringBuilder();
            for (int j = 3; j < actual.length; j++) {
                actual_message.append(actual[j]).append(" ");
            }
            Assert.assertEquals(++num, Integer.parseInt(actual[0]));
            Assert.assertTrue(LoggersTests.checkTime(actual[1]));
            Assert.assertEquals(ERROR, Integer.parseInt(actual[2].replace(":", "")));
            Assert.assertEquals(message0, actual_message.toString().trim());
        }

    }
    @Test
    public void testIsOutputMessageRepeatableLoggerINFO()
    {
        int count = new Random().nextInt(10);
        RepeatableLogger logger = new RepeatableLogger(INFO, count);
        int num = 0;
        logger.log(6, message1);
        String[] actual_all = outputStream.toString().split("\n");
        for(int i = 0; i<count; i++)
        {
            String[] actual = actual_all[i].split(" ");
            StringBuilder actual_message = new StringBuilder();
            for (int j = 3; j < actual.length; j++) {
                actual_message.append(actual[j]).append(" ");
            }
            Assert.assertEquals(++num, Integer.parseInt(actual[0]));
            Assert.assertTrue(LoggersTests.checkTime(actual[1]));
            Assert.assertEquals(INFO, Integer.parseInt(actual[2].replace(":", "")));
            Assert.assertEquals(message1, actual_message.toString().trim());
        }

    }
    @Test
    public void testIsOutputMessageRepeatableLoggerDEBUG()
    {
        int count = new Random().nextInt(10);
        RepeatableLogger logger = new RepeatableLogger(DEBUG, count);
        int num = 0;
        logger.log(18, message2);
        String[] actual_all = outputStream.toString().split("\n");
        for(int i = 0; i<count; i++)
        {
            String[] actual = actual_all[i].split(" ");
            StringBuilder actual_message = new StringBuilder();
            for (int j = 3; j < actual.length; j++) {
                actual_message.append(actual[j]).append(" ");
            }
            Assert.assertEquals(++num, Integer.parseInt(actual[0]));
            Assert.assertTrue(LoggersTests.checkTime(actual[1]));
            Assert.assertEquals(DEBUG, Integer.parseInt(actual[2].replace(":", "")));
            Assert.assertEquals(message2, actual_message.toString().trim());
        }

    }
    @Test
    public void testIsOutputMessageRepeatableLoggerEmpty()
    {
        int count = new Random().nextInt(10);
        RepeatableLogger logger = new RepeatableLogger(ERROR, count);
        logger.log(ERROR+1, message0);
        String actual = outputStream.toString();
        Assert.assertEquals("",actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionRepeatableLogger() {
        RepeatableLogger logger = new RepeatableLogger(DEBUG+1, 10);
    }



    @After
    public void closeStream() throws IOException
    {
        outputStream.close();
    }


    public static boolean checkTime(String date) {
       try
       {

           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
           Date d = dateFormat.parse(date);
           return new Date().getTime() - d.getTime() < 20;
       }
       catch (ParseException ex)
       {
           return false;
       }
    }

}
