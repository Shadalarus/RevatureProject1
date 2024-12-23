import axios from "axios";
import { useContext } from "react";
import UserContext from "../MyContext";
import GetComments from "./GetComments";
import { Link } from "react-router-dom";
import DeletePost from "./DeletePost";
import GetAuthor from "./GetAuthor";
import PostLikes from "../Likes/PostLikes";

const DisplayPosts = ({posts, postFilter}) => {
    
    const [context, setContext] = useContext(UserContext)
    
    if(context == 0){
        return(
            posts.filter(post => post.messageText.includes(postFilter)).map(filteredPosts =>(
                <div key={filteredPosts.postId}>
                    <hr/>
                    <hr/>
                    <h4>Post {filteredPosts.postId}</h4>
                    <p>{filteredPosts.messageText}</p>
                    <p>Likes: {filteredPosts.postLikes}</p>
                    <GetAuthor id={filteredPosts.accountId}/>
                    <h5>Comments:</h5>
                    <GetComments id={filteredPosts.postId}/>
                </div>
            ))
        )
    }
    else{
        return(
            posts.filter(post => post.messageText.includes(postFilter)).map(filteredPosts =>(
                <div key={filteredPosts.postId}>
                    <hr/>
                    <hr/>
                    <h4>Post {filteredPosts.postId}</h4>
                    <p>{filteredPosts.messageText}</p>
                    <p>Likes: {filteredPosts.postLikes}</p>
                    <PostLikes post={filteredPosts}/>
                    <Link to="/comment"><button>Comment</button></Link>
                    <DeletePost postId={filteredPosts.postId} madeBy={filteredPosts.accountId} user={context.accountId}/>
                    <GetAuthor id={filteredPosts.accountId}/>
                    <h5>Comments:</h5>
                    <GetComments id={filteredPosts.postId}/>
                </div>
            ))
        )
    }
}

export default DisplayPosts;