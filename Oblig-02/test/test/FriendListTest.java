package test;

import main.friend.Friend;
import main.node.FriendList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendListTest {

    FriendList friendList = new FriendList();

    Friend friend0 = new Friend("Arne", "Andersen", "95123900", "Postveien 0");
    Friend friend1 = new Friend("Berit", "Bertnsen", "95123901", "Postveien 1");
    Friend friend2 = new Friend("Carl", "Carlsen", "95123902", "Postveien 2");
    Friend friend3 = new Friend("Dora", "Danielsen", "95123903", "Postveien 3");
    Friend friend4 = new Friend("Erik", "Erickson", "95123904", "Postveien 4");
    Friend friend5 = new Friend("", "", "", "");

    @Test
    void addFirst() {
        assertEquals(0, friendList.getFriendCount());

        friendList.addFirst(friend0);
        friendList.addFirst(friend1);
        assertEquals(2, friendList.getFriendCount());

        friendList.addFirst(friend3);
        assertEquals(3, friendList.getFriendCount());

        friendList.addFirst(friend4);
        assertEquals(4, friendList.getFriendCount());
        friendList.addFirst(friend4);
        assertEquals(5, friendList.getFriendCount());

        // Testing adding a new friend with empty strings
        friendList.addFirst(friend5);
        assertEquals(6, friendList.getFriendCount());

    }

    @Test
    void deleteFriend() {

    }

    @Test
    void sort() {
    }
}