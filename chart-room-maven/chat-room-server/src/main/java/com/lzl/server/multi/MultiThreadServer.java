package com.lzl.server.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    public static void main(String[] args) {
        // 1.创建线程池
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("等待客户端连接");
            while(true){
                Socket client = serverSocket.accept();
                // 任务：处理注册 私聊 群聊
                executorService.submit(new ExecuteClient(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
