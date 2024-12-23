import DeleteFollow from "./DeleteFollow";
import GetFollow_Friend from "./GetFollow_Friend";


const DisplayFollows = ({follows}) => {
        return(
            follows.map((follow)=>(
                <div key={follow.followId}>
                    <hr/>
                    <GetFollow_Friend id={follow.followedId}/>
                    <DeleteFollow id={follow.followId}/>
                </div>
            ))
        )
    
}

export default DisplayFollows;