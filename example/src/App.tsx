import * as React from 'react';

import { StyleSheet, View, Text, Pressable } from 'react-native';
import ClearCache from 'react-native-clear-cache';

export default function App() {
  const [size, setSize] = React.useState(0);

  React.useEffect(() => {
    ClearCache.getCacheDirSize().then((v) => setSize(v));
  }, []);

  const handlePress = React.useCallback(() => {
    ClearCache.clearCacheDir().then(() => console.log('complete'));
  }, []);

  return (
    <View style={styles.container}>
      <Text>getCacheDirSize: {size}</Text>
      <Pressable onPress={handlePress}>
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
});
