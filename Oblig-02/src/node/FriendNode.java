import friend.Friend;

public class FriendNode {

    public Friend friend;
    public FriendNode next;

    public FriendNode(Friend friend) {
        this.friend = friend;
        this.next = null;
    }

}
