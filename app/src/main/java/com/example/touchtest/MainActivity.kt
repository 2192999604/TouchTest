package com.example.touchtest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.touchtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "TestTouch"
    }

    private lateinit var mContext : Context

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.testView.setOnTouchListener(object : View.OnTouchListener {
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                Log.d(LOG_TAG, "onTouch click start")
//                Toast.makeText(mContext, "hello, world", Toast.LENGTH_SHORT).show()
//                return false // 这里false的话，会继续传到View1的onTouchEvent,true的话，流程到此为止
//            }
//        })
        binding.testView.setOnClickListener {
            Toast.makeText(mContext, "hello, world", Toast.LENGTH_SHORT).show()
            Log.d(LOG_TAG, "onClick click start") }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(LOG_TAG, "MainActivity dispatchTouchEvent && ev type is ${ev?.action}")
        return super.dispatchTouchEvent(ev) // 假如这里为false，还是有所不同的
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(LOG_TAG, "MainActivity onTouchEvent && ev type is ${event?.action}")
        binding.testView.performClick()
        return false
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }


}