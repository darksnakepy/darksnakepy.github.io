import React, { ChangeEvent, useState } from "react"

const MainPage = () =>{

    const [longitude, setLongitude] = useState(0)
    const [latitude, setLatitude] = useState(0)

    const sendData = () =>{


        
    }

    return(
        <div className="w-screen h-screen flex flex-col justify-center items-center ">
            <div className="">
                <h1 className="text-[24px] text-white ">Weather App</h1>
                <h2 className="text-white ">Insert the latitude and longitude </h2>
            </div>
            <div className="mt-5">
                <input type="text" placeholder="Latitude" onChange={(e: ChangeEvent<HTMLInputElement>) => setLatitude(e.target.value)} className=""/> 
                <input type="text" placeholder="Longitude" onChange={(e: ChangeEvent<HTMLInputElement>) => setLongitude(e.target.value)} className=""/> 
            </div>
            <div className="mt-5">
                <button className="bg-blue-700 hover:bg-blue-800 text-white font-bold py-2 px-4 rounded-lg ">
                    Submit
                </button>
            </div>
        </div>
    )
}

export default MainPage