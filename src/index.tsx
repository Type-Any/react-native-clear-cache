import { NativeModules } from 'react-native';

type ClearCacheType = {
  multiply(a: number, b: number): Promise<number>;
};

const { ClearCache } = NativeModules;

export default ClearCache as ClearCacheType;
