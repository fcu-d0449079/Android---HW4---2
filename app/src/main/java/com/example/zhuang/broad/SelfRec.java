package com.example.zhuang.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Zhuang on 2017/4/23.
 */

public class SelfRec extends BroadcastReceiver{
    public void onReceive(Context context, Intent intent){
        String msg = intent.getStringExtra("KEY_MSG");
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

}
