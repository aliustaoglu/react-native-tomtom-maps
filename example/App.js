import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import TomtomMaps from 'react-native-tomtom-maps';

export default class App extends Component {
  render() {
    return (
      <>
        <TomtomMaps
          camera={{
            target: {lat: 40.9175, lng: 38.3927},
            bearing: 180,
            zoom: 16,
            tilt: 7,
          }}
          style={StyleSheet.absoluteFillObject}
        />
      </>
    );
  }
}
