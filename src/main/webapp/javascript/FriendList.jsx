import React from "react";

const FriendList = (props) => {
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

export default FriendList;