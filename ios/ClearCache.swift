import Foundation

@objc(ClearCache)
class ClearCache: NSObject {
    
    @objc(getCacheDirSize:withRejecter:)
    func getCacheDirSize(resolve:RCTPromiseResolveBlock, reject:RCTPromiseRejectBlock) -> Void {
        let fileManager = FileManager.default
        let cacheDirUrl = FileManager.default.urls(for: .cachesDirectory, in: .userDomainMask).first!
        
        var size:Int64 = 0;
        
        do {
            let attributes = try fileManager.attributesOfItem(atPath: cacheDirUrl.path)
            let contents = try fileManager.contentsOfDirectory( at: cacheDirUrl, includingPropertiesForKeys: nil, options: [])
            
            for content in contents {
                let attributes = try fileManager.attributesOfItem(atPath: content.path)
                size += attributes[FileAttributeKey.size] as? Int64 ?? 0
            }
            
            resolve(size)
        } catch {
            reject("event_failure", "no event id returned", nil);
        }
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
            
            resolve(nil)
        } catch {
            reject("event_failure", "no event id returned", nil);
        }
    }
}
