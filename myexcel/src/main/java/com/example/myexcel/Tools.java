package com.example.myexcel;

import android.os.Environment;

import java.io.File;

/**
 * @author : 繁华 .
 * @data : 2017/12/29,11:11;
 * @motto : 人生的烦恼，多在于知道的太多，而做的太少。
 * @explain :
 */
public class Tools {
      // ：创建文件
    public static void makeDir(File dir) {
        if(! dir.getParentFile().exists()) {
            makeDir(dir.getParentFile());
        }
        dir.mkdir();
    }
    //获取路径
    public static String getSDPath(){
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED); //判断sd卡是否存在
        if (sdCardExist)
        {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        String dir = sdDir.toString();
        return dir;

    }
}
