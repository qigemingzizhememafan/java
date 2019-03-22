package com.bittech.chartroom;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReadDataFromServerThread extends Thread {
    private final Socket client;
    public ReadDataFromServerThread(Socket client){
        this.client = client;
    }
    public void run(){
        InputStream clientInput = null;
        try {
            clientInput = this.client.getInputStream();
            Scanner scanner = new Scanner(clientInput);
            while(true){
                String data = scanner.nextLine();
                System.out.println("来自服务器的消息："+data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
