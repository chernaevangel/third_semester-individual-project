import React from 'react'
import { useHistory } from 'react-router';


export function LogOut() {
      
    const history = useHistory();
  
    if (localStorage.getItem("userId")!==null) {
          localStorage.removeItem("token");
          localStorage.removeItem("userId");
          localStorage.removeItem("username");
          history.push("/LogIn"); 
          window.location.reload();
    }
    
    return (
        <div>
            
        </div>
    )
}

export default LogOut
