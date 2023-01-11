package com.tutorials22.broadcastreceivers.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tutorials22.broadcastreceivers.R

class MainActivity : AppCompatActivity() {

    companion object {
        const val FILTER_ACTION = "DynamicAndCustomBroadCastReceiver"
    }

    val dynamicCustomBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (FILTER_ACTION == intent?.action) {
                findViewById<TextView>(R.id.textToBeUpdated).apply {
                    val count = intent.getStringExtra(EXTRA_DATA)
                    this.text = "BroadCast Receiver Count=$count"
                }
            }

        }

    }

    private val intentFilter = IntentFilter(FILTER_ACTION)
    private val EXTRA_DATA = "EXTRA_DATA"
    var counter = 1
//dynamic broadcast receivers are registered in callbacks of activities of the executing code for
// example in the on resume and on destroy callback, if you fail to unregister a call back on completion
// of the activity closure it would result in error saying that the broadcast receiver has not yet been
// unregistered


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.sendBroadCast).setOnClickListener{
            sendAction()
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(dynamicCustomBroadcastReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(dynamicCustomBroadcastReceiver)
    }

    private fun sendAction() {
        sendBroadcast(Intent(FILTER_ACTION).also {
            it.putExtra(EXTRA_DATA, "$counter")
        })
        counter++
    }
}