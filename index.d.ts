import React from 'react';
import { StyleProp, ViewStyle } from 'react-native'


type TilesType = 'VECTOR' | 'RASTER' | 'NONE';
type PerspectiveType = '3D' | '2D';
type MarkersType = {
  /**
   * Latitude of the marker
   */
  lat: Number;
  /**
   * Longitude of the marker
   */
  lng: Number;
  /**
   * Label of marker
   */
  label: String;
};
type MapCenterType = {
  /**
   * Latitude of map center
   */
  lat: Number,
  /**
   * Longitude of map center
   */
  lng: Number
}
type LangType =
  | 'ar'
  | 'bg-BG'
  | 'zh-TW'
  | 'cs-CZ'
  | 'da-DK'
  | 'nl-NL'
  | 'en-AU'
  | 'en-CA'
  | 'en-GB'
  | 'en-NZ'
  | 'en-US'
  | 'fi-FI'
  | 'fr-FR'
  | 'de-DE'
  | 'el-GR'
  | 'hu-HU'
  | 'id-ID'
  | 'it-IT'
  | 'ko-KR'
  | 'lt-LT'
  | 'ms-MY'
  | 'nb-NO'
  | 'pl-PL'
  | 'pt-BR'
  | 'pt-PT'
  | 'ru-RU'
  | 'ru-Latn-RU'
  | 'ru-Cyrl-RU'
  | 'sk-SK'
  | 'sl-SL'
  | 'es-ES'
  | 'es-MX'
  | 'sv-SE'
  | 'th-TH'
  | 'tr-TR';

type MapOptionsType = {
  /**
   * Map tile type. Could be RASTER or VECTOR
   */
  tilesType: TilesType;
  /**
   * Map language
   */
  lang: LangType;
  /**
   * Set map perspective in either 2D or 3D
   */
  perspective: PerspectiveType;
};

export interface TomtomMapProperties {
  /** Map options for Tomtom Maps SDK */
  mapOptions: MapOptionsType;
  /**
   * Callback when map is ready
   */
  onMapReady?(): void;
  /**
   * Markers array
   */
  markers: Array<MarkersType>;
  /**
   * Zoom level of map
   */
  mapZoom: Number;
  /**
   * Map center in latLng
   */
  mapCenter: MapCenterType;
  /**
   * Map View style
   */
  style: StyleProp<ViewStyle>
}

interface TomtomMapStatic extends React.ComponentClass<TomtomMapProperties> {}

declare var TomtomMap: TomtomMapStatic;

type TomtomMap = TomtomMapStatic;

export default TomtomMap;
