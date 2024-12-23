import axios from "axios";
import { useContext, useState } from "react";
import UserContext from "../MyContext";

const CommentCreation = ({postId}) => {
    const [message, setMessage] = useState([])
    const [context, setContext] = useContext(UserContext)

    const handleSubmit = (e) => {
        e.preventDefault();
        addComment(message,context.accountId)
    }
    
    const addComment = (commentText, accountId) => {
        axios.post("http://localhost:8080/comments", {
            commentText: commentText,
            commentLikes: 0,
            accountId: accountId,
            postId: 1
        })
        .then((res)=>{
            console.log(res.data)
        })
    }

    return(
        <>
        <h1>New Comment</h1>
        <hr/><br/>
        <form>
            <label>Enter Comment Text: </label><br/>
            <textarea rows={20} cols={60} value={message} onChange={(e)=>setMessage(e.target.value)}></textarea>
            <button onClick={handleSubmit}>Submit</button>
        </form>
        </>
    )
}

export default CommentCreation