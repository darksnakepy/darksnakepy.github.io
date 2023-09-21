import { useEffect, useState, ChangeEvent, useRef } from 'react';
import { MapContainer, TileLayer, Marker, Popup, useMap } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import Map from './Map/Map';
import { layerGroup } from 'leaflet';

const MainPage = () =>{

    const [longitude, setLongitude] = useState("")
    const [latitude, setLatitude] = useState("")
    const [error, setError] = useState("")
    const inputLatitudeChange = useRef<HTMLInputElement>(null), inputLongitudeChange = useRef<HTMLInputElement>(null)


    useEffect(() =>{
        getCurrentLocation()
        console.log(parseFloat(latitude), parseFloat(longitude))
    }, [])

    const sendData = async () =>{
        setError("")
        try{
            if(latitude != "" && longitude != ""){
                console.log(longitude, latitude)
                fetch(`https://api.open-meteo.com/v1/forecast?latitude=${parseFloat(latitude)}&longitude=${parseFloat(longitude)}&hourly=temperature_2m,relativehumidity_2m,precipitation_probability,windspeed_10m`)
                .then(function (response) {
                    return response.json();
                })
                .then(function (data) {
                    console.log(data.hourly.time)
                    console.log(data.hourly.temperature_2m)
                })
            }else{
                setError("Please insert the latitude and longitude")
            }

        }catch(e){
            console.log(e)
        }
    }


    const getCurrentLocation = async () => {
        const permission = await navigator.permissions.query({ name: 'geolocation' });
        navigator.geolocation.getCurrentPosition((position) => {
        const currentLatitude = position.coords.latitude;
        const currentLongitude = position.coords.longitude;
        setLatitude(currentLatitude.toString());
        setLongitude(currentLongitude.toString());
        })
    }

    return(
        <div className="w-screen h-screen flex flex-col justify-center items-center">
            <div className="">
                <h1 className="text-[40px] text-white">Weather App</h1>
                <h2 className="text-white ">Insert the latitude and longitude </h2>
            </div>
            <Map currentLocation={[parseFloat(latitude), parseFloat(longitude)]}/>
            <div className="mt-5 flex flex-row ">
                <input type="text" placeholder="Latitude" onChange={(e: ChangeEvent<HTMLInputElement>) => setLatitude(e.target.value)} className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"/> 
                <input type="text" placeholder="Longitude" onChange={(e: ChangeEvent<HTMLInputElement>) => setLongitude(e.target.value)} className="ml-6 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"/> 
                <button className="bg-blue-700 hover:bg-blue-800 text-white py-2 px-10 rounded-lg ml-6" onClick={sendData}>
                    Submit
                </button>
            </div>
            <div className="text-white mt-2">{error}</div>
        </div>
    )
}

export default MainPage