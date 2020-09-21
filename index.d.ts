declare module "react-native-clear-cache" {
  export const ClearCache: {
    getAppCacheSize: () => { value: string; unit: string };
    clearAppCache: () => void;
  };
  export default ClearCache;
}
