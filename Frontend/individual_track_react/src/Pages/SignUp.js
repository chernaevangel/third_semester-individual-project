import React from 'react';
import { useState } from 'react/cjs/react.development';
import { useHistory } from 'react-router';
import axios from 'axios';
import "./LogIn.css"
import "./SignUp.css"
import Alert from '../Components/Alert';

const baseURL = "http://localhost:8080/users";

export function SignUp() {
  

    const history = useHistory();
    const [username, setName] = useState("");
    const [pass, setPass] = useState("");
    const[email,setEmail]=useState("");
    const [buttonPopup, setButtonPopup]=useState(false);
    const[checkbox, setCheckbox]=useState(false);
    const [landlordEmail, setLandlordEmail]=useState("");
    const [landlordPhone, setLandlordPhone]=useState("");
    const [landlordName, setLandlordName]=useState("");
    const [landlordVerificationCode, setLandlordVerificationCode]=useState("");

    const config = {
      headers: {
        'Content-Type': 'application/json'
      },
      data: {},
      };

    const registerLandlord = () =>{
           
      const data = JSON.stringify({
        name : landlordName,
        email: landlordEmail,
        mobilePhone: landlordPhone,
        verificationCode: landlordVerificationCode
      })
      console.log(data);
        axios
         .post("http://localhost:8080/landlords/newLandlord",data,config)
         .then((response) => {      
           if (response.status === 200) {
            history.push("/LogIn");
            
           }
           else {
             
           }
         })    
    }
    
    
   
    const signUp = (e) => {
      if(checkbox===false){
      e.preventDefault();        
      const data = JSON.stringify({
        username,
        email,
        password: pass
      });
      console.log(data);
       axios
         .post(baseURL, {
             username : username,
             email : email,
             password : pass
         })
         .then((response) => {
             console.log(response.status)
             
           if (response.status === 200) {             
             history.push("/LogIn");
           }
           else {
             console.log("pishka");
           }
         })
        } else{
       }        
        }

        



    return (
      <div className="Mala">
      <form onSubmit={signUp}>
        <div className='registrationTitle'>
                  <h2>Registration</h2>
                  </div>
                  <div className="Form-group">
                      <h4>Username</h4>
                      <input type="text" className="form-control" placeholder="Enter username" onBlur={e => setName(e.target.value)} required/>
                  </div>

                  <div className="ForM-group">
                      <h4>Email</h4>
                      <input type="text" className="form-control" placeholder="Enter email" onBlur={e => setEmail(e.target.value)} required/>
                  </div>
  
                  <div className="Form-group">
                      <h4>Password</h4>
                      <input type="password" className="form-control" placeholder="Enter password" onBlur={e => setPass(e.target.value)} required/>
                  </div>
                 
  
                
  
                  <div className="Gala"><button type="submit" className="btn btn-primary btn-block">Submit</button></div>
                        
              </form>
              <div className="Form-group">
              <hr />
                  <div class="register-landlord">
                    <button type='submit' className='landlordRButton' onClick={() => setButtonPopup(true)}>Register as landlord</button>
                    <Alert trigger={buttonPopup} setTrigger={setButtonPopup}>
                      <div className='registerLanldordPopUp'>
                    <div className='nameEmail'><h4>Full name</h4>
                      <input type="text" className="form-control" placeholder="Enter full name" onBlur={e => setLandlordName(e.target.value)} required/>
                      <h4>Email</h4>
                      <input type="text" className="form-control" placeholder="Enter email" onBlur={e => setLandlordEmail(e.target.value)} required/>
                      </div>
                      <div className='phoneVerNum'>
                      <h4>Mobile phone</h4>
                      <input type="text" className="form-control" placeholder="Enter mobile phone" onBlur={e => setLandlordPhone(e.target.value)} required/>
                      <h4>Verification code</h4>
                      <input type="text" className="form-control" placeholder="Enter verification code" onBlur={e => setLandlordVerificationCode(e.target.value)} required/>
                      </div>
                      <button className='registerLandlordButton' onClick={registerLandlord}>Register</button>
                      </div>
                     </Alert>
                         </div>
                  </div>
              </div>

        
     )
  }

  export default SignUp;

