package biz.aliustaoglu.tomtom.props;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.tomtom.online.sdk.common.location.LatLng;
import com.tomtom.online.sdk.map.Marker;
import com.tomtom.online.sdk.map.MarkerBuilder;
import com.tomtom.online.sdk.map.TomtomMap;

import java.util.ArrayList;
import java.util.List;

import biz.aliustaoglu.tomtom.TTMapView;

public class TTMarkers {
    TTMapView ttMapView;
    TomtomMap tomtomMap;
    ReadableArray markers;

    public TTMarkers(TTMapView ttMapView, ReadableArray markers) {
        this.ttMapView = ttMapView;
        this.markers = markers;
    }

    public void update(ReadableArray markers) {
        this.markers = markers;
        refresh();
    }

    public void refresh() {
        if (!ttMapView.isMapReady) return;
        this.tomtomMap = ttMapView.tomtomMap;

        List<String> existingMarkerIDs = getMarkerTags(tomtomMap.getMarkers());
        List<String> removedMarkerIDs = (List<String>) ((ArrayList) existingMarkerIDs).clone();


        for (int i = 0; i < this.markers.size(); i++) {
            ReadableMap marker = markers.getMap(i);
            String markerId = marker.getString("id");

            removedMarkerIDs.remove(markerId);
            if (!existingMarkerIDs.contains(markerId)) {
                addMarker(marker);
            } else {
                updateMarker(marker);
            }
        }

        removeMarkers(removedMarkerIDs);

    }

    private List<String> getMarkerTags(List<Marker> markers) {
        List<String> tags = new ArrayList<>();
        for (int i = 0; i < markers.size(); i++) {
            tags.add(markers.get(i).getTag().toString());
        }
        return tags;
    }

    public void addMarker(ReadableMap marker) {
        double lat = marker.getDouble("lat");
        double lng = marker.getDouble("lng");
        String id = marker.getString("id");

        LatLng position = new LatLng(lat, lng);
        MarkerBuilder markerBuilder = new MarkerBuilder(position).tag(id);

        tomtomMap.addMarker(markerBuilder);
    }

    private void removeMarkers(List<String> markerIDs) {
        for (int i = 0; i < markerIDs.size(); i++) {
            tomtomMap.removeMarkerByTag(markerIDs.get(i));
        }
    }

    private void updateMarker(ReadableMap marker){
        String tag = marker.getString("id");
        tomtomMap.removeMarkerByTag(tag);
        addMarker(marker);
    }


}
