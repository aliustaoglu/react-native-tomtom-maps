package biz.aliustaoglu.tomtom;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.tomtom.online.sdk.map.MapView;
import com.tomtom.online.sdk.map.OnMapReadyCallback;
import com.tomtom.online.sdk.map.TomtomMap;

import biz.aliustaoglu.tomtom.props.TTCamera;


public class TTMapView extends MapView implements OnMapReadyCallback {
    public Boolean isMapReady;
    public TomtomMap tomtomMap;
    ThemedReactContext context;
    // Props
    TTCamera ttCamera;

    public TTMapView(@NonNull ThemedReactContext context) {
        super(context);
        this.isMapReady = false;
        this.context = context;
        this.onResume();
        this.addOnMapReadyCallback(this);

    }

    public void setCamera(ReadableMap camera) {
        if (ttCamera == null) {
            this.ttCamera = new TTCamera(this, camera);
        } else {
            this.ttCamera.update(camera);
        }
    }


    @Override
    public void onMapReady(@NonNull TomtomMap tomtomMap) {
        this.isMapReady = true;
        this.tomtomMap = tomtomMap;

        if (this.ttCamera != null) this.ttCamera.refresh();
    }


}
