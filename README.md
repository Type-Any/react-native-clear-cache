# react-native-clear-cache

This library is clear app cache for react native.

## Installation

```sh
npm install @type-any/react-native-clear-cache
```

## Usage

```js
import ClearCache, { formatFileSize } from '@type-any/react-native-clear-cache';

// ...

// This method will return byte size
const cacheDirSize = await ClearCache.getCacheDirSize();

// Convert byte size to read easy
// second parameter is used to truncate digits, default value is 4
const format = formatFileSize(cacheDirSize);

// file size symbol example
formatFileSize(422); // 422 Bytes
formatFileSize(122304); // 119.4375 KB
formatFileSize(10000000); // 9.5367 MB
formatFileSize(87919837478); // 81.8817 GB
formatFileSize(191238495867681); // 173.9304 TB
formatFileSize(929292929384748571); // 825.3779 PB
formatFileSize(9292929293847485728); // 8.0603 EB
formatFileSize(9292929293847485719928); // 7.8714 ZB
formatFileSize(13847885919183748857185858); // 11.4547 YB

// truncate digits example
formatFileSize(122304); // 119.4375 KB
formatFileSize(122304, 2); // 119.44 KB

// Clear cacheDir
// On Android, will clear both inteinternalCacheDir and externalCacheDir
await ClearCache.clearCacheDir();
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
