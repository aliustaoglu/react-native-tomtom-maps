import React, {Component} from 'react';
import {Platform, StyleSheet, Button, Text, View} from 'react-native';
import TomtomMaps from 'react-native-tomtom-maps';
import {commonStyles} from './styles';

const marker1 = {
  id: 'Marker1',
  lat: 40.9175,
  lng: 38.3927,
  title: 'Custom',
  subtitle: 'Sub1',
};

const marker1a = {
  id: 'Marker1',
  lat: 40.9175,
  lng: 39.3927,
  title: 'Custom',
  subtitle: 'Sub1',
};

const marker2 = {
  id: 'Marker2',
  lat: 41.9175,
  lng: 38.3927,
  title: 'Custom',
  subtitle: 'Sub1',
};
export default class Markers extends Component {
  constructor(props) {
    super(props);
    this.state = {
      markers: [marker1],
    };
  }

  render() {
    return (
      <>
        <TomtomMaps
          camera={{
            target: {lat: 40.9175, lng: 38.3927},
            zoom: 5,
            tilt: 7,
            padding: [100, 100, 100, 200],
          }}
          markers={this.state.markers}
          style={StyleSheet.absoluteFillObject}
        />
        <View style={commonStyles.backButton}>
          <Button title="<Back" onPress={this.props.onGoBack} />
        </View>
        <View style={{...commonStyles.bottomView, width: '90%'}}>
          <Button
            title="EKLE"
            onPress={() =>
              this.setState({
                markers: [marker1a, marker2],
              })
            }
          />
        </View>
      </>
    );
  }
}
