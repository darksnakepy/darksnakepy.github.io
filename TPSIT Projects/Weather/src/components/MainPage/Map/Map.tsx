import { MapContainer, TileLayer, Marker, useMapEvents, Popup } from 'react-leaflet'
import { useState } from 'react';
import "leaflet/dist/leaflet.css"
import { marker } from 'leaflet';

interface MapProps {
  currentLocation?: [number, number]
}

// When the user clicks on the map, the marker will appear at the clicked location with the correct lat & lng values 

const MarkerClick = ({ onMapClick }: { onMapClick: (lat: number, lon: number) => void }) =>{ //
    const map = useMapEvents({click: (e)=> {
      const { lat, lng } = e.latlng
      onMapClick(lat, lng)
      console.log(lat, lng)
    }
    })
    return null
}

const Map = ({currentLocation} : MapProps) => {

  const [markerPosition, setMarkerPosition] = useState<[number, number]>() // we can set the latitude and longitude's values using this hook

    const handleMapClick = (lat: number, lon: number) => {  // handle click function to set the marker position
      setMarkerPosition([lat, lon]);
    };

    return(
      <MapContainer center={currentLocation} className="w-1/2 h-2/4 mt-4 overflow-hidden outline-none z-10" zoom={13}>
        <TileLayer
          url="https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.carto.com/attribution">CartoDB</a> contributors'
        />
        <MarkerClick onMapClick={handleMapClick}/>
        {markerPosition && <Marker position={markerPosition}> 
                              <Popup>{markerPosition}</Popup>
                            </Marker>} {/* displays the marker */}
      </MapContainer>
  )
}

export default Map
