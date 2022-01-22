import React,{useState, useEffect} from "react";
import AvailablePlace from "../Components/AvailablePlace";
import {FakeHouses} from "../FakeData/FakeHouses"
import "./AvailablePlaces.css"
import { FilterByAddress } from "../Components/FilterByAddress";
import { FilterByPrice } from "../Components/FilterByPrice";
import axios from "axios"
import { Link } from "react-router-dom";

const baseURL = "http://localhost:8080/houses";

export const AvailablePlaces = () => {



let token=localStorage.getItem("token")
let tokenWithoutQuotes=token.replace(/^"(.+)"$/,'$1');

 
  const [post, setPost] = useState([]); 
  const [filter, setFilter] = useState(''); 
  const [priceValue, setPriceValue]=useState('');
  const [priceChecker, setPriceChecker]=useState(false); 
  const [placesByPrice, setPlacesByPrice]=useState([]);

  const searchText = (event) =>{
    setFilter(event.target.value);
  }

  const searchPriceFilter = (event) =>{
    setPriceValue(event.target.value);
  }
  
 
  let dataSearch = post.filter(item=>{
      return Object.keys(item).some(key=>
       item[key].toString().toLowerCase().includes(filter.toString().toLowerCase())
    )  
  }) 

  const checkIfLoggedIn = () => {
    if(localStorage.getItem("userId")!=null){     
      return true;
    }
    else{
      return false;
    }
  }

  const getPlacesFilteredByPrice =() =>{
    let price=parseInt(priceValue);
    
   
    axios.get("http://localhost:8080/houses/byPrice", {
      headers : {
          'Authorization' : tokenWithoutQuotes
      },
      params : {
          price
      }
  })
        .then((response) => {
            if (response.status === 200) {    
            
              setPlacesByPrice(response.data);
              setPost(response.data);
            }
        });    
  }

console.log(placesByPrice);

 

  useEffect(() => { 
   axios.get("http://localhost:8080/houses",{
      headers : {
          'Authorization' : tokenWithoutQuotes
      }
  }).then((response) => { 
    if(response.status===200){
       console.log(response.data)
        setPost(response.data);      
      
    }
    else{
      console.log("error")
    }
    
  });
}, []); 
  
  return (
  
    <div className="menu">
      <h1 className="menuTitle">OUR AVAILABLE PLACES!</h1>
      <div  className="filt">
      <div id="addressFilter" className="adrFilter"><h2>Search address</h2>
         <div class="form-outline">
             <input  type="search" id="form1" className="form-control" placeholder="Type address"
              aria-label="Search" value={filter} onChange={searchText.bind(this)}/>
        </div>
       </div>
      <div id="priceFilter" className="prFilter">  <h2>Choose to what price range you look</h2> 
        <input className="iSearchByPrice" placeholder="Type price" value={priceValue} onChange={searchPriceFilter.bind(this)}></input> 
        <button className="bSearchByPrice" onClick={getPlacesFilteredByPrice}><p>Filter by price</p></button>
        </div>
      </div>
       <div className="menuList">
         { dataSearch.map((availablePlace, id)=> {  
            return(  <div>
              <AvailablePlace 
              key={id}
              image={availablePlace.image}
              address={availablePlace.address}
              price={availablePlace.pricePerNight}
              landlord={availablePlace.landlordId}
             /> <Link to={`/AvailablePlaces/${availablePlace.id}`}><button className="ken">VIEW THE HOUSE</button> </Link>
            </div>
            )
          })
        } 
       </div>
    </div>

  );
  
};

export default AvailablePlaces;