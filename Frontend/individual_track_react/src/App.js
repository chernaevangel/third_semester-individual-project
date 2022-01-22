import React, { useEffect, useState } from "react"; 
import "./Components/AllUsers.css";
//import AllUsers from "./Components/AllUsers";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { Home } from "./Pages/Home";
import { AvailablePlaces } from "./Pages/AvailablePlaces.js";
import { Profile } from "./Pages/Profile";
import { LogIn } from "./Pages/LogIn.js";
import { SignUp } from "./Pages/SignUp.js"; 
import {AboutUs} from "./Pages/AboutUs.js"; 
import {LogOut} from "./Pages/LogOut.js"; 
import NavBar from "./Components/Navbar.js" 
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import Footer from "./Components/Footer.js"
import 'bootstrap/dist/css/bootstrap.min.css';

import "./App.css"
import axios from "axios";
import HouseInformation from "./Pages/HouseInformation";
import APNotLoggedIn from "./Pages/APNotLoggedIn";
import BookingInformation from "./Pages/BookingInformation"
import LandlordDashboard from "./Pages/LandlordDashboard";



export default function App() { 

  const [landlordLoggedIn, setLandlordLoggedIn]=useState(false);

  const [loggedIn, setLoggedIn] = useState(false);
  
  const checkIfLoggedIn = () => {
    if(localStorage.getItem("userId")!=null){
      
      return true;
    }
    else{
      return false;
    }
  }


  const checkIfLandlordLoggedIn = () => {
    if(localStorage.getItem("landlordId")!=null){     
      return true;
    }
    else{
      return false;
    }
  }

  return (
  <>
  
  <Router>
  {checkIfLandlordLoggedIn()==false ? <NavBar />  : <LandlordDashboard/>}
        <div className="pages">
          <Switch>
            <Route exact path="/" component={Home} />
            { checkIfLoggedIn()==true ? 
            <Route path="/AvailablePlaces" exact component={AvailablePlaces} /> :
            <Route path="/APNotLoggedIn"  component={APNotLoggedIn} />}
            <Route path="/AvailablePlaces/:id" component={HouseInformation} />
            <Route path="/AboutUs" component={AboutUs}/>
            { checkIfLoggedIn()==true ? 
            <Route path="/Profile" exact component={Profile} />  : 
            <Route path="/LogIn" component={LogIn} />   }   
             { checkIfLoggedIn()==true ? 
            <Route path="/Profile/:id" component={BookingInformation} />  : 
            <Route path="/LogIn" component={LogIn} />   }  
             { checkIfLoggedIn()==true ? 
            <Route path="/Profile/Ended/:id" component={BookingInformation} />  : 
            <Route path="/LogIn" component={LogIn} />   } 
            { checkIfLoggedIn()==true ?               
               <Route path="/LogOut" component={LogOut } />  :
               <Route path="/SignUp" component={SignUp}   /> }
          </Switch>
          </div> 
      </Router>


  
    <div><Footer/></div>
     
    </>
  );
  
}