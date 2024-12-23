import { useEffect, useState } from "react"
import axios from "axios";
import DisplayAccounts from "./DisplayAccounts";
const AccountList = () => {
    
    const [users,setUsers]=useState([])

    useEffect(()=>{
        axios.get("http://localhost:8080/users")
        .then(res =>{
            setUsers(res.data)
        })
    },[users])

    return(
        <>
        <h1>Current Users</h1>
        <div><DisplayAccounts users={users}/></div>
        </>
    )
}

export default AccountList