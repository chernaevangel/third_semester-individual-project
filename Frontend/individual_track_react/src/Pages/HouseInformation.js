import React from 'react'
import HousePic from '../images/hostel.png';
import "./HouseInformation.css"
import { useHistory } from 'react-router';
import axios from 'axios';
import { useState ,useEffect} from 'react/cjs/react.development';

function HouseInformation({match}) {

    const [item, setItem]=useState({});
    const [landlordName, setLandlordName]=useState('');
    const [user, setFakeUser]=useState(614);
    let token=localStorage.getItem("token")
    let tokenWithoutQuotes=token.replace(/^"(.+)"$/,'$1');
    let userId=localStorage.getItem("userId");
    let userIdWithoutQuotes=userId.replace(/^"(.+)"$/,'$1');

    useEffect(() => { 
        axios.get(`http://localhost:8080/houses/house/${match.params.id}`,{
           headers : {
               'Authorization' : tokenWithoutQuotes
           }
       }).then((response) => { 
         if(response.status===200){
           console.log(response.data);
           setItem(response.data);
           getLandlordName(response.data.landlordId)
         }
         else{
           console.log("error")
         }
         
       });
     }, []); 


     const getLandlordName = (landlordId) => {

      axios.get(`http://localhost:8080/landlords/landlord/${landlordId}`,{
        headers : {
            'Authorization' : tokenWithoutQuotes
        }
    }).then((response) => { 
      if(response.status===200){
        console.log(response.data.name);
         setLandlordName(response.data.name);      
        
      }
          });
  }
  
   
    const history = useHistory();

    const goBackToAvailablePlaces = () =>{
        history.push("/AvailablePlaces")
    }


    const reserveHouse = (e) =>{
      e.preventDefault();
      
       axios
         .post("http://localhost:8080/bookings",{
          "user":{
            "id":userIdWithoutQuotes
          },
          "house":{
             "id": item.id
          },
          "landlord":{
             "id" :item.landlordId
          },
          "pricePerNight": item.pricePerNight
        }, {
          headers : {
              'Authorization' : tokenWithoutQuotes
          }})
         .then((response) => {
   
           if (response.status === 200) {
          
            updateAccessibility()
           }
           else {
             
           }
         })    
    }

    function updateAccessibility(){
      axios.put(`http://localhost:8080/houses/${item.id}`,{
        headers : {
            'Authorization' : tokenWithoutQuotes
        }})
        .then((response) =>{
          if(response.status===204){
            history.push("/AvailablePlaces")
          }
        })
    }
   
    return (
      <div className='aboutusWrapper'>
      <div className='leftSEction'>
  <div className="cOntainer">
    <div className="content-Section">
      
      <div className="goBack"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 14 14">
  <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
</svg><button type="button" class="btn btn-dark" onClick={goBackToAvailablePlaces}> Go back to available places</button></div>
    <div className="tItle">
   <h1><u>Address:</u> {item.address}</h1>
      </div>
      <div className="cOntent">
      <h3>Price per night:</h3>
      <p>{item.pricePerNight}</p>
					<h3>Description:</h3>
					<p>{item.description}</p>
                        
                      <div className="landlord"><h3>Landlord: </h3>
                       <p>{landlordName}</p></div>
     
                       <div className="availability"><h3>Availability:</h3>
                       <p>Available</p></div>

               

        <textarea class="form-control" rows="5" id="comment" name="text" placeholder="Type additional requirements here..."></textarea>
        <div className='butonki'>                     
            <div >
						<button className='buttonAboutus' onClick={reserveHouse}>Reserve</button>
					</div>
          </div>
				</div>
        </div>
  </div>
  </div >
  <div className='rightSection'>
         <div className='picture'>
     <img src={HousePic}/>
     </div>
  </div>
   </div >
  
    )
}

export default HouseInformation
