import React,{useState, useEffect} from 'react'
import "./Reservations.css"
import axios from "axios"
import { Link } from "react-router-dom";

import Alert from './Alert';



function Reservations() {

    let token=localStorage.getItem("token")
    let tokenWithoutQuotes=token.replace(/^"(.+)"$/,'$1');
    let userId=localStorage.getItem("userId");
    let userIdWithoutQuotes=userId.replace(/^"(.+)"$/,'$1');

    const [post, setPost] = useState([]); 
    const [house, setHouse] = useState(""); 
    

    useEffect(() => { 
        axios.get("http://localhost:8080/bookings/account",{
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
    

    
    return (<div className='reservationsWrapper'>
    {post!="" ? <div className='activeBookings'><h1>Active bookings</h1></div> :
    <div className='activeBookings'><h1>No active bookings yet!</h1></div>}
        {post.map((reservations, id)=> {
            return(
        <>
        <h1><u>#{id+1}.Booking</u></h1>
  <div className="reservationItem">
    <div className="reserveItemInfo">
      <div className="shortDescription">
   <div className="address"><p>{reservations.house.address}</p></div>
   <div className="address"> <p>Arriving date: 12/03/2021</p></div>
   <div className="address"><p>Leaving date: 17/03/2021</p></div>
   </div>
    <Link to={`/Profile/${reservations.id}`}><button type="button" class="btnBooking">See booking</button></Link>
    </div>
    <div className="reserveItemControll">
    
    
    
     
    </div>
    </div>
       </>)})}
       </div>
    )
}

export default Reservations
