package com.lzl.mySearchEverything.core.common;

import com.lzl.mySearchEverything.core.model.FileType;
import com.lzl.mySearchEverything.core.model.Thing;

import java.io.File;

/**
 *  辅助工具类，把File类转成Thing
 */
public class FileCoverThing {
    private FileCoverThing(){
    }

    public Thing fileCoverThing(File file){
        Thing thing = new Thing();
        thing.setName(file.getName());
        thing.setPath(file.getAbsolutePath());
        thing.setDepth(getFileDepth(file));
        thing.setFileType(getFileFileType(file));
        return thing;
    }

    private int getFileDepth(File file) {
        String[] filePart = file.getAbsolutePath().split("\\\\");
        return filePart.length;
    }

    private static FileType getFileFileType(File file) {
        if (file.isDirectory()) {
            return FileType.OTHER;
        }
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        if (index != -1 && index < fileName.length() - 1) {
            //abc.
            String extend = fileName.substring(index + 1);
            return FileType.lookupTypeByExtend(extend);
        } else {
            return FileType.OTHER;
        }
    }

}
