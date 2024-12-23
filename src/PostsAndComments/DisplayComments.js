import { useContext } from "react"
import UserContext from "../MyContext"
import GetAuthor from "./GetAuthor"
import DeleteComment from "./DeleteComment"
import CommentLikes from "../Likes/CommentLikes"

const DisplayComments = ({comments}) =>{
    const [context, setContext] = useContext(UserContext)

    if(context == 0){
        return(
            comments.map((comment)=>(
                <div key={comment.commentId}>
                    <p>{comment.commentText}</p>
                    <GetAuthor id={comment.accountId}/>
                    <p>Comment Likes: {comment.commentLikes}</p>
                    <hr/>
                </div>
            ))
        )
    }
    else{
        return(
            comments.map((comment)=>(
                <div key={comment.commentId}>
                    <hr/>
                    <p>{comment.commentText}</p>
                    <GetAuthor id={comment.accountId}/>
                    <p>Comment Likes: {comment.commentLikes}</p>
                    <CommentLikes comment={comment}/>
                    <DeleteComment commentId={comment.commentId} madeBy={comment.accountId} user={context.accountId}/>
                </div>
            ))
        )
    }
}

export default DisplayComments