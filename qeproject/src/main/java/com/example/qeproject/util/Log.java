package com.example.qeproject.util;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Example:
 * <pre>
 *         // This is to show log levels, from TRACE to ERROR
 *         Logger logger = Log.getLogger();
 *         logger.trace("A TRACE Message");
 *         logger.debug("A DEBUG Message");
 *         logger.info("An INFO Message");
 *         logger.warn("A WARN Message");
 *         logger.error("An ERROR Message");
 * </pre>
 * <pre>
 *          // Typical logging usage is added in this class as convenience methods.
 *          // Reason for this is that we can a) switch transparently to another logger
 *          // and b) we can add features (such as custom stack trace logging)
 *          Log.warn("message");
 *          Log.error("message");
 *          ...
 * </pre>
 */
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
