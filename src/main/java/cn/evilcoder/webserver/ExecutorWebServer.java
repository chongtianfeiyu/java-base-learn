package cn.evilcoder.webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * User: Huangshanqi
 * Date: 2016/9/9
 * Time: 10:30
 * 使用Executors框架的webserver
 */
public class ExecutorWebServer {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExecutorWebServer.class);
    public static final int MAX_THREAD = 100;
    public static final Executor executor = Executors.newFixedThreadPool(MAX_THREAD);

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
            executor.execute(task);
        }
    }
}
