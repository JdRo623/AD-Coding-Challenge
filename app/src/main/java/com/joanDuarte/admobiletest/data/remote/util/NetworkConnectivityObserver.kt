package com.joanDuarte.admobiletest.data.remote.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class NetworkConnectivityObserver(
    private val context: Context
): ConnectivityObserver {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun observe(): ConnectivityObserver.Status {
        var status = ConnectivityObserver.Status.Unavailable
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                status = (ConnectivityObserver.Status.Available)
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                super.onLosing(network, maxMsToLive)
                status = (ConnectivityObserver.Status.Losing)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                status =(ConnectivityObserver.Status.Lost)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                status = (ConnectivityObserver.Status.Unavailable)
            }
        }
        connectivityManager.registerDefaultNetworkCallback(callback)
        return status
    }
}