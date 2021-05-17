import { NativeModules } from 'react-native';

type ClearCacheType = {
  getCacheDirSize(): Promise<void>;
  clearCacheDir(): Promise<void>;
};

const { ClearCache } = NativeModules;

export default ClearCache as ClearCacheType;
