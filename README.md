# react-native-clear-cache

This library is clear app cache for react native.

## Installation

```sh
npm install @type-any/react-native-clear-cache
```

## Usage

```js
import ClearCache, { foramtFileSize } from '@type-any/react-native-clear-cache';

// ...

// This method will return byte size
const cacheDirSize = await ClearCache.getCacheDirSize();

// Convert byte size to read easy
// second parameter is used to truncate digits, default value is 4
const format = formatFileSize(cacheDirSize);

// file size symbol example
foramtFileSize(422); // 422 Bytes
foramtFileSize(122304); // 119.4375 KB
foramtFileSize(10000000); // 9.5367 MB
foramtFileSize(87919837478); // 81.8817 GB
foramtFileSize(191238495867681); // 173.9304 TB
foramtFileSize(929292929384748571); // 825.3779 PB
foramtFileSize(9292929293847485728); // 8.0603 EB
foramtFileSize(9292929293847485719928); // 7.8714 ZB
foramtFileSize(13847885919183748857185858); // 11.4547 YB

// truncate digits example
foramtFileSize(122304); // 119.4375 KB
foramtFileSize(122304, 2); // 119.44 KB

// Clear cacheDir
// On Android, will clear both inteinternalCacheDir and externalCacheDir
await ClearCache.clearCacheDir();
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
