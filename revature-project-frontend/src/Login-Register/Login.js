import { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom"
import axios from "axios";
import UserContext from "../MyContext";


const Login = () => {
    
    const [context, setContext] = useContext(UserContext)
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const clickHandler = (e) => {
        e.preventDefault();
        axios.post(`http://localhost:8080/login/${username}/${password}`)
        .then((res)=>{
            setContext(res.data)
        })
        console.log(context)
        console.log(context.accountId)
        
    }
    
    
    return(
        <>
        <h1>Log-In</h1>
        <form>
            <label>Username: <input type="text" value={username} onChange={(e)=>setUsername(e.target.value)}/></label><br/>
            <label>Password: <input type="password" value={password} onChange={(e)=>setPassword(e.target.value)}/></label><br/>
            <button onClick={clickHandler}>Submit</button>
        </form>
        <br/>
        <p>New to the site? <Link to='/Register'>Register Here</Link></p>
        </>
    )
} 

export default Login