package com.zfang.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zfang.testapp.process.client.BookClient
import com.zfang.testapp.process.server.BookService

class MainActivity : AppCompatActivity() {
    private val TAG = "zfang"
    private lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(App.get().getAsyncMainView())

        test()
    }

    private fun test() {
        Log.d(TAG, "test: test aidl")
        val connection = BookClient.getInstance()

        bindService(Intent(this, BookService::class.java), connection, BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(BookClient.getInstance())
    }

    private fun check() {
        if (::name.isInitialized) {
            //
        }
    }
}