import axios from "axios"

const CreateFollow = ({followerId, followedId}) =>{
    
    

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(followerId)
        addFollow(followerId, followedId)
    }
    
    const addFollow = (followerId, followedId) => {
        axios.post(`http://localhost:8080/follow`, {
            followerId: followerId,
            followedId: followedId
        })
        .then((res)=>{
            console.log(res.data)
        })
    }

    return(
        <>
        
        <form>
            <button onClick={handleSubmit}>Follow</button>
        </form>
        </>
    )
}
export default CreateFollow