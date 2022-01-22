import React,{useState} from 'react'
import "./AboutUs.css"
import ProfilePic from '../images/profile.jpg';
import { Route } from "react-router-dom";
import axios from 'axios';

const baseURL="http://localhost:8080/feedbacks";

export function AboutUs() {
   
	const [feedback, setFeedback]=useState("");


	const config = {
		headers: {
			'Content-Type': 'application/json'
		},
		data: {},
	  };

   const sendFeedback = () =>{
   const data=JSON.stringify({
	   feedback
   })
   console.log(data);
   axios.post(baseURL, data,config )
   .then((response) =>{
	   if(response.status===200){
		   console.log("success")
		  window.location.reload();
	   }
   })
   }
	

    return (
       <div className='aboutUsWrapper'>
        <div className='leftSection'>
		<div className="container">
			<div className="content-section">
				<div className="title">
					<h1><u>About Us</u></h1>
				</div>
				<div className="content">
					<h3>This is the team that maintain and supervise the platform</h3>
					<p>The team of Chace Place is represented it's main developer and creator
                        Angel Chernaev. The platform was created for people that are looking for a comfortable and affordable
                        place to stay for a day or two. Our main goal is to make searching for such place more easier and faster. We also
                        give opportunity for people who want to rent out their places, to do so over the Chace Place website.</p>
                        

                       <p>Email: chernaevangel@gmail.com</p>
     
                        <p>Telephone number: +359885433444</p>
                        <p>Facebook: https://www.facebook.com/archito.374/</p>
						<textarea class="form-control" rows="5" id="comment" name="text" onBlur={e => setFeedback(e.target.value)} placeholder="Put here your feedback to the administrators..."></textarea>
					<div >
						<button  className="buttonAboutUs" onClick={sendFeedback} >Send feedback</button>
					</div>
				</div>
                <div>
        </div>
      </div>
	  </div>
		</div>
		<div className='rightSection'>
           <div className='picture'>
		   <img src={ProfilePic}/>
		   </div>
		</div>
	   </div>
    )
}

export default AboutUs
