package vip.wulang.test.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8080);

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
    }
}
