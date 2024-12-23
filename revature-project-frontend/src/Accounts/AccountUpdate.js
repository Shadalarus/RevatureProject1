import { useContext, useState } from "react"
import axios from "axios";
import UserContext from "../MyContext";
import userEvent from "@testing-library/user-event";


const AccountUpdate = ({updateType}) => {
    
    const [context, setContext] = useContext(UserContext)
    const [email, setEmail]=useState('');
    const [phoneNum, setPhoneNum]=useState('');
    const [password, setPassword]=useState('');
    const [confPass, setConfPass]=useState('');

    const handleSubmitMail = (e) => {
        e.preventDefault();
        updateMail(context.accountId,email);
        
    };

    const handleSubmitPhone = (e) => {
        e.preventDefault();
        updatePhoneNum(context.accountId,phoneNum);
        
    };

    const handleSubmitPass = (e) => {
        e.preventDefault();
        if(confPass==password){
            updatePass(context.accountId,password);
        }
        else{
            alert("Passwords do not match")
        }
        
        
    };

    const updateMail = (id,email) =>{
        axios.patch(`http://localhost:8080/updateEmail/${id}/${email}`,{
            accountId: id,
            firstName: context.firstName,
            lastName: context.lastName,
            email: email,
            phoneNumber: context.phoneNumber,
            username: context.username,
            password: context.password
        })
    }

    const updatePhoneNum = (id,phoneNumber) =>{
        axios.patch(`http://localhost:8080/updatePhone/${id}/${phoneNumber}`,{
            accountId: id,
            firstName: context.firstName,
            lastName: context.lastName,
            email: email,
            phoneNumber: context.phoneNumber,
            username: context.username,
            password: context.password
        })
    }

    const updatePass = (id,password) =>{
        axios.patch(`http://localhost:8080/updatePass/${id}/${password}`,{
            accountId: id,
            firstName: context.firstName,
            lastName: context.lastName,
            email: email,
            phoneNumber: context.phoneNumber,
            username: context.username,
            password: context.password
        })
    }
        

    const updateEmail = (
        <form onSubmit={handleSubmitMail}>
            <label>Enter new email: <input type="email" value={email} onChange={(e)=>setEmail(e.target.value)}/></label>
            <input type="submit"/>
        </form>
    )

    const updatePhone = (
        <form onSubmit={handleSubmitPhone}>
            <label>Enter new phone number: <input type="text" value={phoneNum} onChange={(e)=>setPhoneNum(e.target.value)}/></label>
            <input type="submit"/>
        </form>
    )

    const updatePassword = (
        <form onSubmit={handleSubmitPass}>
            <label>Enter new password: <input type="password" value={password} onChange={(e)=>setPassword(e.target.value)}/></label>
            <label>Confirm new password: <input type="password" value={confPass} onChange={(e)=>setConfPass(e.target.value)}/></label>
            <input type="submit"/>
        </form>
    )

    if(updateType == 1){
        return(updateEmail)
    }
    if(updateType == 2){
        return(updatePhone)
    }
    if(updateType == 3){
        return(updatePassword)
    }
    
}

export default AccountUpdate;