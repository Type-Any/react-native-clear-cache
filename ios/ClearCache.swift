import Foundation

@objc(ClearCache)
class ClearCache: NSObject {
    
    @objc(getCacheDirSize:withRejecter:)
    func getCacheDirSize(resolve:RCTPromiseResolveBlock, reject:RCTPromiseRejectBlock) -> Void {
        let fileManager = FileManager.default
        let cacheDirUrl = FileManager.default.urls(for: .cachesDirectory, in: .userDomainMask).first!
        
        do {
            let attributes = try fileManager.attributesOfItem(atPath: cacheDirUrl.path)
            resolve(attributes[FileAttributeKey.size])
        } catch {
            reject("event_failure", "no event id returned", nil);
        }
    }
    
    @objc(clearCacheDir:withRejecter:)
    func clearCacheDir(resolve:RCTPromiseResolveBlock, reject:RCTPromiseRejectBlock) -> Void {
        
    }
}
