import React,{useState, useEffect} from 'react'
import "./FinishedReservations.css"
import axios from "axios"


function FinishedReservations() {

    let token=localStorage.getItem("token")
    let tokenWithoutQuotes=token.replace(/^"(.+)"$/,'$1');
    let userId=localStorage.getItem("userId");
    let userIdWithoutQuotes=userId.replace(/^"(.+)"$/,'$1');

    const [post, setPost] = useState([]); 

    useEffect(() => { 
        axios.get("http://localhost:8080/bookings/account/ended",{
           headers : {
               'Authorization' : tokenWithoutQuotes
           },
           params: {
             id: userIdWithoutQuotes
           }
       }).then((response) => { 
         if(response.status===200){
           console.log(response.data);
           setPost(response.data);
         }
         else{
           console.log("error")
         }
         
       });
     }, []); 


     return (<div className='finishedReservationsWrapper'>
     {post!="" ? <h1>Old bookings</h1>: <h1>No finished bookings!</h1>}
        {post.map((reservations, id)=> {
            return(
        <>
        
  <div className="ReservationItem">
    <div className="ReserveItemInfo">
      <div className="ShortDescription">
   <div className="Address"><p>Booking id: {reservations.id}</p></div>
   <div className="Address"><p>Address: {reservations.house.address}</p></div>
   <div className="Address"> <p>Price per night: {reservations.pricePerNight}</p></div>
  
   </div>
   
    </div>
    <div className="ReserveItemControll">
    
    
    
    </div>
    </div>
       </>)})}
       </div>
    )
}

export default FinishedReservations
