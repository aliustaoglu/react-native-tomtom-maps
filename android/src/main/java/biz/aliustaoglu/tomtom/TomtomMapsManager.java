package biz.aliustaoglu.tomtom;

import android.view.View;
import android.widget.LinearLayout;

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
        return ttMapView;
    }

    @ReactProp(name = "camera")
    public void setCamera(TTMapView ttMapView, @Nullable ReadableMap camera) {
        ttMapView.setCamera(camera);
    }

    @ReactProp(name = "markers")
    public void setMarkers(TTMapView ttMapView, @Nullable ReadableArray markers) {
        ttMapView.setMarkers(markers);
    }

    @Nullable
    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("onMapReady", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onMapReady")))
                .build();
    }
}
