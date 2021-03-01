package com.example.touchtest

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView

@SuppressLint("AppCompatCustomView")
open class View1 @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0) : Button(context, attributeSet, defStyle){

    init {
        initView()
    }

    private fun initView() {

    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.d(MainActivity.LOG_TAG, "View1 dispatchTouchEvent executed && ev type is ${event?.action}")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(MainActivity.LOG_TAG, "View1 onTouchEvent executed && ev type is ${event?.action}")
//        parent.requestDisallowInterceptTouchEvent(true)
        return true // 这里假如为false, 也不会执行点击事件（前提是不设置setOnTouchListener）
    }

    // 为什么不加这行，会报警告？
    override fun performClick(): Boolean {
        Log.d(MainActivity.LOG_TAG, "View1 performClick executed")
        return false
    }


}