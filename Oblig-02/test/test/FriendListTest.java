package test;

import main.friend.Friend;
import main.node.FriendList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendListTest {

    private FriendList friendList = new FriendList();

    private Friend friend1 = new Friend("Berit", "Bertnsen", "95123901", "Postveien 1");
    private Friend friend2 = new Friend("Carl", "Carlsen", "95123902", "Postveien 2");
    private Friend friend3 = new Friend("Dora", "Danielsen", "95123903", "Postveien 3");
    private Friend friend4 = new Friend("Erik", "Erickson", "95123904", "Postveien 4");
    private Friend friend5 = new Friend("", "", "", "");

    @Test
    void addFirst() {
        // Checks if friendList is empty
        assertEquals(0, friendList.getFriendCount());

        // Initializing two test friends and checks the friend count is equal to 2
        friendList.addFirst(friend1);
        friendList.addFirst(friend2);
        assertEquals(2, friendList.getFriendCount());

        // Adds one more and check for 3 friends in the list
        friendList.addFirst(friend3);
        assertEquals(3, friendList.getFriendCount());

        // Tries to add the same friend twice, should work since there is no
        // restriction on this in my code.
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
        // Initializing some test friends
        friendList.addFirst(friend1);
        friendList.addFirst(friend2);
        friendList.addFirst(friend3);
        friendList.addFirst(friend4);
        friendList.addFirst(friend5);

        // Does a quick check to see if everyone was initialized
        // This friend contains empty strings to see if it can handle it
        assertEquals(5, friendList.getFriendCount());

        // Tries to delete the first friend from the top of the list
        friendList.deleteFriend(friend5);
        assertEquals(4, friendList.getFriendCount());

        // Tries to delete the last friend from the bottom of the list
        friendList.deleteFriend(friend1);
        assertEquals(3, friendList.getFriendCount());

        // Tires to delete the friend form the middle of the list
        friendList.deleteFriend(friend3);
        assertEquals(2, friendList.getFriendCount());

        // Tires to delete to friends in a row just to get down to 0 frinds
        friendList.deleteFriend(friend4);
        friendList.deleteFriend(friend2);

        // Checks if friendList is empty
        assertEquals(0, friendList.getFriendCount());

        // Tires to delete a friend that is already deleted
        // to check that friendCount does not go out of bounds
        friendList.deleteFriend(friend1);
        assertEquals(0, friendList.getFriendCount());
    }

    @Test
    void sort() {
        // The empty spaces is from friend5 just to se if empty Strings causes any bugs
        // (It did not)

        // Tries to sort the empty list
        friendList.sort(friendList.head);
        assertEquals(0, friendList.getFriendCount());

        // Initializes some random friends to test sort
        friendList.addFirst(friend3);
        friendList.addFirst(friend5);
        friendList.addFirst(friend2);

        // Makes sure all 3 friends are here and sort em
        assertEquals(3, friendList.getFriendCount());
        friendList.printList(friendList.head);
        System.out.print("Before: ");
        friendList.sort(friendList.head);
        System.out.print("After: ");
        friendList.printList(friendList.head);
        // Makes sure that we did not create any additional friends while
        // running the insertion sort, this happened earlier when creating the
        // insertion sorting algorithm during testing and helped me find a bug
        assertEquals(3, friendList.getFriendCount());

        // Adds the two last friends to the already sorted list
        friendList.addFirst(friend4);
        friendList.addFirst(friend1);
        assertEquals(5, friendList.getFriendCount());

        // Then sort the list again
        friendList.printList(friendList.head);
        System.out.print("Before: ");
        friendList.sort(friendList.head);
        System.out.print("After: ");
        friendList.printList(friendList.head);

        assertEquals(5, friendList.getFriendCount());

        // Test if the sort can handle duplicates
        friendList.addFirst(friend4);
        friendList.addFirst(friend2);
        friendList.addFirst(friend3);
        friendList.addFirst(friend1);
        friendList.addFirst(friend4);
        friendList.addFirst(friend5);
        friendList.addFirst(friend1);
        friendList.addFirst(friend3);
        friendList.addFirst(friend2);
        friendList.addFirst(friend5);
        friendList.addFirst(friend4);

        assertEquals(16, friendList.getFriendCount());

        // Then sort the list again
        friendList.printList(friendList.head);
        System.out.print("Before: ");
        friendList.sort(friendList.head);
        System.out.print("After: ");
        friendList.printList(friendList.head);

        assertEquals(16, friendList.getFriendCount());
    }
}