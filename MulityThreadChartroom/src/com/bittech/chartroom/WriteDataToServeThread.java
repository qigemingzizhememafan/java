package com.bittech.chartroom;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

//客户端给服务端发送数据
public class WriteDataToServeThread extends Thread{
    private final Socket client;

    public WriteDataToServeThread(Socket client) {
        this.client = client;
    }
    public void run(){
        OutputStream clientOutput = null;
        try {
            clientOutput = this.client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.print("请输入>");
                String data = scanner.nextLine();
                writer.write(data+"\n");
                writer.flush();
                if(data.equals("bye")){
                    break;
                }
            }
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
