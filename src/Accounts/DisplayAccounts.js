import { useContext } from "react";
import UserContext from "../MyContext";
import CreateFollow from "../FollowsAndFriends/CreateFollow";
import CreateFriend from "../FollowsAndFriends/CreateFriend";
const DisplayAccounts = ({users, userFilter}) => {
    
    const [context, setContext] = useContext(UserContext)
    if(context == 0){
        return(
            users.filter(user=>user.username.includes(userFilter)).map((filteredUsers)=>(
                <div key={filteredUsers.accountId}>
                    <hr/>
                    <h6>{filteredUsers.accountId}</h6>
                    <h3>{filteredUsers.username}</h3>
                    <p>{filteredUsers.firstName} {filteredUsers.lastName}</p>
                </div>
            ))
        )
    }
    else{
        return(
            users.filter(user=>user.username.includes(userFilter)).map((filteredUsers)=>(
                <div key={filteredUsers.accountId}>
                    <hr/>
                    <h6>{filteredUsers.accountId}</h6>
                    <h3>{filteredUsers.username}</h3>
                    <p>{filteredUsers.firstName} {filteredUsers.lastName}</p>
                    <CreateFollow followerId={context.accountId} followedId={filteredUsers.accountId}/>
                    <CreateFriend sentBy={context.accountId} receivedBy={filteredUsers.accountId}/>
                </div>
            ))
        )
    }
}

export default DisplayAccounts;