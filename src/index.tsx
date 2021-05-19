import { NativeModules } from 'react-native';

type ClearCacheType = {
  getCacheDirSize(): Promise<number>;
  clearCacheDir(): Promise<void>;
};

const { ClearCache } = NativeModules;

export default ClearCache as ClearCacheType;

export function foramtFileSize(size: number, decimal: number = 4): string {
  if (size < 1024) return `${size} Bytes`;

  const arr = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
  const i = Math.floor(Math.log(size) / Math.log(1024));
  const d = decimal < 0 ? 0 : decimal > 4 ? 4 : decimal;

  return parseFloat((size / Math.pow(1024, i)).toFixed(d)) + ' ' + arr[i];
}
