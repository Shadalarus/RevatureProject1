import { useEffect, useState } from "react"
import axios from "axios";

const Register = () => {
    
    const[firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confPass, setConfPass] = useState('');

    const clickHandler = (e) => {
        e.preventDefault();
        if(password == confPass){
            addAccount(firstName, lastName, email, username, password);
            alert("Registration Complete");
        }
        else{
            alert("Passwords do not match");
        }
    };
    
    const addAccount = (firstName, lastName, email, username, password) => {
        console.log({
            firstName: firstName,
            lastName: lastName,
            email: email,
            phoneNumber: null,
            username: username,
            password: password
        })
    }

    return(
        <>
        <h1>Register</h1>
        <form>
            <label>First Name: <input type="text" value={firstName} onChange={(e)=>setFirstName(e.target.value)}/></label><br/>
            <label>Last Name: <input type="text" value={lastName} onChange={(e)=>setLastName(e.target.value)}/></label><br/>
            <label>Email: <input type="email" value={email} onChange={(e)=>setEmail(e.target.value)}/></label><br/>
            <label>Username: <input type="text" value={username} onChange={(e)=>setUsername(e.target.value)}/></label><br/>
            <label>Password: <input type="password" value={password} onChange={(e)=>setPassword(e.target.value)}/></label><br/>
            <label>Confirm Password: <input type="password" value={confPass} onChange={(e)=>setConfPass(e.target.value)}/></label><br/>
            <button onClick={clickHandler}>Submit</button>
        </form>
        </>
    )
} 

export default Register