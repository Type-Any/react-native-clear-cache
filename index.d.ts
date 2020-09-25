declare module "react-native-clear-cache" {
  export const ClearCache: {
    getAppCacheSize: (callback: (size: number, unit: string) => void) => void;
    clearAppCache: () => void;
  };
  export default ClearCache;
}
