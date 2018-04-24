package org.centaurus.app.server;

public class AppMain {
    public static void main(String[] args) throws Exception{
        AppServer appServer = new TomcatServer();
        appServer.create();
        appServer.configure();
        appServer.start();
    }
}
