package com.tutorials22.broadcastreceivers.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NormalBroadCastReceiver : BroadcastReceiver() {
//    the context is what we get when the process for
//    the application is created and its application context

//    For at least implicit broadcast receiver statically
//    registered we would have to run the app for at least once for the broadcast
//    receiver to be registered


    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED == intent?.action) {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show()
        }
        else if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent?.action)){
            Toast.makeText(context, "Connectivity change", Toast.LENGTH_SHORT).show()
        }
    }
}