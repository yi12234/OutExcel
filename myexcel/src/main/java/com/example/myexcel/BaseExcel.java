package com.example.myexcel;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

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
    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE };

    public static void BaseExcel(String[]title, String filepath, String fileName, String sheetName, ArrayList<ArrayList<String>> data, Activity activity) {

        /**
         8      * Checks if the app has permission to write to device storage
         9      *
         10      * If the app does not has permission then the user will be prompted to
         11      * grant permissions
         12      *
         13      * @param activity
         14      */
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
        File file = new File(filepath);
        makeDir(file);
        ExcelUtils.initExcel(fileName,sheetName, title);
        ExcelUtils.writeObjListToExcel(data, fileName, activity);
    }
}
