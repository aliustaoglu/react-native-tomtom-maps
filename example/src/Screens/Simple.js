import React, {Component} from 'react';
import {Platform, StyleSheet, Button, Text, View} from 'react-native';
import TomtomMaps from 'react-native-tomtom-maps';
import { commonStyles } from './styles';

export default class Simple extends Component {
  render() {
    return (
      <>
        <TomtomMaps
          camera={{
            target: {lat: 40.9175, lng: 38.3927},
            zoom: 16,
            tilt: 7,
            padding: [100, 100, 100, 200]
          }}
          style={StyleSheet.absoluteFillObject}
        />
        <View style={commonStyles.backButton}>
          <Button title="<Back" onPress={this.props.onGoBack} />
        </View>
      </>
    );
  }
}
