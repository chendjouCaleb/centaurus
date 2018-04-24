package org.centaurus.app.server;

import org.centaurus.app.servlet.Home;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public class JettyServer {
    private static final String WEB_APP_RESOURCES_LOCATION = "/src/main/webapp/";

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[] {connector});

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(Home.class, "/home");

        server.setHandler(servletHandler);

        WebAppContext context = new WebAppContext();
        URL webAppDir = Thread.currentThread().getContextClassLoader().getResource(WEB_APP_RESOURCES_LOCATION);
        Path webrootPath = new File("src/main").toPath().toRealPath();

        context.setContextPath("/");
        context.setDescriptor(WEB_APP_RESOURCES_LOCATION + "/WEB-INF/web.xml");
        context.setResourceBase(webAppDir.toURI().toString());
        context.setParentLoaderPriority(true);

        server.setHandler(context);
        server.start();
    }
}
