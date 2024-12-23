import axios from "axios";
import { useContext } from "react";
import UserContext from "../MyContext";
import GetComments from "./GetComments";
import { Link } from "react-router-dom";
import DeletePost from "./DeletePost";
import GetAuthor from "./GetAuthor";
const DisplayPosts = ({posts}) => {
    
    const [context, setContext] = useContext(UserContext)
    if(context == 0){
        return(
            posts.map((post)=>(
                <div key={post.postId}>
                    <hr/>
                    <hr/>
                    <h4>Post {post.postId}</h4>
                    <p>{post.messageText}</p>
                    <p>Likes: {post.postLikes}</p>
                    <GetAuthor id={post.accountId}/>
                    <h5>Comments:</h5>
                    <GetComments id={post.postId}/>
                </div>
            ))
        )
    }
    else{
        return(
            posts.map((post)=>(
                <div key={post.postId}>
                    <hr/>
                    <hr/>
                    <h4>Post {post.postId}</h4>
                    <p>{post.messageText}</p>
                    <p>Likes: {post.postLikes}</p>
                    <GetAuthor id={post.accountId}/>
                    <button>Like</button>
                    <Link to="/comment"><button>Comment</button></Link>
                    <DeletePost postId={post.postId} madeBy={post.accountId} user={context.accountId}/>
                    <h5>Comments:</h5>
                    <GetComments id={post.postId}/>
                </div>
            ))
        )
    }
}

export default DisplayPosts;