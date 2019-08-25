package biz.aliustaoglu.tomtom;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TomtomMapsManager extends SimpleViewManager<View> {

    public static final String REACT_CLASS = "TomtomMaps";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nonnull
    @Override
    protected View createViewInstance(@Nonnull ThemedReactContext reactContext) {
        TTMapView ttMapView = new TTMapView(reactContext);
        ttMapView.onResume();
        return ttMapView;
    }


    @ReactProp(name = "mapCenter")
    public void setCenter(TTMapView mapView, @Nullable ReadableMap center) {
        mapView.setMapCenter(center);
    }

    @ReactProp(name = "markers")
    public void setMarkers(TTMapView mapView, @Nullable ReadableArray markers) {
        mapView.setMarkers(markers);
    }

    @ReactProp(name = "mapZoom")
    public void setMapZoom(TTMapView mapView, @Nullable Integer zoom) {
        mapView.setMapZoom(zoom);
    }

    @ReactProp(name="mapOptions")
    public void setMapOptions(TTMapView mapView, @Nullable ReadableMap mapOptions){
        mapView.setMapOptions(mapOptions);
    }


    @Nullable
    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("onMapReady", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onMapReady")))
                .build();
    }
}
