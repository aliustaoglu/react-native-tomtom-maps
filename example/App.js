import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, ScrollView} from 'react-native';
import TomtomMaps from 'react-native-tomtom-maps';
import Btn from './src/Btn';
import Simple from './src//Screens/Simple'
import Markers from './src/Screens/Markers';

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      activeRoute: 'App',
    };
    this.onBtnClick = this.onBtnClick.bind(this);
  }

  onBtnClick(activeRoute) {
    this.setState({activeRoute});
  }

  render() {
    return (
      <>
        {this.state.activeRoute === 'App' && (
          <View style={{marginTop: 50, height: '100%'}}>
            <ScrollView>
              <Btn text="Simple" onClick={() => this.onBtnClick('Simple')} />
              <Btn text="Markers" onClick={() => this.onBtnClick('Markers')} />
            </ScrollView>
          </View>
        )}
        {this.state.activeRoute === 'Simple' && (
          <Simple onGoBack={() => this.setState({activeRoute: 'App'})} />
        )}
        {this.state.activeRoute === 'Markers' && (
          <Markers onGoBack={() => this.setState({activeRoute: 'App'})} />
        )}
      </>
    );
  }
}
