package org.centaurus.app.server;

public interface AppServer {
    void create();
    void configure();
    void start();
    void stop();
}
