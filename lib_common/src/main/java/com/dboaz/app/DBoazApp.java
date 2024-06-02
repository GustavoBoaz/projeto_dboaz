package com.dboaz.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.utils.notations.DBoazBootApp;

public class DBoazApp {
    private static final Logger LOGGER = LogManager.getLogger(DBoazApp.class);
    
    public static void run(Class<?> clazz, String[] args) {
        readInfoApp(clazz, args);
        readArgs(args);
    }

    protected static void readInfoApp(Class<?> clazz, String[] args) {
        DBoazBootApp annotation = clazz.getAnnotation(DBoazBootApp.class);
        LOGGER.info("| RUN APP: {} | VERSION: {} | VERSION DATE: {} | RELEASE: {} |",  annotation.name(),  annotation.version(), annotation.date(), annotation.release());
    }

    protected static void readArgs(String[] args) {
        for (String arg : args) { LOGGER.info(arg); }
    }
}
