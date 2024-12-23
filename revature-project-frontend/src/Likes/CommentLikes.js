import axios from "axios";

const CommentLikes = ({comment}) => {
    
    const handleClick = (e) => {
        e.preventDefault();
        const likes = comment.commentLikes + 1;
        updateLikes(likes)
    }

    const updateLikes = (likes) => {
        axios.patch(`http://localhost:8080/updateCommentLikes/${comment.commentId}/${likes}`, {
            commentId: comment.commentId,
            commentText: comment.commentText,
            commentLikes: likes,
            accountId: comment.accountId,
            postId: comment.postId
        })
        .then((res)=>{
            console.log(res.data)
        })
    }

    return(
        <button onClick={handleClick}>Like</button>
    )
}
export default CommentLikes