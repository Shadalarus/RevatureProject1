import axios from "axios";

const DeleteFriend = ({id}) => {
    
    const handleSubmit = (e) => {
        e.preventDefault();
        deleteFriend(id);
    };

    const deleteFriend = (id) => {
        axios.delete(`http://localhost:8080/stopFriend/${id}`)
    }
    
    return(
        <form>
            <button onClick={handleSubmit}>Cancel Friendship</button>
        </form>
    )
}

export default DeleteFriend