//
//  Camera.swift
//  TomtomMaps
//
//  Created by Cüneyt Aliustaoğlu on 28/01/20.
//  Copyright © 2020 Facebook. All rights reserved.
//

import Foundation
import TomTomOnlineSDKMaps

struct Camera {
    private var tomtomMapView: TTMapView?
    
    struct Target {
        var lat: Double?
        var lng: Double?
    }
    
    var target: Target?
    var bearing: Double?
    var zoom: Double?
    var tilt: Double?
    
    init(_ dict:NSDictionary){
        
    }
    
    mutating func update(_ tomtomMapView: TTMapView, _ dict:NSDictionary){
        self.tomtomMapView = tomtomMapView
        
        let target = dict["target"] as? Dictionary<String, Double>
        let zoom = dict["zoom"] as? Double
        let bearing = dict["bearing"] as? Double
        //        let tilt = dict["tilt"] as? Double
        
        if let lat = target?["lat"], let lng = target?["lng"] {
            if (zoom == nil){
                tomtomMapView.center(on: CLLocationCoordinate2D( latitude: lat,longitude: lng) )
            } else {
                tomtomMapView.center(on: CLLocationCoordinate2D( latitude: lat,longitude: lng), withZoom: zoom! )
            }
        }
//        tomtomMapView.setBearing(<#T##degrees: Double##Double#>, coordinate: <#T##CLLocationCoordinate2D#>)
        
        
    }
    
    
    
}
