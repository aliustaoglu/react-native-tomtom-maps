import React from 'react'
import { TouchableOpacity, Text, StyleSheet } from 'react-native'

const styles = StyleSheet.create({
  submit: {
    marginRight: 40,
    marginLeft: 40,
    marginTop: 10,
    paddingTop: 20,
    paddingBottom: 20,
    backgroundColor: '#68a0cf',
    borderRadius: 10,
    borderWidth: 1,
    borderColor: '#fff',
  },
  submitText: {
    color: '#fff',
    textAlign: 'center',
  },
});

const Btn = ({text, onClick}) => {
  return (
    <TouchableOpacity onPress={onClick} activeOpacity={0.7} style={styles.submit} underlayColor="#fff">
      <Text style={styles.submitText}>{ text }</Text>
    </TouchableOpacity>
  );
};

export default Btn