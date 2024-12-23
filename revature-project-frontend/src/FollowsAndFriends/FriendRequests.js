
import { useContext, useEffect, useState } from "react"
import axios from "axios";
import UserContext from "../MyContext";

import DisplayRequestsReceived from "./DisplayRequests";
const FriendRequests = () => {

    const [context,setContext]=useContext(UserContext)
    const [friends,setFriends]=useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8080/pending/${context.accountId}`)
        .then(res =>{
            setFriends(res.data)
        })
    },[friends])
    return(
        <>
        <h1>Pending Friend Requests</h1>
        <DisplayRequestsReceived friends={friends}/>
        </>
    )
}

export default FriendRequests