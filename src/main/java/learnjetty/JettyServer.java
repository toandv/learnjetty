package learnjetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 * Created by toan on 3/3/17.
 */
public class JettyServer {

    public static void main(String[] args) throws Exception {

        // Day la cai web server, nhan request xong response lai
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        server.setHandler(new AbstractHandler() {
            @Override
            public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
                Writer out = httpServletResponse.getWriter();
                // go cai nay vao trinh duyet localhost:8080
                // se thay dong nay in ra
                out.write("Hello from Jetty, this time is : " + new Date());
                out.flush();
            }
        });
        server.start();
        server.join();
    }

}

