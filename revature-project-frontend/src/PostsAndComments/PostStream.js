import { Link } from "react-router-dom"
import { useContext, useEffect, useState } from "react"
import axios from "axios";
import DisplayPosts from "./DisplayPosts";
import UserContext from "../MyContext";
const PostStream = () => {

    const [posts,setPosts]=useState([])

    useEffect(()=>{
        axios.get("http://localhost:8080/posts")
        .then(res =>{
            setPosts(res.data)
        })
    },[posts])
    
    const [context, setContext] = useContext(UserContext)
    if(context == 0){
        return(
            <>
            <h1>Posts</h1>
            <DisplayPosts posts={posts}/>
            </>
        )
    }
    else{
        return(
            <>
            <h1>Posts</h1>
            <Link to={"/posts/newPost"}>Create New Post</Link>
            <DisplayPosts posts={posts}/>
            </>
        )
    }

    
}

export default PostStream