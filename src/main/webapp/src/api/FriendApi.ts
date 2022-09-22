
export type Friend = {
  name: string;
}

export const getFriends = async (): Promise<Friend[]> => {
  const data = await fetch("/api/friends", {
    method: "GET"
  });
  return await data.json();
};