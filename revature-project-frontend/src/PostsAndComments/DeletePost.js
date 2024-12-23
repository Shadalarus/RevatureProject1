import axios from "axios";

const DeletePost = ({postId, madeBy, user}) => {
    const id = postId;
    const handleSubmit = (e) => {
        e.preventDefault();
        if(madeBy == user){
            deletePost(id);
        }
        else{
            alert("That is not your post")
        }
    };

    const deletePost = (id) => {
        axios.delete(`http://localhost:8080/posts/${id}`)
    }
    
    return(
        <form>
            <button onClick={handleSubmit}>Delete</button>
        </form>
    )
}

export default DeletePost