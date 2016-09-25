package cn.evilcoder.webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Huangshanqi
 * Date: 2016/9/9
 * Time: 10:26
 * 无限线程的webserver，过多的请求会使系统崩溃
 */
public class UnlimitThreadWebServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnlimitThreadWebServer.class);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        LOGGER.info("webserver starting....");
        while (true) {

            final Socket socket = serverSocket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    Handler.handleSocket(socket);
                }
            };
            new Thread(task).start();
        }
    }
}
