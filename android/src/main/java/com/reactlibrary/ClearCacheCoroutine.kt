package com.reactlibrary

import com.facebook.react.bridge.Callback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ClearCacheCoroutine(clearCacheModule: ClearCacheModule, callback: Callback) {
    private val mClearCacheModule: ClearCacheModule = clearCacheModule
    private val mCallback: Callback = callback

    fun clear() =
            runBlocking {
                val job = GlobalScope.launch(Dispatchers.IO) {
                    mClearCacheModule.clearCache()
                }
                job.join()
                mCallback()
            }
}