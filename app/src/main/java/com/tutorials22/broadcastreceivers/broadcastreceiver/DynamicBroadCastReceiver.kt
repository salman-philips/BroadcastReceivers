package com.tutorials22.broadcastreceivers.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.widget.Toast


class DynamicBroadCastReceiver : BroadcastReceiver() {
//    the context is what we get when the process for
//    the application is created and its application context


    override fun onReceive(context: Context?, intent: Intent?) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent?.action)) {
            val isConnected =
                (intent?.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO) as NetworkInfo?)?.isConnected
            if (isConnected == true) {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show()
            } else if (isConnected == false) {
                Toast.makeText(context, "DisConnected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}