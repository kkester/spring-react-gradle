import React, { useEffect, useState } from 'react';
import '../css/Main.css';
import { Friend, getFriends } from '../api/FriendApi';
import { FriendList } from './FriendList';

export const Main = () => {

  const [friends, setFriends] = useState<Friend[]>([]);

  useEffect(() => {
    getFriends()
      .then(response => setFriends(response))
      .catch(error => alert(error));
  }, [])

  return (
    <div id="main">
      <h1>My Best Friends</h1>
      <FriendList friends={friends}/>
    </div>
  )
}