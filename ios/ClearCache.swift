import Foundation

@objc(ClearCache)
class ClearCache: NSObject {
    
    @objc(getCacheDirSize:withRejecter:)
    func getCacheDirSize(resolve:RCTPromiseResolveBlock, reject:RCTPromiseRejectBlock) -> Void {
        let fileManager = FileManager.default
        let cacheDirUrl = FileManager.default.urls(for: .cachesDirectory, in: .userDomainMask).first!
        
        var size:Int = 0;
        
        do {
            let attributes = try fileManager.attributesOfItem(atPath: cacheDirUrl.path)
            size += attributes[FileAttributeKey.size] as! Int
        } catch {
            reject("event_failure", "no event id returned", nil);
        }
        
        resolve(size)
    }
    
    @objc(clearCacheDir:withRejecter:)
    func clearCacheDir(resolve:RCTPromiseResolveBlock, reject:RCTPromiseRejectBlock) -> Void {
        let fileManager = FileManager.default
        let cacheDirUrl = FileManager.default.urls(for: .cachesDirectory, in: .userDomainMask).first!
        
        do {
            let contents = try fileManager.contentsOfDirectory( at: cacheDirUrl, includingPropertiesForKeys: nil, options: [])
            
            for content in contents {
                try fileManager.removeItem(at: content)
            }
        } catch {
            reject("event_failure", "no event id returned", nil);
        }
        
        resolve(nil)
    }
}
