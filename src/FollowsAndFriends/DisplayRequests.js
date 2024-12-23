import AcceptReq from "./AcceptReq";
import DeleteFriend from "./DeleteFriend";
import GetFollow_Friend from "./GetFollow_Friend";

const DisplayRequestsReceived = ({friends}) => {
    return(
        friends.map((friend)=>(
            <div key={friend.friendId}>
                <hr/>
                <GetFollow_Friend id={friend.sentBy}/>
                <AcceptReq friend={friend}/>
                <DeleteFriend id={friend.friendId}/>
                
            </div>
        ))
    )

}

export default DisplayRequestsReceived;