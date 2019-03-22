package node;

import friend.Friend;
import java.util.Iterator;


public class FriendList implements IFriendList, Iterable {

    public static FriendNode head;

    public void printList() {
        FriendNode topNode = head;

        System.out.println("You have " + getFriendCount() + " friends in your friend list!");
        System.out.print("Friend List: ");
        while (topNode != null) {
            System.out.print(topNode.friend.firstName  + " " + topNode.friend.lastName + "\t-\t");
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


    public void alphaSort(String a, String b) {
        int compare = a.compareTo(b);
    }


    @Override
    public void sort(FriendList list) {
        FriendNode topNode = head;

        for (int i = 0; i < getFriendCount(); i++) {
            while (topNode != null) {
                if (topNode.next != null) {
                    alphaSort(topNode.friend.lastName, topNode.next.friend.toString());
                    topNode = topNode.next;
                }
            }
            topNode = head;
        }
    }
}
