import React,{ useState ,useEffect} from 'react'
import axios from 'axios'
import { useHistory } from 'react-router';
import "./BookingInformation.css"
 
function BookingInformation({match}) {

    const [item, setItem]=useState({});
    const [email,setEmail]=useState("");
    const [phone,setPhone]=useState("");
    const [address,setAddress]=useState("");
    const [description,setDescription]=useState("");
    const history = useHistory();
    let token=localStorage.getItem("token")
    let tokenWithoutQuotes=token.replace(/^"(.+)"$/,'$1');
  

    useEffect(() => { 
        axios.get(`http://localhost:8080/bookings/booking/${match.params.id}`,{
           headers : {
               'Authorization' : tokenWithoutQuotes
           }
       }).then((response) => { 
         if(response.status===200){
           console.log(response.data);
           setEmail(response.data.landlord.email);
           setPhone(response.data.landlord.mobilePhone)
           setAddress(response.data.house.address);
           setDescription(response.data.house.description);
           setItem(response.data);
           
         }
         else{
           console.log("error")
         }
         
       });
     }, []); 

     const endBooking=()=>{
      axios.put(`http://localhost:8080/bookings/${item.id}`,{
        headers : {
            'Authorization' : tokenWithoutQuotes
        }})
        .then((response) =>{
          if(response.status===204){
            
            updateAccessibility()
          }
        })
    }

    function updateAccessibility(){
      axios.put(`http://localhost:8080/houses/leave/${item.house.id}`,{
        headers : {
            'Authorization' : tokenWithoutQuotes
        }})
        .then((response) =>{
          if(response.status===204){
            goBackToPRofile()
          }
        })
    }
   
    

     const goBackToPRofile = () =>{
        history.push("/Profile")
    }

    return (<div className='bookingInfoPage'>
        <div className="goBack"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 14 14">
  <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
</svg><button type="button" class="btn btn-dark" onClick={goBackToPRofile}> Go back </button></div>
    
    <div className='bookingInfoWrapper'>
        <div className='infoForReservation'>
            <div className='edno'>
            
          <h1><u>Reservation number: {item.id}</u></h1>
          <h4>Price per night: {item.pricePerNight}</h4>
          <button className='leaveHouseButton' onClick={endBooking}>LEAVE HOUSE</button>
          
          </div>
          <div className='shlqp'>
              <h1><u>Information about the house:</u></h1>
              <h4>Address: {address}</h4>
              <h4>Description: {description}</h4>
          </div>
        </div>
        <div className='controllsForReservation'>
            <div className='first'>
        <h1><u>Information about the landlord:</u></h1>     
        <h4>Email: {email}</h4>
        <h4>Telephone: {phone}</h4> 
        </div>
        <div className='second'>
        <textarea class="form-control" rows="5" id="comment" name="text" placeholder="Put here your feedback to the landlord..."></textarea>
		<div >
			<button className="buttonReservations">Send feedback</button>
			</div>
            </div>
        </div>
        </div>
        </div>
    )
}

export default BookingInformation
