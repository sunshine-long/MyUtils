package com.unht.myutils.myutils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;

/**
 * 监听应用程序的安装/卸载/和更新
 * @author Marlon
 * @desc
 * @date 2018/9/3
 */
public class AppReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //安装广播
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String packageName = intent.getDataString();
            Toast.makeText(context, "安装了应用："+packageName, Toast.LENGTH_SHORT).show();
        }
        //卸载广播
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            String packageName = intent.getDataString();
            if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                File file = CommonUtils.createImageFile("","");
                CommonUtils.deleteAllFiles(file);
            }
            Toast.makeText(context, "卸载了应用："+packageName, Toast.LENGTH_SHORT).show();
        }
        //覆盖安装广播
        if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
            String packageName = intent.getDataString();
            Toast.makeText(context, "应用更新成功："+packageName, Toast.LENGTH_SHORT).show();
        }
    }
}