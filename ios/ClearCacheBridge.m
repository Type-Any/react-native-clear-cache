#import "ClearCacheBridge.h"
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(ClearCache, NSObject)
    RCT_EXTERN_METHOD(getAppCacheSize)
    RCT_EXTERN_METHOD(clearAppCache)

@end
