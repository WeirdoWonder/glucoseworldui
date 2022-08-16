package com.example.glucoseworld3

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothProfile
import android.content.*
import android.nfc.Tag
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class DControlActivity : AppCompatActivity() {



    private var bluetoothService: MyBLEService? = null

    // Code to manage Service lifecycle.
    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(
            componentName: ComponentName,
            service: IBinder
        ) {
            bluetoothService = (service as MyBLEService.LocalBinder).getService()
            bluetoothService?.let { bluetooth ->
                // call functions on service to check connection and connect to devices
                if (!bluetooth.initialize()) {
                    "Unable to initialize Bluetooth"
                    finish()
                }
                //prepei na valw dieuthinsi tis suskeuis gia sundesi
              //  bluetooth.connect(deviceAddress)
            }
        }

        override fun onServiceDisconnected(componentName: ComponentName) {
            bluetoothService = null
        }
    }

    private val gattUpdateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                MyBLEService.ACTION_GATT_CONNECTED -> {
                   // connected = true
                   // updateConnectionState(R.string.connected)
                }
                MyBLEService.ACTION_GATT_DISCONNECTED -> {
                  //  connected = false
                  //  updateConnectionState(R.string.disconnected)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(gattUpdateReceiver, makeGattUpdateIntentFilter())
        if (bluetoothService != null) {

            //vazw dieuthunsi
           // val result = bluetoothService!!.connect(deviceAddress)
           // Log.d(DeviceControlsActivity.TAG, "Connect request result=$result")
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(gattUpdateReceiver)
    }

    private fun makeGattUpdateIntentFilter(): IntentFilter? {
        return IntentFilter().apply {
            addAction(MyBLEService.ACTION_GATT_CONNECTED)
            addAction(MyBLEService.ACTION_GATT_DISCONNECTED)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.gatt_services_characteristics)

        val gattServiceIntent = Intent(this, MyBLEService::class.java)
        bindService(gattServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE)
    }





}
