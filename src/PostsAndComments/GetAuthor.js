import axios from "axios"
import { useEffect, useState } from "react"

const GetAuthor = ({id}) =>{
    const [users,setUsers]=useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8080/account/${id}`)
        .then(res =>{
            setUsers(res.data)
        })
    },[])

    return(
        <p>-{users.username}</p>
    )
}
export default GetAuthor