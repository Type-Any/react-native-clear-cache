import * as React from 'react';

import { StyleSheet, View, Text, Pressable } from 'react-native';
import ClearCache, { formatFileSize } from 'react-native-clear-cache';

export default function App() {
  const [cacheDirSize, setCacheDirSize] = React.useState(0);

  function _getCacheDirSize() {
    ClearCache.getCacheDirSize()
      .then(setCacheDirSize)
      .catch((e) => console.log(e));
  }

  React.useEffect(() => {
    _getCacheDirSize();
  }, []);

  const handlePress = React.useCallback(() => {
    ClearCache.clearCacheDir()
      .then(_getCacheDirSize)
      .catch((e) => console.log(e));
  }, []);

  return (
    <View style={styles.container}>
      <Text>size: {cacheDirSize}</Text>
      <Text>file size: {formatFileSize(cacheDirSize)}</Text>
      <Pressable style={styles.button} onPress={handlePress}>
        <Text>clear</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
  button: {
    paddingHorizontal: 8,
    paddingVertical: 4,
    marginTop: 16,
    backgroundColor: 'gray',
  },
});
