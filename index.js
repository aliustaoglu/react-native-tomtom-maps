import { requireNativeComponent, Platform } from 'react-native';

const moduleName = Platform.OS === 'ios' ? 'TomtomView' : 'TomtomMaps'

const TomtomMaps = requireNativeComponent(moduleName, null);

export default TomtomMaps;
