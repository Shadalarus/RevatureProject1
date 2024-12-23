import axios from "axios";

const PostLikes = ({post}) => {
    
    const handleClick = (e) => {
        e.preventDefault();
        const likes = post.postLikes + 1;
        updateLikes(likes)
    }

    const updateLikes = (likes) => {
        axios.patch(`http://localhost:8080/updatePostLikes/${post.postId}/${likes}`, {
            postId: post.postId,
            messageText: post.messageText,
            postLikes: likes,
            accountId: post.accountId
        })
        .then((res)=>{
            console.log(res.data)
        })
    }

    return(
        <button onClick={handleClick}>Like</button>
    )
}
export default PostLikes