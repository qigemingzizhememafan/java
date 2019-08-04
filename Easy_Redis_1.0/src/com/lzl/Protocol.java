package com.lzl;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.util.ArrayList;
import java.util.List;

public class Protocol {
    public static Object process(ByteInputStream byteInputStream){
        int b = byteInputStream.read();
        if (b == -1) {
            throw new RuntimeException("不应该读到结尾的");
        }
        switch (b) {
            case '+':
                return processString(byteInputStream);
            case '-':
                throw new RuntimeException("_WRONGTYPE Operation against a key holding the wrong kind of value");
            case ':':
                return processInteger(byteInputStream);
            case '$':
                return processByteArray(byteInputStream);
            case '*':
                return processList(byteInputStream);
            default:
                throw new RuntimeException("不识别的类型");
        }
    }

    private static List<?> processList(ByteInputStream byteInputStream) {
        int len = (int) processInteger(byteInputStream);
        List<Object> list = new ArrayList<>();
        if(len == -1){
            return  list;
        }
        list = new ArrayList<>(len);
        for(int i = 0; i < len; i++){
            list.add(process(byteInputStream));
        }
        return list;
    }

    private static byte[] processByteArray(ByteInputStream byteInputStream) {
        int len = (int)processInteger(byteInputStream);
        byte[] data = new byte[]{};
        if(len == -1){
            return data;
        }
        data = new byte[len];
        for(int i = 0; i < len; i++){
            data[i] = (byte)byteInputStream.read();
        }
        System.out.println(new String(data));
        return data;
    }

    private static String processString(ByteInputStream byteInputStream) {
        StringBuilder sb = new StringBuilder();
        while(true){
            int b = byteInputStream.read();
            if(b == -1){
                throw new RuntimeException("非法开始，不应该读到结尾");
            }
            if(b == '\r'){
                int c = byteInputStream.read();
                if(c == -1){
                    throw new RuntimeException("不应该读到结尾");
                }
                if(c == '\n'){
                    break;
                }
                if(c == '\r'){
                    sb.append((char)b);
                    b = c;
                    c = byteInputStream.read();
                }else{
                    sb.append((char)b);
                    sb.append((char)c);
                }

            }else{
                sb.append((char)b);
            }
        }
        return sb.toString();
    }


    private static long processInteger(ByteInputStream byteInputStream) {
//        int c = byteInputStream.read();
//        StringBuilder sb = new StringBuilder();
//        if(c == -1){
//            throw new RuntimeException("非法开始，不应该读到结尾");
//        }
//        while(c != -1){
//            int innertemp = byteInputStream.read();
//            // 读到\r\n就要结束
//            // 只读到\r却没有读到\n，说明输入有误，抛出异常
//            if(innertemp == '\r'){
//                int next = byteInputStream.read();
//                if(next == '\n'){
//                    break;
//                }else{
//                    throw new RuntimeException("没有读到\r\n，无法判断是否读取结束");
//                }
//             // 没有读到/r，将该数字加入到StringBuilder中
//            }else{
//                sb.append(innertemp);
//            }
//            c = byteInputStream.read();
//        }
//        return Long.parseLong(sb.toString());
//    }
        int b = byteInputStream.read();
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder();
        if (b == -1) {
            throw new RuntimeException("不应该读到结尾");
        }
        if (b == '-') {
            isNegative = true;
        } else {
            sb.append((char)b);
        }

        while (true) {
            b = byteInputStream.read();
            if (b == -1) {
                throw new RuntimeException("不应该读到结尾的");
            }

            if (b == '\r') {
                int c = byteInputStream.read();
                if (c == -1) {
                    throw new RuntimeException("不应该读到结尾的");
                }
                if (c == '\n') {
                    break;
                }
                throw new RuntimeException("没有读到\\r\\n");
            } else {
                sb.append((char)b);
            }
        }
        long v = Long.parseLong(sb.toString());
        if (isNegative) {
            v = -v;
        }
        return v;
    }
}
