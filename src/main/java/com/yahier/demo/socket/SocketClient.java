package com.yahier.demo.socket;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Socket客户端
 */
public class SocketClient {
    private static String TAG = "SocketClient";
    private static String IP = "10.101.9.17";
    private static int port = 8080;
    private static DatagramSocket socket;
    private static int sendTimes = 0;
    private static int readTimes = 0;
    private static boolean isWorking = true;

    public static void init() {
        try {
            socket = new DatagramSocket();
            socket.setSoTimeout(1000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            while (isWorking) {
                send();
                read();
            }
        }).start();
    }


    private static void send() {
        byte[] buffer = {12, 34, 56, 78, 90};
        DatagramPacket packet;
        try {
            packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(IP), port);
            try {
                socket.send(packet);//发送信息包
                sendTimes++;
                log(TAG, "发送成功:" + sendTimes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    private static void read() {
        byte[] buffer = new byte[40];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
            readTimes++;
            int size = packet.getLength();
            log(TAG, "读到数据长度是:" + size);
            byte[] data = new byte[size];
            System.arraycopy(buffer, 0, data, 0, data.length);
            log(TAG, "读到的数据是:" + Arrays.toString(data) + " readTimes:" + readTimes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void log(String tag, String msg) {
        System.out.println(tag + "   " + msg);
    }
}
