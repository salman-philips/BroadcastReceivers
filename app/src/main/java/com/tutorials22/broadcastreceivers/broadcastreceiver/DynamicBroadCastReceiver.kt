package com.tutorials22.broadcastreceivers.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class DynamicBroadCastReceiver : BroadcastReceiver() {
//    the context is what we get when the process for
//    the application is created and its application context

//    The next appropriate broadcast receiver to be discussed is time tick switch
//    it gets activated every minute the one difference between the connectivity
//    base broadcast listener and the time tick basically broadcast listener was
//    there was no invocation when you kill and relaunch the app

    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_TIME_TICK.equals(intent?.action)) {
            Toast.makeText(context, "Time tick", Toast.LENGTH_SHORT).show()
        }
    }
}