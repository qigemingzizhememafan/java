package com.lzl.client.single;

import java.io.*;
import  java.util.Scanner;
import java.net.Socket;

/**
 *  聊天室客户端程序
 */
public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        //0. 通过命令行获取服务器端口
        int port = 6666; // 默认端口号
        if(args.length > 0){
            try{
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                System.out.println("端口参数不正确，采用默认端口:"+port);
            }
        }
        String host = "127.0.0.1"; //默认地址
        if(args.length > 1){
            host = args[1];
            // host格式校验
        }
        //1. 创建客户端连接
        Socket clientSocket = new Socket(host,port);
        // 2. 发送数据，接收数据
        // 2.1 发送数据
        OutputStream clientOutput = clientSocket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
        writer.write("hi,i am client\n");
        // 传输过程中报文被分包处理，到客户端再组装起来，但是系统不会帮我们自动刷新
        // 也可以将 OutputStreamWriter 改为 PrintStream(提供自动刷新)
        // private PrintStream(boolean autoFlush, OutputStream out)
        writer.flush();
        // 2.2 接收数据
        InputStream clientInput = clientSocket.getInputStream();
        Scanner scanner = new java.util.Scanner(clientInput);
        String serverDate = scanner.nextLine();
        System.out.println("来自服务端的数据："+serverDate);
        // 3. 客户端关闭流 clientOutput和clientInput可以不用关，因为他们来自clientSocket
        clientOutput.close();
        clientInput.close();
        clientSocket.close();
        System.out.println("客户端已关闭");
    }
}
