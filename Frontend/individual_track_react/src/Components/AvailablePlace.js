import React,{useState, useEffect} from "react";
import "./AvailablePlace.css";
import PropertyImage from '../images/hostel.png';
import { useHistory} from 'react-router';
import axios from "axios"

function AvailablePlace({image, address,price, landlord}){
  const history = useHistory();
  const [landlordName, setLandlordName]=useState('');


  let token=localStorage.getItem("token")
  let tokenWithoutQuotes=token.replace(/^"(.+)"$/,'$1');

  useEffect(() => { 
    axios.get(`http://localhost:8080/landlords/landlord/${landlord}`,{
       headers : {
           'Authorization' : tokenWithoutQuotes
       }
   }).then((response) => { 
     if(response.status===200){
       console.log(response.data.name);
        setLandlordName(response.data.name);      
       
     }
     else{
       console.log("error")
     }
     
   });
 }, []); 


const getProperty = () => {
history.push("/HouseInformation")
}

    return(    
<div class="container mt-3" >
<div class="carD" onClick={getProperty}>
  <img class="card-img-top" src={PropertyImage} alt="Card image" />
  <div class="card-body">
    <h2 class="card-title">{address}</h2>
    <h3 class="card-text">Price per night: {price}$</h3>
    <h3 class="card-text">Landlord: {landlordName}</h3>
    </div>
</div>
</div>
);
}

export default AvailablePlace;
