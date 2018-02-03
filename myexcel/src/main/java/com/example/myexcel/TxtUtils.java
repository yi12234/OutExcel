package com.example.myexcel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.myexcel.Tools.getSDPath;

/**
 * @author : 繁华 .
 * @data : 2018/2/3,9:24;
 * @motto : 人生的烦恼，多在于知道的太多，而做的太少。
 * @explain :
 */
public class TxtUtils {
    /**
     　　* 保存文件
     　　* @param toSaveString
     　　* @param filePath
     　　*/


    public  static  void saveFile(String str){
        saveFile(str,getSDPath()+"/OutExcel/OutExcel.txt");
    }



    public static void saveFile(String str, String filePath) {
        try {
            File saveFile = new File(filePath);
            if (!saveFile.exists())
            {
                File dir = new File(saveFile.getParent());
                dir.mkdirs();
                saveFile.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(saveFile);
            outStream.write(str.getBytes());
            outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     　　* 读取文件内容
     　　* @param filePath
     　　* @return 文件内容
     　　*/
    public static String readFile(String filePath)
    {
        String str = "";
        try
        {
            File readFile = new File(filePath);
            if(!readFile.exists())
            {
                return null;
            }
            FileInputStream inStream = new FileInputStream(readFile);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = inStream.read(buffer)) != -1)
            {
                stream.write(buffer, 0, length);
            }
            str = stream.toString();
            stream.close();
            inStream.close();
            return str;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();return null;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
