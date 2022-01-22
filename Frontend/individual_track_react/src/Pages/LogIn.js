import axios from 'axios';
import React, { useState } from 'react';
import { useHistory } from 'react-router';
import {useCookies} from 'react-cookie';
import "./LogIn.css"
import { Link } from "react-router-dom";
import reactDom from 'react-dom';
import Cookies from 'universal-cookie';
import Alert from '../Components/Alert';

const baseURL = "http://localhost:8080/login";


const loginURL = "http://localhost:8080/users/user";

export function LogIn() {

  let tokenValue = "";
  let splitToken="";
  let loggedUserId= 0;
  const history = useHistory();
  const [username, setName] = useState("");
  const [pass, setPass] = useState("");
  const [user, setUser]=useState("");
  const [landlordEmail,setLandlordEmail]=useState("");
  const [landlordVerificationCode,setLandlordVerificationCode]=useState("");
  const [buttonPopup, setButtonPopup]=useState(false);


  const logIn = (e) => {
    e.preventDefault();
    
    
    const data = JSON.stringify({
      username,
      password: pass
    });
    console.log(data);
     axios
       .post(baseURL, data)
       .then((response) => {
 
         if (response.status === 200) {
        
           if(response.headers.authorization)
           {
        
             tokenValue= response.headers.authorization;
             verifyToken(tokenValue,username,pass);           
             //localStorage.setItem('token',JSON.stringify(response.data));
             //localStorage.setItem('userId',JSON.stringify(response.data.id));  
              
           }
           history.push("/Profile");  
       
           //call a methdod which sets the cookies with user id and token value
         }
         else {
           //if pass is wrong can state a message on the ui
         }
       })         
  }

  const landlordLogin = (e) => {
    e.preventDefault();
  
     axios
       .get("http://localhost:8080/landlords/landlord", {
         params: {
           code: landlordVerificationCode,
           email: landlordEmail
         }
       })
       .then((response) => {
 
         if (response.status === 200) {
      
          localStorage.setItem("landlordId",JSON.stringify(response.data.id));
          history.push("/LandlordDashboard");
          window.location.reload();
         }
         else {
           
         }
       })         
  }

  const verifyToken = (token,username,password) => {

    axios.get(loginURL, {
      headers : {
          'Authorization' : token
      },
      params : {
          username : username,
          password : password
      }
  })
        .then((response) => {
            if (response.status === 200) {
                localStorage.setItem("userId",JSON.stringify(response.data.id));
                localStorage.setItem("token",JSON.stringify(token));
                localStorage.setItem("username",JSON.stringify(response.data.username));
                window.location.reload();
            }
        });
}



 
  return (
    <div className="mala">
    <form onSubmit={logIn}>
      <div className='loginTitle'>
                <h2>LOG IN</h2>
                </div>
                <div className="form-group">
                    <h4>Username </h4>
                    <input type="text" className="form-control" placeholder="Enter username" onBlur={e => setName(e.target.value)} required/>
                </div>

                <div className="form-group">
                    <h4>Password</h4>
                    <input type="password" className="form-control" placeholder="Enter password" onBlur={e => setPass(e.target.value)} required/>
                </div>

                <div className="form-group">
                    
                </div>

                <div className="gala"><button type="submit" className="btn btn-primary btn-block">Submit</button></div>
                
               
            </form>
            <div className='notLoggedIn'><p>Not registered yet? <Link to='SignUp'>Sign up</Link></p></div>
            <div className="Form-group">
            <hr />
                  <div class="register-landlord">
                    <button type='button' className='landlordRButton'  onClick={() => setButtonPopup(true)}>Login as landlord</button>
                    <Alert trigger={buttonPopup} setTrigger={setButtonPopup}>
                    <div className='landlordLogin'>
                     <h4>Email</h4>
                      <input type="text" className="form-control-email" placeholder="Enter email" onBlur={e => setLandlordEmail(e.target.value)} required/>
                      <h4>Verification code</h4>
                      <input type="text" className="form-control-verCo" placeholder="Enter verification code" onBlur={e => setLandlordVerificationCode(e.target.value)} required/>
                      
                     </div>
                     <button className='loginLandlordButton' onClick={landlordLogin}>Log In</button>
                    </Alert>
                         </div>
                  </div>
           
            </div>
  )
}

  
 
export default LogIn;
