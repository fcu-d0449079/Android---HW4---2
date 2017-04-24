package com.example.zhuang.broad;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class BR_S extends AppCompatActivity {
    LocalBroadcastManager lbm;
    SelfRec receiver;
    public static final String ACTION = "zhuang.BroadRec";

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(rec_notification);
        editText = (EditText)findViewById(R.id.editText);

    }

    private OnClickListener rec_notification = new OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction("zhuang.BroadRec");
            String msg = editText.getEditableText().toString();
            intent.putExtra("KEY_MSG",msg);
            sendBroadcast(intent);
            lbm.sendBroadcast(intent);
        }
    };
    @Override
    public void onResume(){
        super.onResume();
        receiver = new SelfRec();
        lbm = LocalBroadcastManager.getInstance(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION);
        lbm.registerReceiver(receiver,filter);
    }

    @Override
    public void onPause() {
        super.onPause();
        lbm.unregisterReceiver(receiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
}
