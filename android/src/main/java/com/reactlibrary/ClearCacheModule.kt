package com.reactlibrary

import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.io.File

class ClearCache(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    private val reactContext: ReactApplicationContext = reactContext

    override fun getName(): String {
        return "ClearCache"
    }

    private fun getDirSize(dir: File?):Long {
        // end of recursive
        if(dir == null || dir.isDirectory) {
            return 0
        }

        // recursive
        var size: Long = 0
        for(file in dir.listFiles()){
            if(file.isFile) {
                size += file.length()
            } else if(file.isDirectory){
                size += getDirSize(file)
            }
        }

        return size
    }

    private fun getExternalCacheDir():File? {
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO){
            return reactContext.externalCacheDir
        }
        return null
    }

    @ReactMethod
    public fun getAppCacheSize(callback: Callback) {
        // TODO What you want toa do
        val cacheDir:File = reactContext.cacheDir
        val externalCacheDir:File? = getExternalCacheDir()
        val internalCacheSize:Long = getDirSize(cacheDir)
        val externalCacheSize:Long = getDirSize(externalCacheDir);
        val totalCacheSize:Long = internalCacheSize + externalCacheSize
        val unit: String = "Test"

        callback.invoke(totalCacheSize.toInt(), unit)
    }

    @ReactMethod
    public fun clearAppCache() {
        // TODO What you want to do

    }


}
