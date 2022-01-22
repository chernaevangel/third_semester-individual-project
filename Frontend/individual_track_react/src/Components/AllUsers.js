import axios from "axios"; 
import React from "react"; 
import './AllUsers.css';
 
const baseURL = "http://localhost:8080/users"; 
 
/*export default function AllUsers() { 
  const [post, setPost] = React.useState(null); 
 
  React.useEffect(() => { 
    axios.get(baseURL).then((response) => { 
      setPost(response.data); 
    }); 
  }, []); 
 
  if (!post) return null; 
 
  return ( 
    <table>
      <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Username</th>
        <th>Password</th>
        </tr>
      {post.map(p => (
      <tr>
          <td>{p.id}</td>
          <td>{p.email}</td>
          <td>{p.username}</td>
          <td>{p.password}</td>
        </tr>
      ))} 
    </table>
  ); 
}*/