package com.lzl;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class Main {
    public static void main(String[] args) {
//        String message = ":1000\r\n";
//!!!       String message = "+Op\rapsOK\r\r\n";
//!!!      String message = "+Op\rapsOK\r\n";
//         String message = "$6\r\nfoobar\r\n";
// !!!foo        String message = "*2\r\n$3\r\nfoo\r\n$3\r\nbar\r\n";
        String message = ":90\r\n";
        ByteInputStream byteInputStream = new ByteInputStream(message.getBytes(),message.getBytes().length);
        System.out.println(Protocol.process(byteInputStream));
    }
}
