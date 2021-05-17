import { NativeModules } from 'react-native';

type ClearCacheType = {
  getCacheDirSize(): Promise<number>;
  clearCacheDir(): Promise<void>;
};

const { ClearCache } = NativeModules;

export default ClearCache as ClearCacheType;
