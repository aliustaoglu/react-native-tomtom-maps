package biz.aliustaoglu.tomtom;

import android.content.Context;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.tomtom.online.sdk.common.location.LatLng;
import com.tomtom.online.sdk.map.CameraPosition;
import com.tomtom.online.sdk.map.MapView;
import com.tomtom.online.sdk.map.MarkerBuilder;
import com.tomtom.online.sdk.map.OnMapReadyCallback;
import com.tomtom.online.sdk.map.SimpleMarkerBalloon;
import com.tomtom.online.sdk.map.TomtomMap;
import com.tomtom.online.sdk.map.UiSettings;
import com.tomtom.online.sdk.map.model.MapTilesType;


public class TTMapView extends MapView implements OnMapReadyCallback {
    private TomtomMap mTomtomMap;
    private Boolean isMapReady = false;
    private int mZoom;
    private ReadableArray mMarkers;
    private ReadableMap mCenter;
    private ReadableMap mMapOptions;


    public TTMapView(@NonNull Context context) {
        super(context);
        this.addOnMapReadyCallback(this);
    }

    protected void setMapCenter(ReadableMap center) {
        mCenter = center;
        if (isMapReady) {
            mTomtomMap.centerOn(mCenter.getDouble("lat"), center.getDouble("lng"));
        }
    }

    protected void setMarkers(ReadableArray markers) {
        mMarkers = markers;
        if (isMapReady) {
            mTomtomMap.removeMarkers();
            drawMarkers();
        }
    }

    protected void setMapZoom(Integer zoom) {
        mZoom = zoom;
        if (isMapReady) {
            mTomtomMap.zoomTo(mZoom);
        }
    }

    protected void setMapOptions(ReadableMap mapOptions) {
        mMapOptions = mapOptions;
        if (mapOptions == null || !isMapReady) return;

        // If map is ready and has options
        UiSettings uiSettings = mTomtomMap.getUiSettings();
        MapTilesType tilesType = mapOptions.hasKey("tilesType") ? MapTilesType.valueOf(mapOptions.getString("tilesType")) : MapTilesType.VECTOR;
        uiSettings.setMapTilesType(tilesType);
        String lang = mapOptions.hasKey("lang") ? mapOptions.getString("lang") : "en-US";
        mTomtomMap.setLanguage(lang);
        String perspective = mapOptions.hasKey("perspective") ? mapOptions.getString("perspective") : "2D";
        if (perspective.equals("3D")) mTomtomMap.set3DMode();
    }


    @Override
    public void onMapReady(@NonNull TomtomMap tomtomMap) {
        isMapReady = true;
        mTomtomMap = tomtomMap;
        reactNativeEvent("onMapReady", null);

        setMapOptions(mMapOptions);
        LatLng mapCenter = new LatLng(mCenter.getDouble("lat"), mCenter.getDouble("lng"));
        tomtomMap.centerOn(CameraPosition.builder(mapCenter).zoom(mZoom).build());
        drawMarkers();
    }

    private void drawMarkers() {
        for (int i = 0; i < mMarkers.size(); i++) {
            ReadableMap marker = mMarkers.getMap(i);
            SimpleMarkerBalloon balloon = new SimpleMarkerBalloon(marker.getString("label"));
            LatLng markerCenter = new LatLng(marker.getDouble("lat"), marker.getDouble("lng"));
            mTomtomMap.addMarker(new MarkerBuilder(markerCenter).markerBalloon(balloon));
        }
    }

    protected void reactNativeEvent(String eventName, WritableMap eventParams) {
        ReactContext reactContext = (ReactContext) this.getContext();
        reactContext
                .getJSModule(RCTEventEmitter.class)
                .receiveEvent(this.getId(), eventName, eventParams);
    }
}
