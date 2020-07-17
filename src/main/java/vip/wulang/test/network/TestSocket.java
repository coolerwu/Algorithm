package vip.wulang.test.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestSocket {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedTransferQueue<>(), r -> {
                    Thread thread = new Thread(r);
                    thread.setDaemon(false);
                    return thread;
                });
        executor.execute(TestSocket::start);
        executor.execute(TestSocket::start);
        executor.execute(TestSocket::start);
        executor.execute(TestSocket::start);
        executor.execute(TestSocket::start);
    }

    private static void start() {
        try {
            ServerSocket ss = new ServerSocket(8080);
//            ss.setOption(StandardSocketOptions.SO_REUSEPORT, true);

            while (true) {
                Socket accept = ss.accept();
                new Thread(() -> {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                        String str;
                        while ((str = br.readLine()) != null) {
                            System.out.println(str);
                        }
                    } catch (Exception e) {

                    }
                }).start();
            }
        } catch (Exception e) {

        }
    }
}
