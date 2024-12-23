import {Route, BrowserRouter as Router, Routes} from 'react-router-dom';
import './App.css';
import Navbar from './Navbar';
import Login from './Login-Register/Login';
import Account from './Accounts/Account';
import AccountUpdate from './Accounts/AccountUpdate';
import Register from './Login-Register/Register';
import FriendsList from './FollowsAndFriends/FriendsList';
import FollowsList from './FollowsAndFriends/FollowsList';
import Home from './Home';
import PostStream from './PostsAndComments/PostStream';
import FriendRequests from './FollowsAndFriends/FriendRequests';
import AccountList from './Accounts/AccountList';
import PostCreation from './PostsAndComments/PostCreation';
import UserContext from './MyContext';
import { useState } from 'react';
import CommentCreation from './PostsAndComments/CommentCreation';

function App() {

  const [context, setContext] = useState(0);

  return (
    <>
    <UserContext.Provider value={[context, setContext]}>
    <Router>
      <div className="app">
        <Navbar/>
      </div>
      <Routes>
        <Route path='/home' element={<Home/>}/>
        <Route path='/comment' element={<CommentCreation/>}/>
        <Route path='/posts' element={<PostStream/>}/>
        <Route path='/account' element={<Account/>}/>
        <Route path='/users' element={<AccountList/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/updateEmail' element={<AccountUpdate updateType={1}/>}/>
        <Route path='/updatePhone' element={<AccountUpdate updateType={2}/>}/>
        <Route path='/passwordChange' element={<AccountUpdate updateType={3}/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/friends' element={<FriendsList/>}/>
        <Route path='/follows' element={<FollowsList/>}/>
        <Route path='/pendingRequests' element={<FriendRequests/>}/>
        <Route path='/posts/newPost' element={<PostCreation/>}/>
      </Routes>
    </Router>
    </UserContext.Provider>
    </>
  );
}

export default App;
