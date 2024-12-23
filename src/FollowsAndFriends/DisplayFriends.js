
import DeleteFriend from "./DeleteFriend";
import GetFollow_Friend from "./GetFollow_Friend";


const DisplayFriendsSent = ({friends}) => {
        return(
            friends.map((friend)=>(
                <div key={friend.friendId}>
                    <hr/>
                    <GetFollow_Friend id={friend.receivedBy}/>
                    <DeleteFriend id={friend.friendId}/>
                </div>
            ))
        )
    
}

const DisplayFriendsReceived = ({friends}) => {
    return(
        friends.map((friend)=>(
            <div key={friend.friendId}>
                <hr/>
                <GetFollow_Friend id={friend.sentBy}/>
                <DeleteFriend id={friend.friendId}/>
                
            </div>
        ))
    )

}

export default {DisplayFriendsSent, DisplayFriendsReceived};