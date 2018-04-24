package org.centaurus.app.server;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class TomcatServerMain {
        private static final int PORT = 9000;
        static String dir = "src/main/webapp/";
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);


        Context context = tomcat.addWebapp("/", new File(dir).getAbsolutePath());
        File classDir = new File("out/production/classes");
        WebResourceRoot resourceRoot = new StandardRoot(context);
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes", classDir.getAbsolutePath(), "/" ));

        context.setResources(resourceRoot);

        tomcat.getConnector();
        tomcat.start();
        //logger.info("Server started with port {}", PORT);
        tomcat.getServer().await();


    }
}
