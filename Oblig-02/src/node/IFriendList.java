import friend.Friend;

public interface IFriendList {

    void addFirst(Friend newFriend);

    void addLast(Friend newFriend);

    void addAfter(FriendNode node, Friend friend);

    void deleteFriend(Friend friend);

}
