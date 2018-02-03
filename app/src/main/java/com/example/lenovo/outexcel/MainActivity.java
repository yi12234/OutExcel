package com.example.lenovo.outexcel;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myexcel.BaseExcel;
import com.example.myexcel.TxtUtils;

import java.util.ArrayList;

import static com.example.myexcel.Tools.getSDPath;


public class MainActivity extends Activity implements View.OnClickListener{

    private EditText ed_name;
    private Button btn_save;


    private static String[] title = { "编号" ,"名称"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        initClick();
    }

    private void findId() {
        ed_name = findViewById(R.id.ed_name);
        btn_save = findViewById(R.id.btn_save);
    }

    private void initClick() {
        btn_save.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:

                initData();
            default:
                break;
        }
    }

    private void initData() {
        TxtUtils.saveFile(ed_name.getText().toString().trim());
    }
//    public void initData(){
//        BaseExcel.BaseExcel(title,getSDPath()+"/OutExcel",
//                getSDPath()+"/OutExcel/excel.xls","excel",getRecordData(),this);
//    }

//
//    /**
//     * 将数据集合 转化成ArrayList<ArrayList<String>>
//     * @return
//     */
//    private  ArrayList<ArrayList<String>> getRecordData() {
//        ArrayList<ArrayList<String>>  recordList = new ArrayList<>();
//        for (int i = 0; i <10; i++) {
//            ArrayList<String> beanList = new ArrayList<String>();
//            beanList.add(ed_name.getText().toString());
//            beanList.add("123123");
//            recordList.add(beanList);
//        }
//        return recordList;
//    }
}
