package com.reactnativeclearcache

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class ClearCacheModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return "ClearCache"
  }

  @ReactMethod
  fun getCacheDirSize(promise: Promise) {
    promise.resolve(0)
  }

  @ReactMethod
  fun clearCacheDir(promise: Promise) {
    
  }

}
