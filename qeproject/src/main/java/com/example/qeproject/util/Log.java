package com.example.qeproject.util;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Log
{
    private static Logger logger = LoggerFactory.getLogger("numberService");

    public static Logger getLogger()
    {
        return logger;
    }

    public static void warn(String msg)
    {
        logger.warn(msg);
    }

    public static void trace(String msg)
    {
        logger.trace(msg);
    }

    public static void debug(String msg)
    {
        logger.debug(msg);
    }

    public static void info(String msg)
    {
        logger.info(msg);
    }

    public static void error(String msg)
    {
        logger.error(msg);
    }
}
