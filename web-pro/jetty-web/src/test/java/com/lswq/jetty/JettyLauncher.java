package com.lswq.jetty;

import org.eclipse.jetty.server.Server;
import org.junit.Test;

public class JettyLauncher {
    
    private static final int port = 8081;
    
    @Test
    public void jettyStart() throws Exception {
        Server server = new Server(port);
        server.start();
        server.join();
    }
    
}
