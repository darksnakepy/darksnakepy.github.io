import { MapContainer, TileLayer, Marker, useMapEvents  } from 'react-leaflet'
import { useState } from 'react';
import "leaflet/dist/leaflet.css"

interface MapProps {
  currentLocation?: [number, number]
}

const Map = ({currentLocation} : MapProps) => {

    const [markers, setMarkers] = useState<[number, number][]>([]);

    const addMarker = (e: any) => {
      const newMarker = [e.latlng.lat, e.latlng.lng];
      
    };

    return(
      <MapContainer center={currentLocation} className="w-1/2 h-2/4 mt-4 overflow-hidden outline-none z-10" zoom={13}>
        <TileLayer
          url="https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.carto.com/attribution">CartoDB</a> contributors'
        />
      </MapContainer>
  )
}

export default Map
