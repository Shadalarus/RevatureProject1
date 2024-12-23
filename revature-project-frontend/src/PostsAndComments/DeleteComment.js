import axios from "axios";

const DeleteComment = ({commentId, madeBy, user}) => {
    const id = commentId;
    const handleSubmit = (e) => {
        e.preventDefault();
        if(madeBy == user){
            deleteComment(id);
        }
        else{
            alert("That is not your post")
        }
    };

    const deleteComment = (id) => {
        axios.delete(`http://localhost:8080/comments/${id}`)
    }
    
    return(
        <form>
            <button onClick={handleSubmit}>Delete</button>
        </form>
    )
}

export default DeleteComment