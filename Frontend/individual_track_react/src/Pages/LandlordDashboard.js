import React ,{useState, useEffect} from 'react'
import { useHistory } from 'react-router';
import "./LandlordDashboard.css";
import axios from "axios"

export function LandlordDashboard() {
    const history = useHistory();

    const [landlordName, setLandlordName]=useState("");
    const [landlordEmail, setLandlordEmail]=useState("");
    const [landlordPhone, setLandlordPhone]=useState("");
    const [landlordVC, setLandlordVC]=useState("");
    const [address, setAddress]=useState("");
    const [description, setDescription]=useState("");
    const [pricePerNight, setPrice]=useState("");
    const [accessible, setAccessibility]=useState(true);
    const [houses, setHouses]=useState([]);
    const [activeReservations, setActiveReservations]=useState([]);
    const [deleteHouseId, setDeleteHouseId]=useState("");

    let landlordIde=localStorage.getItem("landlordId")
    let landlordId=landlordIde.replace(/^"(.+)"$/,'$1');

    const config = {
        headers: {
          'Content-Type': 'application/json'
        },
        data: {},
        };

    const addHouse = (e) => {
        e.preventDefault();
        
        console.log(landlordId);
        
        const data = JSON.stringify({
          address,
          description,
          accessible,
          pricePerNight,
          landlordId,
          landlordName,
          landlordPhone,
          landlordEmail
        });
    
         axios
           .post("http://localhost:8080/houses/newHouse", data,config)
           .then((response) => {
     
             if (response.status === 200) {
            
              window.location.reload();         
             }
             else {
             
             }
           })         
      }


    const logOut = () =>{
        
            localStorage.removeItem("landlordId");
            history.push("/LogIn"); 
            window.location.reload();        
    }

    useEffect(() => { 
        axios.get(`http://localhost:8080/landlords/landlord/${landlordId}`
       ).then((response) => { 
         if(response.status===200){
           console.log(response.data);
           setLandlordName(response.data.name);
           setLandlordPhone(response.data.mobilePhone);
           setLandlordEmail(response.data.email);
           setLandlordVC(response.data.verificationCode);
        
         }
         else{
           console.log("error")
         }
         
       });
     }, []); 

     useEffect(() => { 
        axios.get(`http://localhost:8080/houses/houseLandlord/${landlordId}`
       ).then((response) => { 
         if(response.status===200){
           setHouses(response.data);
           console.log(houses);
        
         }
         else{
           console.log("error")
         }
         
       });
     }, []); 

     useEffect(() => { 
        axios.get(`http://localhost:8080/houses/booked/houseLandlord/${landlordId}`
       ).then((response) => { 
         if(response.status===200){
      
           setActiveReservations(response.data);
         }
         else{
           console.log("error")
         }
         
       });
     }, []); 

     function deleteHouse(){
         axios.delete(`http://localhost:8080/houses/${deleteHouseId}`)
         .then((response)=>{
             if(response.status===200){
                 window.location.reload();
             }
         })
     }
     
    return (
    <div className='landlordDashboardWrapper'>

        <div className='addHouseWrapper'>
            <div className='newHousesWrapper'>
                <h1>Add new house</h1>
                <div className='addHouse'>
            <h4>Address</h4>
             <input type="text" className="information-in" placeholder="Enter address" onBlur={e => setAddress(e.target.value)} required/>
             <h4>Description</h4>
             <input type="text" className="information-in" placeholder="Enter description" onBlur={e => setDescription(e.target.value)} required/>
             <h4>Price per night</h4>
             <input type="text" className="information-in" placeholder="Enter price per night" onBlur={e => setPrice(e.target.value)} required/>
               </div>
               <button className='buton4e' onClick={addHouse}>Add house</button>
   
               <div className='deleteHouseWrapper'>
               <hr/>
               <h2>Povide house id</h2>
             <input type="text" className="information-in" placeholder="Enter house id" onBlur={e => setDeleteHouseId(e.target.value)} required/>
             <button className='buttoniera' onClick={deleteHouse}>DELETE</button>
            </div>
            </div>
            
        </div>
            
         <div className='myHouses'>
                <div className='welcomeMessage'><h1>Hello, {landlordName}</h1>
                <h3><u>Your houses:</u></h3>
                </div>
                {houses.map((houses, id)=>{
                      return(
                        <div className='houseProposal'>
                               <div className='houseId'>
                                 <h3>House ID: {houses.id}</h3>
                               </div>
                               <div className='houseAddress'>
                                <h3>Address: {houses.address}</h3>
                                </div>  

                                <div className='housePrice'>
                                 <h3>Price per Night: {houses.pricePerNight}$</h3>
                                </div> 
                            </div>
                      )
                }
                )}
               
        </div>

         <div className='activeReservations'>
            <button className='loggout-button' onClick={logOut}>LOG OUT</button>
            <h3><u>Active reservations: </u></h3>
            {activeReservations.map((activeReservations, id)=>{
                return(
                       <div className='activeReservation'>
                           <div className='eno'>
                               <h2>House ID: {activeReservations.id}</h2>
                           </div>
                           <div className='dve'>
                           <h2>Address: {activeReservations.id}</h2>
                           </div>
                           <div className='tri'>
                           <h2>Price per night: {activeReservations.id}</h2>
                           </div>
                       </div>
                )
            })}
                
        </div>

    </div>
    )
}

export default LandlordDashboard
