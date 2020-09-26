package com.reactlibrary

import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.io.File

class ClearCacheModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    private val databasePackages: Array<String> = arrayOf("webview.db", "webview.db-shm", "webview.db-wal", "webviewCache.db", "webviewCache.db-shm", "webviewCache.db-wal")
    private val reactContext: ReactApplicationContext = reactContext

    override fun getName(): String {
        return "ClearCache"
    }

    private fun getDirSize(dir: File?): Long {
        var size: Long = 0
        return if (dir == null || dir.isDirectory) {
            size
        } else {
            for (file in dir.listFiles()) {
                if (file.isFile) {
                    size += file.length()
                } else if (file.isDirectory) {
                    size += getDirSize(file)
                }
            }
            size
        }
    }

    private fun getExternalCacheDir(): File? {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO) {
            return reactContext.externalCacheDir
        }
        return null
    }

    fun clearCache() {
        val cacheDir: File = reactContext.cacheDir
        val externalCacheDir: File? = getExternalCacheDir()

        for (databasePackage in databasePackages) {
            reactContext.deleteDatabase(databasePackage)
        }
        clearCacheDir(cacheDir)
        clearCacheDir(externalCacheDir)
    }

    private fun clearCacheDir(dir: File?) {
        if (dir == null || dir.isFile) {
            return
        }
        try {
            for (file in dir.listFiles()) {
                if (file.isDirectory) {
                    clearCacheDir(file)
                } else {
                    file.delete()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return
        }
    }

    @ReactMethod
    fun getAppCacheSize(callback: Callback) {
        val cacheDir: File = reactContext.cacheDir
        val externalCacheDir: File? = getExternalCacheDir()
        val internalCacheSize: Long = getDirSize(cacheDir)
        val externalCacheSize: Long = getDirSize(externalCacheDir)
        val totalCacheSize: Long = internalCacheSize + externalCacheSize
        val unit: String = "Test"

        callback.invoke(totalCacheSize.toInt(), unit)
    }

    @ReactMethod
    fun clearAppCache(callback: Callback) {
        val coroutine: ClearCacheCoroutine = ClearCacheCoroutine(this, callback)
        coroutine.clear()
    }
}
