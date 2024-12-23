import axios from "axios";

const DeleteFollow = ({id}) => {
    
    const handleSubmit = (e) => {
        e.preventDefault();
        deleteFollow(id);
    };

    const deleteFollow = (id) => {
        axios.delete(`http://localhost:8080/stopFollow/${id}`)
    }
    
    return(
        <form>
            <button onClick={handleSubmit}>Stop Following</button>
        </form>
    )
}

export default DeleteFollow