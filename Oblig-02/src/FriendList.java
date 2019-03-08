public class FriendList implements IFriendList {

    private FriendNode head;

    public void printList() {
        FriendNode topNode = head;
        while (topNode != null) {
            System.out.print(topNode.friend + " ");
            topNode = topNode.next;
        }
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

}
