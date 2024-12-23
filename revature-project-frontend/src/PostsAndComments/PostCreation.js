import axios from "axios"
import { useContext, useState } from "react"
import UserContext from "../MyContext"

const PostCreation = () => {
    const [message, setMessage] = useState([])
    const [context, setContext] = useContext(UserContext)

    const handleSubmit = (e) => {
        e.preventDefault();
        addPost(message,context.accountId)
    }
    
    const addPost = (messageText, accountId) => {
        axios.post("http://localhost:8080/posts/newPost", {
            messageText: messageText,
            postLikes: 0,
            accountId: accountId
        })
        .then((res)=>{
            console.log(res.data)
        })
    }

    return(
        <>
        <h1>New Post</h1>
        <hr/><br/>
        <form>
            <label>Enter Post Text: </label><br/>
            <textarea rows={20} cols={60} value={message} onChange={(e)=>setMessage(e.target.value)}></textarea>
            <button onClick={handleSubmit}>Submit</button>
        </form>
        </>
    )
}

export default PostCreation