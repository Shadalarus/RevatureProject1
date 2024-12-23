import axios from "axios";
import { useState } from "react";

const AcceptReq = ({friend}) => {
    

    const handleClick = (e) => {
        e.preventDefault();
        acceptRequest();
    }

    const acceptRequest = () => {
        axios.patch(`http://localhost:8080/friends/${friend.friendId}`, {
            friendId: friend.friendId,
            sentBy: friend.sentBy,
            receivedBy: friend.receivedBy,
            accepted: 1
        })
    }
    
    return(
        <button onClick={handleClick}>Accept</button>
    )
}

export default AcceptReq