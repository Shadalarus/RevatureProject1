import { Link, Routes, Route, useNavigate } from "react-router-dom";
import AccountUpdate from "./AccountUpdate";
import axios from "axios";
import { useContext, useEffect, useState } from "react";
import DisplayCurrentAccount from "./DisplayCurrentAccount";
import UserContext from "../MyContext";

const Account = () => {

    const [users,setUsers]=useState([])

    const [context, setContext] = useContext(UserContext)

    useEffect(()=>{
        axios.get(`http://localhost:8080/account/${context.accountId}`)
        .then(res =>{
            setUsers(res.data)
        })
    },[])

    return(
        <>
        <DisplayCurrentAccount users={users}/>
        <br/><hr/><br/>
        <button><Link to='/updateEmail'>Update Email</Link></button>
        <button><Link to='/updatePhone'>Update Phone Number</Link></button>
        <button><Link to='/passwordChange'>Change Password</Link></button>
        </>
    )
}

export default Account;