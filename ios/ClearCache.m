#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(ClearCache, NSObject)

RCT_EXTERN_METHOD(getCacheDirSize:(RCTPromiseResolveBlock)resolve withRejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(clearCacheDir:(RCTPromiseResolveBlock)resolve withRejecter:(RCTPromiseRejectBlock)reject)

@end
