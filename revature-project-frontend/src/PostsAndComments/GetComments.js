import axios from "axios"
import DisplayComments from "./DisplayComments"
import { useEffect, useState } from "react"

const GetComments = ({id}) =>{
    const [comments,setComments]=useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8080/posts/${id}/comments`)
        .then(res =>{
            setComments(res.data)
        })
    },[comments])

    return(
        <>
        <DisplayComments comments={comments}/>
        </>
    )
}

export default GetComments