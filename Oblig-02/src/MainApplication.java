import friend.Friend;
import node.FriendList;
import node.FriendNode;

import java.util.Iterator;
import java.util.Scanner;

public class MainApplication {

    /*
     *   Sources: [
     *      https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     *      https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
     *      https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
     *      https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
     *      https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
     *      https://www.geeksforgeeks.org/programmers-approach-looking-array-vs-linked-list/
     *      https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
     *      https://www.geeksforgeeks.org/remove-last-node-of-the-linked-list/
     *  ];
     *
     *  Here is a link to MY GitHub in case someone is looking at my src and not referencing me in their sources:
     *  https://github.com/EwyBoy/INFO-233
     *
     */

    private static FriendList friendList = new FriendList();

    /*  Initializes test data for application */
    private static void init() {
        Friend friendOne = new Friend("Ted", "Bundy", "95997211", "Florida State Prison");
        Friend friendTwo = new Friend("Per", "Orderud", "92621142", "Orderud Gård");
        Friend friendThree = new Friend("Veronica", "Orderud", "71725311", "Orderud Gård");
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
        System.out.println("Friend: " + firstName + " " + lastName + " was added to your friend list.");

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
            System.out.println("Friend: " + friend.firstName + " " + friend.lastName + " was removed from your friend list.");
        } else {
            System.out.println("Could not find any friend with that name.");
        }

        runApplication(scanner);
    }

    private static void runIterator() {
        Iterator iterator = friendList.iterator();

        while (iterator.hasNext()) {
            System.out.println("Has next: " + iterator.hasNext());
            System.out.println(iterator.next());

            if (!iterator.hasNext()) {
                System.out.println("Has next: " + iterator.hasNext() + "\n");
                System.out.println("Iteration done.\n");
                break;
            }
        }
    }

    /* A helper method to avoid reused code */
    private static String inputStringHelper(Scanner scanner, String field) {
        System.out.println("Type in your new friend's " + field + ": ");
        return scanner.nextLine();
    }

    /* Main - Starts the application and initializes the input scanner */
    public static void main(String[] args) {
        init();
        runIterator();

        friendList.printList();
        friendList.sort(friendList);
        friendList.printList();
        friendList.printList();
        friendList.printList();
        friendList.printList();
        friendList.printList();

        //Scanner scanner = new Scanner(System.in);
        //runApplication(scanner);
    }
}
