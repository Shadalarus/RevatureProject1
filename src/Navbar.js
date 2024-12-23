import { useContext } from "react";
import {Link} from "react-router-dom";
import UserContext from "./MyContext";
const Navbar = () => {

    const [context, setContext] = useContext(UserContext)
    if(context == 0){
        return(
            <div className="navbar">
                <h2>Shaded Grove Forum</h2>
                <div className="links">
                    <Link to="/home">Home</Link>
                    <Link to="/posts">Posts</Link>
                    <Link to="/users">Users</Link>
                    <Link to="/login">Log-In</Link>
                </div>
            </div>
        );
    }
    else{
        return(
            <div className="navbar">
                <h2>Shaded Grove Forum</h2>
                <div className="links">
                    <Link to="/home">Home</Link>
                    <Link to="/posts">Posts</Link>
                    <Link to="/users">Users</Link>
                    <Link to="/friends">Friends</Link>
                    <Link to="/follows">Follows</Link>
                    <Link to="/account">Account</Link>
                    <Link to="/home" onClick={()=>{setContext(0); console.log(context)}}>Log-Out</Link>
                </div>
            </div>
        );
    }
}

export default Navbar;