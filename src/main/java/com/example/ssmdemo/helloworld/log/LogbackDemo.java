package com.example.ssmdemo.helloworld.log;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cph
 * @date 2019/9/18
 */
public class LogbackDemo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("com.example.ssmdemo.helloworld.log.LogbackDemo");
        logger.debug("hello, logback!");

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        lc.setPackagingDataEnabled(true);
        StatusPrinter.print(lc);
    }
}
