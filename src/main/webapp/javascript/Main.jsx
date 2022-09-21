import React, {useEffect, useState} from "react";
import ReactDOM from 'react-dom';
import FriendList from './FriendList';
import '../css/Main.css';
import {getFriends} from "./FriendApi";

const Main = () => {

  const [friends, setFriends] = useState([]);

  useEffect(() => {
    getFriends()
        .then(response => {
          setFriends(response)
        })
        .catch(error => alert(error));
  }, [])

  return (
      <div id="main">
        <h1>My Best Friends</h1>
        <FriendList friends={friends}/>
      </div>
  )
}

ReactDOM.render(
    <Main/>,
    document.getElementById('react-mountpoint')
);