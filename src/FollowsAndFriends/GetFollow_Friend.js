import axios from "axios"
import { useEffect, useState } from "react"

const GetFollow_Friend = ({id}) =>{
    const [users,setUsers]=useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8080/account/${id}`)
        .then(res =>{
            setUsers(res.data)
        })
    },[])

    return(
        <h3>{users.username}</h3>
    )
}
export default GetFollow_Friend