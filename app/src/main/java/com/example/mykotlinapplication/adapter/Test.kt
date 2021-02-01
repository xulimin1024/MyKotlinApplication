package com.example.mykotlinapplication.adapter

import androidx.core.net.toUri

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val str = "helloworld"
        str?.toUpperCase()

        val toUri = str.toUri()

    }
}