package com.example.mykotlinapplication.net

import android.util.Log
import java.net.URL

class Request(val url: String) {
    fun run() {
        val readText = URL(url).readText()
        Log.d("xulimin", readText)
    }

    fun runResult() = URL(url).readText()

}