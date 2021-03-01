package com.example.touchtest

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

class ViewGroup1 @JvmOverloads constructor(context: Context, attributes: AttributeSet? = null, defStyle: Int = 0) : FrameLayout(context, attributes, defStyle){


    init {
        initView()
    }

    private fun initView() {

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(MainActivity.LOG_TAG, "ViewGroup1 dispatchTouchEvent executed && ev type is ${ev?.action}") // 即使在日志中也不能随便调用super的上一级方法，会干扰的
        return true // true的话，会自行消费？和onTouchEvent不同，要区分开来
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(MainActivity.LOG_TAG, "ViewGroup1 onInterceptTouchEvent executed && ev type is ${ev?.action}")
        return false // 这里不能为true,一旦为true,就默认要viewGroup处理了，也就是不能再向下传递了
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(MainActivity.LOG_TAG, "ViewGroup1 onTouchEvent executed && ev type is ${event?.action}")
        return false
    }

}