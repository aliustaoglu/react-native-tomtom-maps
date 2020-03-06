import Foundation
import TomTomOnlineSDKMaps

class TomtomMaps: UIView {
    
    private var tomtomMapView:TTMapView!
    private var props = Props()
    
    @objc var camera: NSDictionary = [:] {
        didSet{
            if (props.camera != nil) {
                props.camera!.update(tomtomMapView, camera)
            }
            
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    override func didSetProps(_ changedProps: [String]!) {
        let mapView = TTMapView(frame: self.bounds)
        self.addSubview(mapView)
        mapView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        
        self.tomtomMapView = mapView
        props.camera = Camera(self.camera)
        props.camera!.update(tomtomMapView, self.camera)
        
        
        //        self.onMapReady!([:])
    }
    
    
    
    
    
    required init(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    
}

