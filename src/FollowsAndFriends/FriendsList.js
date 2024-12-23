import { Link } from "react-router-dom"
import DisplayFriends from "./DisplayFriends"
import axios from "axios"
import { useContext, useEffect, useState } from "react"
import UserContext from "../MyContext"

const FriendsList = () => {
    
    const [context,setContext]=useContext(UserContext)
    const [friends1,setFriends1]=useState([])
    const [friends2,setFriends2]=useState([])


    useEffect(()=>{
        axios.get(`http://localhost:8080/acceptedFriends/${context.accountId}`)
        .then(res =>{
            setFriends1(res.data)
        })   

        axios.get(`http://localhost:8080/friends/${context.accountId}`)
        .then(res =>{
            setFriends2(res.data)
        })
    },[friends1,friends2])
    
    return(
        <>
        <h1>Your Friends</h1>
        <Link to='/pendingRequests'>Pending Friend Requests</Link>
        <hr/>
        <DisplayFriends.DisplayFriendsReceived friends={friends1}/>
        <DisplayFriends.DisplayFriendsSent friends={friends2}/>
        </>
    )
}

export default FriendsList