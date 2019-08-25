require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-tomtom-maps"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  react-native-tomtom-maps
                   DESC
  s.homepage     = "https://github.com/aliustaoglu/react-native-tomtom-maps"
  s.license      = "MIT"
  # s.license    = { :type => "MIT", :file => "FILE_LICENSE" }
  s.authors      = { "Cuneyt Aliustaoglu" => "aliustaoglu@yahoo.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/aliustaoglu/react-native-tomtom-maps.git", :tag => "#{s.version}" }
  
  s.swift_version = '5.0'

  s.source_files = "ios/**/*.{h,m,swift}"
  s.requires_arc = true

  s.dependency "React"
  s.dependency 'TomTomOnlineSDKMaps'
  #s.dependency 'AFNetworking', '~> 3.0'
  # s.dependency "..."
end

