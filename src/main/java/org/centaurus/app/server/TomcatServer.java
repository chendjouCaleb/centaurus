package org.centaurus.app.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer implements AppServer {

    private static final int PORT = 9000;
    private static String dir = "src/main/webapp/";
    private Tomcat tomcat;

    @Override
    public void create() {
        tomcat = new Tomcat();
    }

    @Override
    public void configure(){
        tomcat.setPort(PORT);
        Context context = null;
        try {
            context = tomcat.addWebapp("/", new File(dir).getAbsolutePath());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        File classDir = new File("out/production/classes");
        WebResourceRoot resourceRoot = new StandardRoot(context);
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes", classDir.getAbsolutePath(), "/" ));

        context.setResources(resourceRoot);
    }

    @Override
    public void start(){
        tomcat.getConnector();
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        //logger.info("Server started with port {}", PORT);
        tomcat.getServer().await();
    }

    @Override
    public void stop(){
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
