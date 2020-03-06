package biz.aliustaoglu.tomtom.props;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.tomtom.online.sdk.common.location.LatLng;
import com.tomtom.online.sdk.map.CameraPosition;
import com.tomtom.online.sdk.map.TomtomMap;

import biz.aliustaoglu.tomtom.TTMapView;

public class TTCamera {
    TTMapView ttMapView;
    TomtomMap tomtomMap;
    ReadableMap camera;

    public TTCamera(TTMapView ttMapView, ReadableMap camera) {
        this.ttMapView = ttMapView;
        update(camera);
    }

    public void update(ReadableMap camera) {
        this.camera = camera;
        refresh();
    }

    public void refresh() {
        if (!ttMapView.isMapReady) return;
        this.tomtomMap = ttMapView.tomtomMap;

        ReadableMap target = camera.getMap("target");
        CameraPosition.CameraPositionBuilder cameraPositionBuilder = CameraPosition.builder();
        cameraPositionBuilder = cameraPositionBuilder.focusPosition(new LatLng(target.getDouble("lat"), target.getDouble("lng")));
        if (camera.hasKey("zoom"))
            cameraPositionBuilder = cameraPositionBuilder.zoom(camera.getDouble("zoom"));
        if (camera.hasKey("bearing"))
            cameraPositionBuilder = cameraPositionBuilder.bearing(camera.getDouble("bearing"));
        if (camera.hasKey("tilt"))
            cameraPositionBuilder = cameraPositionBuilder.pitch(camera.getDouble("tilt"));

        CameraPosition cameraPosition = cameraPositionBuilder.build();


        if (camera.hasKey("padding")) {
            ReadableArray arr = camera.getArray("padding");
            tomtomMap.setPadding(arr.getDouble(1), arr.getDouble(0), arr.getDouble(3), arr.getDouble(2));
        }

        tomtomMap.centerOn(cameraPosition);
    }
}
