package com.example.lenovo.class5;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    Button button;
    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toast.makeText(this,"call disconnected  ",Toast.LENGTH_SHORT).show();
        EditText editText=(EditText)findViewById(R.id.editText);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        //to generate receivers

        Intent i=new Intent();
        i.setAction("demo");
        sendBroadcast(i);//to generate or broadcast receiver of demo type,it is global broadcast so another app who wants to receive demo type broadcast will also be notify

        LocalBroadcastManager.getInstance(this).sendBroadcast(i);//to generate local broadcast to be received only inside app
    }

    @Override
    protected void onResume() {
        receiver=new MyReceiver();
        IntentFilter i=new IntentFilter("demo");//IntentFilter is used to match intent to particular type i.e demo here
        //if we want to register against call then put Intent.ACTION_CALL
        registerReceiver(receiver,i);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
     Toast.makeText(this,""+editText.getText().toString(),Toast.LENGTH_SHORT).show();
    }
}
