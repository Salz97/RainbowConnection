
import './App.css';

import React, { Component } from 'react'
import axios from 'axios'
import ReactTable from "react-table"; 
import Table from './container/Table';
import { Link } from 'react-router-dom';



export default class App extends Component {
  constructor(props){
    super(props)
    this.state = {
      users: [],
      isLoading:false,
      isError:false,
      colour:[]
     
    }
  }
 
  componentDidMount() {
  
    const response = axios.get('http://localhost:8081/users').then(res=>{
      console.log(res)
      this.setState({users:res.data}
        
     
     
     
    )
    this.setState({colour:res.data.colour})
    
      }).catch(
        console.log("error")
      )
      
      
  }
  colourChanger(){
   const colourRed={
     color: 'red'
   }
    
    if(this.state.colour=="red"){
     document.getElementById("colour").style.backgroundColor= colourRed
  }
}


  
  
  render() {

  return (
      
      
       <div>
          
           
         <table>
         <thead>
                    <tr>
                        <th>ID</th>
                        <th>FullName</th>
                        <th>Favourite Colour</th>
                        <th>FollowerCount</th>
                        
                    </tr>
                </thead>
                
         
        {this.state.users.map(user => 
                  <tbody>
                   
                  <td>{user.id}</td>
                   <td>{user.firstName}  {user.lastName}</td> 
                  
                   <td id='colour' 
                    style={this.colourChanger()}>{user.colour}</td>
                   <td>{user.followerCount}</td>
                  </tbody>
                     
                    

                  )}
                   
        
       </table>
           
        </div>
     
    )
    
  
    }
    
  }

