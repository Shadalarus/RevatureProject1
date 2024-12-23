import DisplayFollows from "./DisplayFollows"
import { useContext, useEffect, useState } from "react"
import axios from "axios";
import UserContext from "../MyContext";
const FollowsList = () => {

    const [context,setContext]=useContext(UserContext)
    const [follows,setFollows]=useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8080/follow/${context.accountId}`)
        .then(res =>{
            setFollows(res.data)
        })
    },[follows])
    return(
        <>
        <h1>Your Follows</h1>
        <DisplayFollows follows={follows}/>
        </>
    )
}

export default FollowsList