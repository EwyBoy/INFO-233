import friend.Friend;
import node.FriendList;
import node.FriendNode;

import java.util.Scanner;

public class MainTwo {

    private static FriendList friendList = new FriendList();

    /*  Initializes test data for application */
    private static void init() {
        Friend friendOne = new Friend("Ted", "Bundy", "91997211", "Florida State Prison");
        Friend friendTwo = new Friend("Per", "Orderud", "92621142", "Orderud Gård");
        Friend friendThree = new Friend("Veronica", "Orderud", "91725311", "Orderud Gård");
        Friend friendFour = new Friend("Kristin", "Kirkemo", "91723322", "Oslo");

        friendList.addFirst(friendOne);
        friendList.addFirst(friendThree);
        friendList.addFirst(friendTwo);
        friendList.addFirst(friendFour);
    }

    /*  Runs the main hub code for the friend list application */
    private static void runApplication(Scanner scanner) {

        friendList.printList();

        System.out.println("Type 'add' to add a new friend or 'remove' to remove a existing friend: ");

        String option = scanner.nextLine().toLowerCase();

        if (option.contentEquals("add")) {

            addFriend(scanner);

        } else if (option.contentEquals("remove")) {

            removeFriend(scanner);

        } else {

            runApplication(scanner);

        }
    }

    /* Runs the code needed to add a new friend object and adds that friend to the friend list */
    private static void addFriend(Scanner scanner) {
        String firstName = inputStringHelper(scanner, "first name");
        String lastName = inputStringHelper(scanner, "last name");
        String phone = inputStringHelper(scanner, "phone number");
        String address = inputStringHelper(scanner, "address");

        Friend friend = new Friend(firstName, lastName, phone, address);

        friendList.addFirst(friend);
        System.out.println("friend.Friend: " + firstName + " " + lastName + " was added to your friend list.");

        runApplication(scanner);
    }

    /* Runs the code needed to remove a friend object from the friend list */
    private static void removeFriend(Scanner scanner) {
        System.out.println("Type in the full name [firstname lastname] of the friend you wish to remove: ");
        String name = scanner.nextLine().toLowerCase();

        String[] names = name.split(" ");
        String fistname = names[0];
        String lastname = names[1];

        if (fistname == null || lastname == null) {
            removeFriend(scanner);
            System.out.println("Name is not valid, please try again.");
        }

        FriendNode topNode = friendList.head;
        Friend friend = null;

        while (topNode != null) {
            if (topNode.friend.firstName.toLowerCase().equals(fistname) && topNode.friend.lastName.toLowerCase().equals(lastname)) {
                friend = topNode.friend;
                break;
            }
            topNode = topNode.next;
        }

        if (friend != null) {
            friendList.deleteFriend(friend);
            System.out.println("friend.Friend: " + friend.firstName + " " + friend.lastName + " was removed from your friend list.");
        } else {
            System.out.println("Could not find any friend with that name.");
        }

        runApplication(scanner);
    }

    /* A helper method to avoid reused code */
    private static String inputStringHelper(Scanner scanner, String field) {
        System.out.println("Type in your new friends " + field + ": ");
        return scanner.nextLine();
    }

    /* Main - Starts the application and initializes the input scanner */
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        runApplication(scanner);
    }
}
