package cn.evilcoder.webserver;

import java.net.Socket;

/**
 * User: Huangshanqi
 * Date: 2016/9/9
 * Time: 10:21
 */
public class Handler {

    public static void handleSocket(Socket socket) {
        System.out.println("handlering socket " + socket);
    }
}
