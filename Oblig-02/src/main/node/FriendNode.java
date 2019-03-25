package main.node;

import main.friend.Friend;

public class FriendNode {

    public Friend friend;
    public FriendNode next;

    public FriendNode(Friend friend) {
        this.friend = friend;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Firstname: " + friend.firstName + " - Lastname: " + friend.lastName + " - Address: " + friend.address + " - Phone: " + friend.phoneNumber;
    }
}
