package com.example.myexcel;

import android.app.Activity;

import com.example.myexcel.ExcelUtils;

import java.io.File;
import java.util.ArrayList;

import static com.example.myexcel.Tools.getSDPath;
import static com.example.myexcel.Tools.makeDir;

/**
 * @author : 繁华 .
 * @data : 2017/12/29,10:43;
 * @motto : 人生的烦恼，多在于知道的太多，而做的太少。
 * @explain :
 */
public abstract class BaseExcel {

    public static void BaseExcel(String[]title, String filepath, String fileName, String sheetName, ArrayList<ArrayList<String>> data, Activity activity) {
       File file = new File(filepath);
       makeDir(file);
        ExcelUtils.initExcel(fileName,sheetName, title);
        ExcelUtils.writeObjListToExcel(data, fileName, activity);
    }
}
