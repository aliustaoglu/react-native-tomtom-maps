import Foundation
import TomTomOnlineSDKMaps

class TomtomMaps: TTMapView {
    
    @objc var mapZoom: NSNumber!
    @objc var mapCenter: NSDictionary = [:]
    @objc var onMapReady: RCTDirectEventBlock?
    @objc var markers: NSArray!
    @objc var mapOptions: NSDictionary = [:]
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    override func didSetProps(_ changedProps: [String]!) {
        let lang = mapOptions.object(forKey: "lang") as? String
        if (lang == nil) {
            self.setLanguage("en-US")
        } else {
            self.setLanguage(lang)
        }
        
        let mapView = TTMapView(frame: self.bounds)
        let lat = self.mapCenter.object(forKey: "lat") as! Double
        let lng = self.mapCenter.object(forKey: "lng") as! Double
        
        let zoom = self.mapZoom as! Double
        
        for i in 0...self.markers.count-1 {
            let marker = self.markers[i] as! NSDictionary
            let mLat = marker.object(forKey: "lat") as! Double
            let mLng = marker.object(forKey: "lng") as! Double
            let lbl = marker.object(forKey: "label") as! String
            
            let tilesType = mapOptions.object(forKey: "tilesType") as! String
            if (tilesType.uppercased() == "RASTER") {
                self.setTilesType(TTMapTilesType.raster)
            } else {
                self.setTilesType(TTMapTilesType.vector)
            }
            let is3D = (mapOptions.object(forKey: "perspective") as? String) == "3D"
            if (is3D) {
                self.setPerspective3D(true)
            }
            
            
            let anno = TTAnnotation(coordinate: CLLocationCoordinate2D( latitude: mLat,longitude: mLng))
            self.annotationManager.add(anno)
        }
        
        self.setTilesType(TTMapTilesType.vector)
        
        mapView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        self.center(on: CLLocationCoordinate2D( latitude: lat,longitude: lng), withZoom: zoom )
        
        self.onMapReady!([:])
    }
    
    
    
    
    
    required init(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
}

