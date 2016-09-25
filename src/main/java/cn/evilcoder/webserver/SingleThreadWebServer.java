package cn.evilcoder.webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Huangshanqi
 * Date: 2016/9/9
 * Time: 10:19
 * 阻塞式单线程webserver
 */
public class SingleThreadWebServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadWebServer.class);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        LOGGER.info("webserver starting....");
        while (true) {
            Socket socket = serverSocket.accept();
            Handler.handleSocket(socket);
        }
    }
}
