package main.node;

import main.friend.Friend;

import java.util.Iterator;

public class FriendList implements IFriendList, Iterable {

    public static FriendNode head;

    public void printList(FriendNode head) {
        FriendNode topNode = head;

        System.out.println("You have " + getFriendCount() + " friends in your friend list!");
        System.out.print("Friend List: ");

        while (topNode != null) {
            System.out.print(topNode.friend.firstName  + " " + topNode.friend.lastName + " - ");
            topNode = topNode.next;
        }

        System.out.println("\n");
    }

    public int getFriendCount() {
        FriendNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    @Override
    public Iterator iterator() {
        return new FriendListIterator();
    }


    @Override
    public void addFirst(Friend newFriend) {
        FriendNode friendNode = new FriendNode(newFriend);
        friendNode.next = head;
        head = friendNode;
    }

    @Override
    public void addLast(Friend newFriend) {
        FriendNode friendNode = new FriendNode(newFriend);

        if (head == null) {
            head = new FriendNode(newFriend);
            return;
        }

        friendNode.next = null;

        FriendNode last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = friendNode;
    }

    @Override
    public void addAfter(FriendNode lastFriend, Friend friend) {
        if (lastFriend == null) {
            System.out.println("Last node can't be null");
            return;
        }

        FriendNode newFriend = new FriendNode(friend);

        newFriend.next = lastFriend.next;
        lastFriend.next = newFriend;
    }

    @Override
    public void deleteFriend(Friend friend) {
        FriendNode temp = head, prev = null;

        if (temp != null && temp.friend == friend) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.friend != friend) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }


    /*
        I chose to go with a insertion sorting algorithm because it was well documented
        and it was easier to keep track of all the nodes while working with this one.
        I first tried to get a merge-sorting algorithm to work but I ran into a lot of
        different issues with that one. So I chose this one for convenience sake.

        Runtime Analysis:
        My implementation of the insertion sort algorithm ends up at a O(n^2)
        because of the two while loops, where the second loop inside insertionSort()
        runs inside of the first while from sort().
     */

    private FriendNode sorted;

    @Override
    public void sort(FriendNode head) {
        sorted = null;
        FriendNode current = head;

        while (current != null) {
            FriendNode next = current.next;
            insertionSort(current);

            current = next;
        }

        FriendList.head = sorted;
    }

    private void insertionSort(FriendNode node) {
        if (sorted == null || sorted.friend.lastName.compareTo(node.friend.lastName) >= 0) {
            node.next = sorted;
            sorted = node;

        } else {

            FriendNode current = sorted;

            while (current.next != null && current.next.friend.lastName.compareTo(node.friend.lastName) < 0) {
                current = current.next;
            }

            node.next = current.next;
            current.next = node;
        }
    }

}
