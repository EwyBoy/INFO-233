package node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FriendListIterator implements Iterator<FriendNode> {

    public FriendNode currentNode;
    public FriendNode head = FriendList.head;

    public FriendListIterator() {
        currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public FriendNode next() {
        if (currentNode != null) {
            FriendNode temp = currentNode;
            currentNode = currentNode.next;
            return temp;
        } else  {
            throw new NoSuchElementException();
        }
    }
}
