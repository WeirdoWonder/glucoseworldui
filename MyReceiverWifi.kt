package com.example.glucoseworld3

import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.wifi.WpsInfo
import android.net.wifi.p2p.WifiP2pConfig
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.util.Log
import android.widget.Toast

class MyReceiverWifi : BroadcastReceiver() {

  private val peers = mutableListOf<WifiP2pDevice>()


    private val peerListListener = WifiP2pManager.PeerListListener { peerList ->
        val refreshedPeers = peerList.deviceList
        if (refreshedPeers != peers) {
            peers.clear()
            peers.addAll(refreshedPeers)

            // If an AdapterView is backed by this data, notify it
            // of the change. For instance, if you have a ListView of
            // available peers, trigger an update.
          //  (listAdapter as WiFiPeerListAdapter).notifyDataSetChanged()

            // Perform any other updates needed based on the new list of
            // peers connected to the Wi-Fi P2P network.
        }

        if (peers.isEmpty()) {
            Log.d(TAG, "No devices found")
            return@PeerListListener
        }
    }

    private val connectionListener = WifiP2pManager.ConnectionInfoListener { info ->

        // String from WifiP2pInfo struct
        val groupOwnerAddress: String = info.groupOwnerAddress.hostAddress

        // After the group negotiation, we can determine the group owner
        // (server).
        if (info.groupFormed && info.isGroupOwner) {
            // Do whatever tasks are specific to the group owner.
            // One common case is creating a group owner thread and accepting
            // incoming connections.
        } else if (info.groupFormed) {
            // The other device acts as the peer (client). In this case,
            // you'll want to create a peer thread that connects
            // to the group owner.
        }
    }


    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION -> {
                // Determine if Wifi P2P mode is enabled or not, alert
                // the Activity.
                val state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1)
                //activity.isWifiP2pEnabled = state == WifiP2pManager.WIFI_P2P_STATE_ENABLED
            }
            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION -> {


                // Request available peers from the wifi p2p manager. This is an
                // asynchronous call and the calling activity is notified with a
                // callback on PeerListListener.onPeersAvailable()
                /*   mManager?.requestPeers(channel, peerListListener)
                Log.d(TAG, "P2P peers changed")
            }


            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION -> {

                mManager?.let { manager ->

                    val networkInfo: NetworkInfo? = intent.getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO) as NetworkInfo

                    if (networkInfo?.isConnected == true) {

                        // We are connected with the other device, request connection
                        // info to find group owner IP

                        manager.requestConnectionInfo(channel, connectionListener)
                    }
                }
            }

            }
            WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION -> {
                //  (activity.supportFragmentManager.findFragmentById(R.id.frag_list) as DeviceListFragment)
                //    .apply {
                //        updateThisDevice(
                //          intent.getParcelableExtra(
                //     WifiP2pManager.EXTRA_WIFI_P2P_DEVICE) as WifiP2pDevice
                //   )
                //}
            }


        }
    }

    override fun connect() {
        // Picking the first device found on the network.
        val device = peers[0]

        val config = WifiP2pConfig().apply {
            deviceAddress = device.deviceAddress
            wps.setup = WpsInfo.PBC
        }

        manager.connect(channel, config, object : WifiP2pManager.ActionListener {

            override fun onSuccess() {
                // WiFiDirectBroadcastReceiver notifies us. Ignore for now.
            }

            override fun onFailure(reason: Int) {
                Toast.makeText(
                    this@WiFiDirectActivity,
                    "Connect failed. Retry.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
*/
            }
        }
    }
}