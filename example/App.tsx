import React, {useCallback, useEffect, useState} from 'react';

import {Pressable, SafeAreaView, Text, StyleSheet, View} from 'react-native';

import ClearCache from 'react-native-clear-cache';

const styles = StyleSheet.create({
  button: {
    borderWidth: 1,
    borderRadius: 5,
    borderColor: '#cecece',
    paddingVertical: 4,
    paddingHorizontal: 8,
    justifyContent: 'center',
    alignItems: 'center',
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  header: {
    fontSize: 14,
    fontWeight: 'bold',
    marginVertical: 8,
  },
  wrapper: {
    paddingVertical: 16,
  },
});

function App(): JSX.Element {
  const [size, setSize] = useState(0);

  useEffect(() => {
    ClearCache.getAppCacheSize((size, _) => setSize(size));
  }, []);

  const handlePress = useCallback(() => console.log('press'), []);

  const {button, container, header, wrapper} = styles;

  return (
    <SafeAreaView style={container}>
      <View>
        <View style={wrapper}>
          <Text style={header}>getAppCacheSize</Text>
          <Text>{`size: ${size}`}</Text>
        </View>
        <View style={wrapper}>
          <Text style={header}>clearAppCache</Text>
          <Pressable style={button} onPress={handlePress}>
            <Text>Clear</Text>
          </Pressable>
        </View>
      </View>
    </SafeAreaView>
  );
}

export default App;
