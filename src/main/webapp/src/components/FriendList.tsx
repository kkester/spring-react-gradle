import React from "react";
import { Friend } from '../api/FriendApi';

export const FriendList = (props: {
  friends: Friend[];
}) => {
  if (!props.friends) {
    return <div>No Friends yet...</div>
  }
  return (
    <ul id="friend-list">
      {props.friends.map((friend,i) => (
        <li key={'friend-list-'+i}>
          {friend.name}
        </li>
      ))}
    </ul>
  );
}