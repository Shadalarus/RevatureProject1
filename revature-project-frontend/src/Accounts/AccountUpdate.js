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

    const handleSubmit = (e) => {
        e.preventDefault();
        updateMail(context.accountId,email);
        
    };

    const updateMail = (id,email) =>{
        axios.put(`http://localhost:8080/updateEmail/${id}/${email}`,{
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
        <form onSubmit={handleSubmit}>
            <label>Enter new email: <input type="email" value={email} onChange={(e)=>setEmail(e.target.value)}/></label>
            <input type="submit"/>
        </form>
    )

    const updatePhone = (
        <form>
            <label>Enter new phone number: <input type="text"/></label>
            <label>Enter password: <input type="password"/></label>
            <input type="submit"/>
        </form>
    )

    const updatePassword = (
        <form>
            <label>Enter new password: <input type="password"/></label>
            <label>Confirm password: <input type="password"/></label>
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