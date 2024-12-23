import { useEffect, useState } from "react"
import axios from "axios";
import DisplayAccounts from "./DisplayAccounts";
const AccountList = () => {
    
    const [users,setUsers]=useState([])
    const [text,setText]=useState("")

    useEffect(()=>{
        axios.get("http://localhost:8080/users")
        .then(res =>{
            setUsers(res.data)
        })
    },[users])

    return(
        <>
        <h1>Current Users</h1>
        <input type="text" value={text} placeholder="" onChange={(e)=>setText(e.target.value)}/>
        <div><DisplayAccounts users={users} userFilter={text}/></div>
        </>
    )
}

export default AccountList