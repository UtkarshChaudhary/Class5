package com.example.lenovo.class5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.style.TtsSpan;
import android.util.Log;

public class MyReceiver2 extends BroadcastReceiver {
    static String previousState=TelephonyManager.EXTRA_STATE_IDLE;//since this func. is called when every time phone rings so it has to be static to store previous state and every time its new object will be created
    @Override
    public void onReceive(Context context, Intent intent) {


        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String phone_state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)) {//getStringExtra gives string of phoneState Call_State_IDLE is state
           //EXTRA_STATE and EXTRA_STATE_IDLE are static constants in TelephonyManager Class
            Log.i("state log ","IDLE STATE");
            if(previousState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                Intent i=new Intent(context,MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }

        }else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {//getStringExtra gives string of phoneState CALL_STATE_IDLE is state
            //EXTRA_STATE and EXTRA_STATE_IDLE are static constants in TelephonyManager Class
            Log.i("state log ","Ringing STATE");

        }else if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)){
              Intent i=new Intent(context,MainActivity.class);
            Log.i("state log ","OFFHOOK STATE");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        previousState=phone_state;
    }
}
