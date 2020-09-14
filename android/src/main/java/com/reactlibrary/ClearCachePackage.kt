import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import java.util.*

class ClearCachePackage : ReactPackage {

    override fun createNativeModules(reactContext: ReactApplicationContext): MutableList<ClearCachePackage> {
        return mutableListOf(ClearCachePackage(reactContext))
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): MutableList<ViewManager<View, ReactShadowNode<*>>> {
        return Collections.emptyList()
    }
}
