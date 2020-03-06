import Foundation
import TomTomOnlineSDKMaps

@objc(TomtomViewManager)
class TomtomViewManager: RCTViewManager {
    
    override func view() -> UIView {
        let ttMap = TomtomMaps(frame: CGRect(x:0, y:0, width: 0, height: 0))
        return ttMap
    }
}
