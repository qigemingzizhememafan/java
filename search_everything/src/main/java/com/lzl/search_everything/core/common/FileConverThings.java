package com.lzl.search_everything.core.common;

import com.lzl.search_everything.core.model.FileType;
import com.lzl.search_everything.core.model.Things;
import java.io.File;

/**
 * 辅助工具类，将File对象转化为Things对象
 */
public final class FileConverThings {
    private FileConverThings(){}
    public static Things convert(File file){
        Things things = new Things();
        things.setName(file.getName());
        //things.setPath(file.getPath()); 也可以用这个
        things.setPath(file.getAbsolutePath());
        things.setDepth(computerFileDepth(file));
        things.setFileType(computerFileType(file));
        return things;
    }

    // 获取文件深度
    private static int computerFileDepth(File file){
        int depth = 0;
        // 这里用file.getAbsolutePath().split(File.seperator())会出错
        String[] segment = file.getAbsolutePath().split("\\\\");
        depth = segment.length;
        return  depth;
    }

    // 获取文件类型
    private static FileType computerFileType(File file){
        if(file.isDirectory()){
            return FileType.OTHER;
        }
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        // index < fileName.length()-1为了防止abc.这种截取后越界的产生
        if(index != -1 && index < fileName.length()-1){
            String extend = fileName.substring(index+1);
            return FileType.lookupFileType(extend);
        }else{
            return FileType.OTHER;
        }
    }
}
