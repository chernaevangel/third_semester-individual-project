import React,{useState} from "react";
import { NavLink } from "react-router-dom";
import "./Navbar.css"

function NavBar() {
    const [click, setClick] = useState(false);
  
    const handleClick = () => setClick(!click);
    return (
      <>
        <nav className="navbar">
          <div className="nav-container">
            <NavLink exact to="/" className="nav-logo">
            CHACE PLACE
              <i className="fas fa-code"></i>
            </NavLink>
  
            <ul className={click ? "nav-menu active" : "nav-menu"}>
              <li className="nav-item">
                <NavLink
                  exact
                  to="/"
                  activeClassName="active"
                  className="nav-links"
                  onClick={handleClick}
                >
                  Home
                </NavLink>
              </li>
              {localStorage.getItem("userId")!==null ?
              <li className="nav-item">
                <NavLink
                  exact
                  to="/AvailablePlaces"
                  activeClassName="active"
                  className="nav-links"
                  onClick={handleClick}
                >
                  Available places
                </NavLink>
              </li>  :  <li className="nav-item">
                <NavLink
                  exact
                  to="/APNotLoggedIn"
                  activeClassName="active"
                  className="nav-links"
                  onClick={handleClick}
                >
                   Available Places
                </NavLink>
              </li>}        
              <li className="nav-item">
                <NavLink
                  exact
                  to="/AboutUs"
                  activeClassName="active"
                  className="nav-links"
                  onClick={handleClick}
                >
                  About Us
                </NavLink>
              </li>
              {localStorage.getItem("userId")!==null ?
               <li className="nav-item">
                <NavLink
                  exact
                  to="/Profile"
                  activeClassName="active"
                  className="nav-links"
                  onClick={handleClick}
                >
                  Profile
                </NavLink>
              </li> :
               <li className="nav-item">
                <NavLink
                  exact
                  to="/LogIn"
                  activeClassName="active"
                  className="nav-links"
                  onClick={handleClick}
                >
                  Log In
                </NavLink>
              </li> }

              {localStorage.getItem("userId")!==null ?
              <li className="nav-item">
              <NavLink
                exact
                to="/LogOut"
                activeClassName="active"
                className="nav-links"
                onClick={handleClick}
              >
                LogOut
              </NavLink>
            </li>:
              <li className="nav-item">
                <NavLink
                  exact
                  to="/SignUp"
                  activeClassName="active"
                  className="nav-links"
                  onClick={handleClick}
                >
                  Sign Up
                </NavLink>
              </li> 
              }
            </ul>
            <div className="nav-icon" onClick={handleClick}>
              <i className={click ? "fas fa-times" : "fas fa-bars"}></i>
            </div>
          </div>
        </nav>
      </>
    );
  }
  
  export default NavBar;