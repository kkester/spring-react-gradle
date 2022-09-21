
export const getFriends = async () => {
  const data = await fetch("/api/friends", {
    method: "GET"
  });
  return await data.json();
};
