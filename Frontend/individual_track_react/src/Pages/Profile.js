import React,{useState} from "react";
import ProfilePic from '../images/profile.jpg';
import "./Profile.css";
import "./Blog.css";
import Reservations from "../Components/Reservations";
import FinishedReservations from "../Components/FinishedReservations";






export const Profile = () => {

  let username="";
  let usernameQuotes="";

  if (localStorage.getItem("username")) {
    username=localStorage.getItem("username");
    usernameQuotes=username.replace(/['"]+/g, '');
  }


  return (
    <div class="card">
  <img src={ProfilePic} alt="Profile image" className="img-thumbnail"/>
  <div className="prfileInfo">
  <h1>Welcome, {usernameQuotes}</h1>
  <div className="updateInfo">
  
  
  
  </div>
   <Reservations/>
  
   <FinishedReservations/>
</div>
</div>
  );
};
export default Profile;