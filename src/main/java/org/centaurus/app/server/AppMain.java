package org.centaurus.app.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppMain {
    private static Logger logger = LoggerFactory.getLogger(AppMain.class);
    public static void main(String[] args) throws Exception{

        logger.info("Welcome to main class");
        AppServer appServer = new TomcatServer();
        appServer.create();
        appServer.configure();
        appServer.start();
    }
}
