import {StyleSheet} from 'react-native';

export const commonStyles = StyleSheet.create({
  bottomView: {
    position: 'absolute',
    width: 100,
    bottom: 30,
    right: 10,
    backgroundColor: '#fff',
  },
  bottomRow: {
    display: 'flex',
    flexDirection: 'row',
  },
  backButton: {
    position: 'absolute',
    top: 30,
    left: 10,
  },
  centerButton: {
    position: 'absolute',
    top: 30,
    right: 10,
  },
  textInput: {
    backgroundColor: 'lightgray',
    width: 90,
    height: 35,
  },
});
