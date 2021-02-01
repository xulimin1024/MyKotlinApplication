package com.example.mykotlinapplication.base

import android.content.Context
import android.widget.Toast



fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show();
}


