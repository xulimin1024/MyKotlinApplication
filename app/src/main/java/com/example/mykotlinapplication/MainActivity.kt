package com.example.mykotlinapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.AbsListView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapplication.adapter.ForeCastListAdapter
import com.example.mykotlinapplication.bean.Forcast

import com.example.mykotlinapplication.net.Request
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.custom.asyncResult
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val str =
        "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2113919784,1073379879&fm=26&gp=0.jpg"
    private val items = listOf(
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊"),
        Forcast(str, Date(), 12.4f, "今天有点冷啊")
    )
    val url = "https://api.apiopen.top/getJoke?page=1&count=2&type=video"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        thread {
//            Request(url).run()
//        }
//            async {
//                Request(url).run()
//                uiThread {
//                    toast("执行了请求")
//                }
//            }
//        doAsyncResult {
//            val runResult = Request(url).runResult()
//            uiThread {
//                    toast(runResult)
//                }
//
//        }

        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val adapter = ForeCastListAdapter(this,items) { toast("${it}我被点击了") }
        forecastList.adapter = adapter


    }

    fun myToast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(
        message: String,
        tag: String = MainActivity::class.java.simpleName,
        length: Int = Toast.LENGTH_LONG
    ) {
        Toast.makeText(this, "${tag}:${message}", length).show()
    }

}