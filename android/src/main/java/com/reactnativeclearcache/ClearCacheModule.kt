package com.reactnativeclearcache

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import kotlinx.coroutines.*
import java.io.File

class ClearCacheModule(ClearCachePackage: ReactApplicationContext) :
  ReactContextBaseJavaModule(ClearCachePackage) {
  private val mReactContext: ReactApplicationContext = ClearCachePackage

  override fun getName(): String {
    return "ClearCache"
  }

  private fun getFileSizeRecursively(file: File?): Long {
    if (file == null) return 0

    if (file.isFile) return file.length()
    else if (file.isDirectory) {
      var size: Long = 0
      for (listFile in file.listFiles()) {
        if (listFile.isFile) size += listFile.length()
        else if (listFile.isDirectory) size += getFileSizeRecursively(listFile)
      }

      return size
    }

    return 0
  }

  private fun clearFileRecursively(file: File?) {
    if (file == null) return

    if (file.isFile) file.delete()
    else if (file.isDirectory) {
      for (listFile in file.listFiles()) {
        if (listFile.isDirectory) clearFileRecursively(listFile)
        listFile.delete()
      }
    }
  }

  private fun clearCoroutine() = CoroutineScope(Dispatchers.IO).launch {
    val cacheDir: File = mReactContext.cacheDir
    val externalCacheDir: File? = mReactContext.externalCacheDir

    val job1 = launch { clearFileRecursively(cacheDir) }
    val job2 = launch { clearFileRecursively(externalCacheDir) }

    joinAll(job1, job2)
  }

  @ReactMethod
  fun getCacheDirSize(promise: Promise) {
    val cacheDir: File = mReactContext.cacheDir
    val externalCacheDir: File? = mReactContext.externalCacheDir
    val internalCacheSize: Long = getFileSizeRecursively(cacheDir)
    val externalCacheSize: Long = getFileSizeRecursively(externalCacheDir)
    val totalCacheSize: Long = internalCacheSize + externalCacheSize

    promise.resolve(totalCacheSize.toInt())
  }

  @ReactMethod
  fun clearCacheDir(promise: Promise) {
    try {
      clearCoroutine()
      promise.resolve(null)
    } catch (e: RuntimeException) {
      promise.reject("Create Event Error", e)
    }
  }

}
