import React from 'react'
import "./APNotLoggedIn.css"
import { useHistory } from 'react-router';

export function APNotLoggedIn() {
    const history = useHistory();

    const goToLogIn = () =>{
        history.push("/LogIn")
    }

    return (
        <div class="container">
  <div class="jumbotron">    
    <h1>To be able to see our available places, please first log in.</h1>
    <div className="gele"><button type="submit" onClick={goToLogIn} className="btn btn-dark">Click here to Log In</button></div>
  </div>
       
</div>
    )
}

export default APNotLoggedIn
