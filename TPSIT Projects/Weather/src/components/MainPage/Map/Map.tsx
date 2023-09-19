import { MapContainer, TileLayer, Marker } from 'react-leaflet'
import "leaflet/dist/leaflet.css"

const Map = () => {
    const position = [51.505, -0.09]

    return(
        <MapContainer>
          <Marker position={position}>
          </Marker>
        </MapContainer>
      )
}

export default Map
