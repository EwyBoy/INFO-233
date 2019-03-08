public class MainTwo {

    private static void init() {
        Friend friendOne = new Friend("Ted", "Bundy", "91997211", "Florida State Prison");
        Friend friendTwo = new Friend("Per", "Orderud", "92621142", "Orderud Gård");
        Friend friendThree = new Friend("Veronica", "Orderud", "91725311", "Orderud Gård");

        FriendList list = new FriendList();

        list.addFirst(friendOne);
        list.addFirst(friendThree);
        list.addFirst(friendTwo);

        list.printList();

    }

    public static void main(String[] args) {
        init();
    }
}
