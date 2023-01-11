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
    private val intentFilter=IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//dynamic broadcast receivers are registered in callbacks of activities of the executing code for
// example in the on resume and on destroy callback, if you fail to unregister a call back on completion
// of the activity closure it would result in error saying that the broadcast receiver has not yet been
// unregistered
//
// to begin with you do not need static declaration of receivers with their intent filters and
// action you can remove them,
//
// the type of broadcast receivers we are currently dealing with are called sticky
// broadcast receiver, wherein consider a scenario when the activity that has registered
// a broadcast receiver is active the event changes for the connectivity will be shown as a
// part of broadcast receiver implementation if you kill the activity or the app and make
// the connectivity changes nothing will be displayed as a part of broadcast receiver
// implementation but when you recreate or open the activity where the broadcast receiver
// has been registered it will trigger the latest even change in connectivity

//    Another scenario is when you have not made any changes in the connectivity when
//    your app is killed and again open back your activity or the app then the latest state
//    of the connectivity will be shown as a part of on receive call
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