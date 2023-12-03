package com.example.pokemon

import android.util.Log
import javax.inject.Inject

class CommonLog @Inject constructor() {
    fun logCommon(){
        Log.e(CommonLog::class.simpleName, "Common")

    }
}