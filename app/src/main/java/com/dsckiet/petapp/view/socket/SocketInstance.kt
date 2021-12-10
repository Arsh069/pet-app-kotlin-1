package com.dsckiet.petapp.view.socket

import android.app.Application
import android.os.Bundle
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import java.net.URISyntaxException
import android.text.TextUtils

import android.widget.EditText
import org.json.JSONException

import org.json.JSONObject

import com.github.nkzawa.emitter.Emitter
import com.google.android.material.internal.ContextUtils.getActivity


private const val URL = "https://ancient-earth-36601.herokuapp.com"
class SocketInstance:Application() {
    private var mSocket: Socket? = null

    override fun onCreate() {
        super.onCreate()
        try {
//creating socket instance
            mSocket = IO.socket(URL)
        } catch (e: URISyntaxException) {
            throw RuntimeException(e)
        }
    }

    //return socket instance
    fun getMSocket(): Socket? {
        return mSocket
    }

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate()
        mSocket!!.on("new message", onNewMessage)
        mSocket!!.connect()
    }

    private val mInputMessageView: EditText? = null

    private fun attemptSend() {
        val message = mInputMessageView!!.text.toString().trim { it <= ' ' }
        if (TextUtils.isEmpty(message)) {
            return
        }
        mInputMessageView.setText("")
        mSocket!!.emit("new message", message)
    }


    private val onNewMessage =
        Emitter.Listener { args ->
           getActivity()!!.runOnUiThread(Runnable {
                val data = args[0] as JSONObject
                val username: String
                val message: String
                try {
                    username = data.getString("username")
                    message = data.getString("message")
                } catch (e: JSONException) {
                    return@Runnable
                }

                // add the message to view
                addMessage(username, message)
            })
        }
    fun onDestroy() {
        super.onDestroy()
        mSocket!!.disconnect()
        mSocket!!.off("new message", onNewMessage)
    }
}