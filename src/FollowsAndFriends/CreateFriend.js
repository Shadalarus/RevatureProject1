import axios from "axios"

const CreateFriend = ({sentBy, receivedBy}) =>{
    
    

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(sentBy)
        addFriend(sentBy, receivedBy)
    }
    
    const addFriend = (sentBy, receivedBy) => {
        axios.post(`http://localhost:8080/friend`, {
            sentBy: sentBy,
            receivedBy: receivedBy,
            accepted: 0
        })
        .then((res)=>{
            console.log(res.data)
        })
    }

    return(
        <>
        
        <form>
            <button onClick={handleSubmit}>Friend</button>
        </form>
        </>
    )
}
export default CreateFriend