package chartRoomMulityThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerClient implements Runnable {
    private static final Map<String,Socket> ONLINE_CLIENT_Map =
                                    new ConcurrentHashMap<>();
    private final Socket client;

    public HandlerClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream clientInput = client.getInputStream();
            Scanner scanner = new Scanner(clientInput);
            while(true){
                String data = scanner.nextLine();
                //注册
                if(data.startsWith("register:")){
                    String userName = data.split(":")[1];
                    register(userName);
                    continue;
                }
                if(data.startsWith("groupChat:")){
                    String message = data.split(":")[1];
                    groupChat(message);
                    continue;
                }
                if(data.startsWith("privateChat")){
                    String[] segments = data.split(":");
                    String targetUserName = segments[1];
                    String message = segments[2];
                    privateChat(targetUserName,message);
                    continue;
                }
                //退出
                if(data.equals("bye")){
                    bye();
                    continue;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //注册
    private void register(String userName){
        ONLINE_CLIENT_Map.put(userName,this.client);
        printOnlineClient();
        this.sendMessage(this.client,"恭喜"+userName+"注册成功",false);
    }
    //打印当前在线人数
    private void printOnlineClient(){
        System.out.println("当前在线人数："+ONLINE_CLIENT_Map.size()+
                            "用户名如下：");
        for(String userName:ONLINE_CLIENT_Map.keySet()){
            System.out.println(userName);
        }
    }
    //群聊
    private void groupChat(String message){
        for(Map.Entry<String,Socket> entry:ONLINE_CLIENT_Map.entrySet()){
            Socket target = entry.getValue();
            if(target.equals(this.client)){
                continue;
            }
            this.sendMessage(target,message,true);
        }
    }
    private String getCurrentUserName(){
        for(Map.Entry<String,Socket> entry:ONLINE_CLIENT_Map.entrySet()){
            Socket target = entry.getValue();
            if(target.equals(this.client)){
                return entry.getKey();
            }
        }
        return " ";
    }
    //私聊
    private void privateChat(String targetUserName,String message){
             Socket target = ONLINE_CLIENT_Map.get(targetUserName);
             if(target == null){
                 this.sendMessage(client,"用户不存在"+targetUserName,false);
             }else{
                 String currentUserName = this.getCurrentUserName();
                 this.sendMessage(target,"<"+currentUserName+":"+message,true);
             }
    }
    //退出
    private void bye() {
          for(Map.Entry<String,Socket> entry:ONLINE_CLIENT_Map.entrySet()){
              Socket target = entry.getValue();
              if(target.equals(this.client)){
                  ONLINE_CLIENT_Map.remove(entry.getKey());
                  break;
              }
          }
    }

    private void sendMessage(Socket target,String message,boolean prefix){
        String currentUserName = this.getCurrentUserName();
        OutputStream clientOutput = null;
        try {
            clientOutput = target.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            if(prefix) {
                writer.write("" + currentUserName + ":" + message + "\n");
            }else {
                    writer.write(message+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
