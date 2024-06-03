package com.dboaz.app;

import java.lang.annotation.Annotation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.server.Server;
import com.dboaz.utils.enums.SeverityEnum;
import com.dboaz.utils.errors.GenericException;
import com.dboaz.utils.notations.DBoazBootApp;
import com.dboaz.utils.notations.DBoazBootServer;

public class DBoazApp {
    private static final Logger LOGGER = LogManager.getLogger(DBoazApp.class);

    private Server server;

    protected DBoazApp() {}

    protected DBoazApp(Builder builder) {
        this.server = builder.server;
    }

    protected static class Builder {
        private Server server;

        public DBoazApp build() {
            return new DBoazApp(this);
        }

        public Builder server(Integer port) {
            this.server = new Server(port);
            return this;
        }
    }
    
    public static DBoazApp run(Class<?> clazz, String[] args) {
        readInfoApp(clazz, args);

        if(hasAnnotation(clazz, DBoazBootServer.class)) {
            return new Builder().server(readInfoServer(clazz, args)).build();
        }

        return new DBoazApp();
    }

    public Server server() {
        if (server == null) {
            throw new GenericException("Error [ DBoazBootServer annotation is missing ]", SeverityEnum.SEV_001, 500);
        }
        return server;
    }

    protected static void readInfoApp(Class<?> clazz, String[] args) {
        DBoazBootApp annotation = clazz.getAnnotation(DBoazBootApp.class);
        if (annotation != null) {
            LOGGER.info("| RUN APP: {} | VERSION: {} | VERSION DATE: {} | RELEASE: {} |",  annotation.name(),  annotation.version(), annotation.date(), annotation.release());
        } else {
            throw new GenericException("Error [ DBoazBootApp annotation is missing ]", SeverityEnum.SEV_001, 500);
        }
    }

    protected static Integer readInfoServer(Class<?> clazz, String[] args) {
        DBoazBootServer annotation = clazz.getAnnotation(DBoazBootServer.class);
        LOGGER.info("| SERVER PORT: {} |",  annotation.port());
        return Integer.parseInt(annotation.port());
    }

    protected static boolean hasAnnotation(Class<?> clazz, Class<? extends Annotation> annotation) {
        return clazz.isAnnotationPresent(annotation);
    }
}
