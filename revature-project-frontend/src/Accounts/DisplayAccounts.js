import { useContext } from "react";
import UserContext from "../MyContext";
import CreateFollow from "../FollowsAndFriends/CreateFollow";
const DisplayAccounts = ({users}) => {
    
    const [context, setContext] = useContext(UserContext)
    if(context == 0){
        return(
            users.map((user)=>(
                <div key={user.accountId}>
                    <hr/>
                    <h6>{user.accountId}</h6>
                    <h3>{user.username}</h3>
                    <p>{user.firstName} {user.lastName}</p>
                </div>
            ))
        )
    }
    else{
        return(
            users.map((user)=>(
                <div key={user.accountId}>
                    <hr/>
                    <h6>{user.accountId}</h6>
                    <h3>{user.username}</h3>
                    <p>{user.firstName} {user.lastName}</p>
                    <CreateFollow/>
                    <button>Friend</button>
                </div>
            ))
        )
    }
}

export default DisplayAccounts;