package com.lswq;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.DispatcherServlet;

public class Launcher {

    public static final int PORT = 8081;
    public static final String CONTEXT = "/";

    private static final String DEFAULT_WEBAPP_PATH = "src/main/resources";

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port, String contextPath) {
        Server server = new Server(port);
        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        WebAppContext webContext = new WebAppContext();
        webContext.setContextPath(contextPath);
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener();
        RequestContextListener requestContextListener = new RequestContextListener();
        
        webContext.setInitParameter("contextConfigLocation", "classpath*:application.xml");
        
        webContext.setResourceBase(DEFAULT_WEBAPP_PATH);
        
        webContext.addEventListener(contextLoaderListener);
        webContext.addEventListener(requestContextListener);

        ServletHolder holder = new ServletHolder(new DispatcherServlet());
        holder.setInitParameter("contextConfigLocation", "classpath:spring-mvc.xml");
        webContext.addServlet(holder, contextPath);
        
        server.setHandler(webContext);
        return server;
    }

    /**
     * 启动jetty服务
     *
     * @param port
     * @param context
     */
    public void startJetty(int port, String context) {
        final Server server = Launcher.createServerInSource(port, context);
        try {
            server.stop();
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new Launcher().startJetty(PORT, CONTEXT);
    }
}