const DisplayCurrentAccount = ({users}) => {
    
    const user = users

    return(
            <div key={user.accountId}>
                <h1>Account Details</h1>
                <p>Name: {user.firstName} {user.lastName}</p>
                <p>Email: {user.email}</p>
                <p>Phone Number: {user.phoneNumber}</p>
                <p>Username: {user.username}</p>
                <p>Password: {user.accountPassword}</p>
            </div>
        )
    
}

export default DisplayCurrentAccount;