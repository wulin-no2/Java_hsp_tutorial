package assignment;

import java.io.IOException;
import java.net.*;

public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        System.out.println("I am waiting..");

        // receive;
        byte[] bytesR = new byte[1024];
        DatagramPacket datagramPacketR = new DatagramPacket(bytesR,  bytesR.length);
        datagramSocket.receive(datagramPacketR);

        // unwrapped it;
        System.out.println("The question is: ");
        String question;
        System.out.println(question = new String(datagramPacketR.getData(),0, datagramPacketR.getLength()));


        // reply;
        byte[] bytes = null;

        if (question.equals("what are Big4 literatures in China?")){
            bytes = "Journey to west, Stone, Three countries, Shui Hu".getBytes();
        }else {
            bytes = "What are you talking about?".getBytes();
        }
        int byteLen = bytes.length;
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, byteLen, InetAddress.getLocalHost(), 9999);

        datagramSocket.send(datagramPacket);
        System.out.println("I've replied;");

        // close all
        datagramSocket.close();
    }
}