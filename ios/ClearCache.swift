@objc(ClearCache)
class ClearCache: NSObject {
    
    @objc(getCacheDirSize:withRejecter:)
    func getCacheDirSize(resolve:RCTPromiseResolveBlock, reject:RCTPromiseRejectBlock) -> Void {
        resolve(0)
    }
    
    @objc(clearCacheDir:withRejecter:)
    func clearCacheDir(resolve:RCTPromiseResolveBlock, reject:RCTPromiseRejectBlock) -> Void {
        
    }
}
