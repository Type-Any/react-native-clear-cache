package com.reactlibrary

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class ClearCache(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    private val reactContext: ReactApplicationContext

    override fun getName(): String {
        return "ClearCache"
    }

    @ReactMethod
    public fun getAppCacheSize() {
        // TODO What you want to do
    }

    @ReactMethod
    public fun clearAppCache() {
        // TODO What you want to do
    }

    init {
        this.reactContext = reactContext
    }
}
