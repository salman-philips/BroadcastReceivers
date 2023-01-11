package com.tutorials22.broadcastreceivers.ui

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tutorials22.broadcastreceivers.R
import com.tutorials22.broadcastreceivers.broadcastreceiver.DynamicBroadCastReceiver

class MainActivity : AppCompatActivity() {

    private val dynamicBroadcastReceiver = DynamicBroadCastReceiver()
    private val intentFilter=IntentFilter(Intent.ACTION_TIME_TICK)
//dynamic broadcast receivers are registered in callbacks of activities of the executing code for
// example in the on resume and on destroy callback, if you fail to unregister a call back on completion
// of the activity closure it would result in error saying that the broadcast receiver has not yet been
// unregistered
//
// to begin with you do not need static declaration of receivers with their intent filters and
// action you can remove them

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(dynamicBroadcastReceiver,intentFilter)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(dynamicBroadcastReceiver)
    }
}