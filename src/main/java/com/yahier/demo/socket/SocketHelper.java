package com.yahier.demo.socket;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * Socket通信Server端
 * issue 1.多个箱子对应多个不同的ip,每个箱子有自己的socket ?【我发觉，可以共用一个socket】
 */
public class SocketHelper {
    private final static String TAG = "SocketHelper";
    private static DatagramSocket socket;
    private static volatile boolean isWorking = true;
    private static final int port = 8080;
    private static SocketAddress senderAddress;

    public static void startLoop() {
        init();
        new Thread(() -> {
            while (isWorking) {
                receive();
                send();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void init() {
        isWorking = true;
        InetSocketAddress address = new InetSocketAddress(port);
        try {
            socket = new DatagramSocket(address);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    private static void receive() {
        byte[] buffer = new byte[40];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);//这个方法是阻塞的
            senderAddress = packet.getSocketAddress();
            int length = packet.getLength();
            log(TAG, "收到的数据长度是:" + length);
            byte[] data = new byte[length];
            System.arraycopy(buffer, 0, data, 0, data.length);
            log(TAG, "收到的数据是:" + Arrays.toString(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void send() {
        byte[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        DatagramPacket packet = new DatagramPacket(data, data.length, senderAddress);
        try {
            socket.send(packet);//java.lang.NullPointerException: null buffer || null address
            log(TAG, "send 数据发送成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        isWorking = false;
        if (socket != null && !socket.isClosed())
            socket.close();
    }


    private static void log(String tag, String msg) {
        System.out.println(tag + "   " + msg);
    }

}
