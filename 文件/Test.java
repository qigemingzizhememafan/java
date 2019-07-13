package com.lzl;

import java.io.File;
import java.io.IOException;
//        File file = new File("C:"+File.separator+"Users"+File.separator+"Administrator"+
//                    File.separator+"Desktop");
//        if(file.exists()&&file.isDirectory()){
//            //列出目录中的全部内容
//            File[] listfile = file.listFiles();
//            for(File file2:listfile){
//                System.out.println(file2);
//            }
//        }
//        if(file.exists()&&file.isFile()){
//            System.out.println(file.length()/1024); //文件大小
//            System.out.println(file.lastModified()); //文件最后一次修改时间
//        }
//    }
//}
//        File file = new File("C:" + File.separator + "Users" + File.separator
//                + "Administrator" + File.separator + "Desktop" + File.separator
//                + "www" + File.separator + "bit" + File.separator + "java" + File.separator
//                + "javaIO.txt" + File.separator);
//        System.out.println(file);
//        //取得父文件对象
//        File parentFile = file.getParentFile();
//        if (!parentFile.exists()) {
//            parentFile.mkdirs();
//        }
//        // 就是看java.io是否存在
//        if (file.exists()) {
//            file.delete();
//        } else {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(file.getParent());//获取父路径
//    }
//}
//        if(file.exists()){
//            System.out.println("文件删除开始");
//            file.delete();
//            System.out.println("文件删除结束");
//        }else{
//            try {
//                System.out.println("文件不存在，创建文件开始");
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("创建文件完成");
//        }
//        try {
//            // 创建文件
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File file1 = new File("C:\\Users\\Administrator\\Desktop\\test1.txt");//此时输出为文件存在
//        if(file1.exists()){
//            System.out.println("文件存在"); //file即可指文件本身，也能指文件路径，此时存在
//        }else{
//            System.out.println("文件不存在");
//        }


