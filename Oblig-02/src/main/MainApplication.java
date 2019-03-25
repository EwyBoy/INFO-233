package main;

import main.friend.Friend;
import main.node.FriendList;
import main.node.FriendNode;

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
     *      https://www.geeksforgeeks.org/insertion-sort-for-singly-linked-list/
     *      https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
     *      https://www.geeksforgeeks.org/remove-last-node-of-the-linked-list/
     *  ];
     *
     *  Usually sits next to David Kvasnes Olsen, our code could have similarities from shearing knowledge.
     *
     *  Here is a link to MY GitHub in case someone is looking at my src and not referencing me in their sources:
     *  https://github.com/EwyBoy/INFO-233
     *
     */

    private static FriendList friendList = new FriendList();

    /*  Initializes test data for application */
    private static void init() {
        Friend friend0 = new Friend("Arne", "Andersen", "95123900", "Postveien 0");
        Friend friend1 = new Friend("Berit", "Bertnsen", "95123901", "Postveien 1");
        Friend friend2 = new Friend("Carl", "Carlsen", "95123902", "Postveien 2");
        Friend friend3 = new Friend("Dora", "Danielsen", "95123903", "Postveien 3");
        Friend friend4 = new Friend("Erik", "Erickson", "95123904", "Postveien 4");
        Friend friend5 = new Friend("Fred", "Freddson", "95123905", "Postveien 5");

        friendList.addFirst(friend1);
        friendList.addFirst(friend5);
        friendList.addFirst(friend3);
        friendList.addFirst(friend0);
        friendList.addFirst(friend2);
        friendList.addFirst(friend4);
    }

    /*  Runs the main hub code for the main.friend list application */
    private static void runApplication(Scanner scanner) {

        friendList.printList(FriendList.head);

        System.out.println("Type 'add' to add a new main.friend or 'remove' to remove a existing main.friend: ");
        System.out.println("You can also type 'sort' to sort the main.friend list alphabetically by last names");

        String option = scanner.nextLine().toLowerCase();

        if (option.contentEquals("add")) {

            addFriend(scanner);

        } else if (option.contentEquals("remove")) {

            removeFriend(scanner);

        } else if (option.contentEquals("sort")) {

            sortList(scanner);

        } else {

            runApplication(scanner);

        }
    }

    /* Runs the code needed to add a new main.friend object and adds that main.friend to the main.friend list */
    private static void addFriend(Scanner scanner) {
        String firstName = inputStringHelper(scanner, "first name");
        String lastName = inputStringHelper(scanner, "last name");
        String phone = inputStringHelper(scanner, "phone number");
        String address = inputStringHelper(scanner, "address");

        Friend friend = new Friend(firstName, lastName, phone, address);

        friendList.addFirst(friend);
        System.out.println("Friend: " + firstName + " " + lastName + " was added to your main.friend list.");

        runApplication(scanner);
    }

    /* Runs the code needed to remove a main.friend object from the main.friend list */
    private static void removeFriend(Scanner scanner) {
        System.out.println("Type in the full name [firstname lastname] of the main.friend you wish to remove: ");
        String name = scanner.nextLine().toLowerCase();

        String[] names = name.split(" ");
        String fistname = names[0];
        String lastname = names[1];

        if (fistname == null || lastname == null) {
            removeFriend(scanner);
            System.out.println("Name is not valid, please try again.");
        }

        FriendNode topNode = FriendList.head;
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
            System.out.println("Friend: " + friend.firstName + " " + friend.lastName + " was removed from your main.friend list.");
        } else {
            System.out.println("Could not find any main.friend with that name.");
        }

        runApplication(scanner);
    }

    private static void sortList(Scanner scanner) {
        friendList.printList(FriendList.head);
        friendList.sort(FriendList.head);
        System.out.println("SORTING...\n");
        friendList.printList(FriendList.head);

        runApplication(scanner);
    }

    private static void runIterator() {
        Iterator iterator = friendList.iterator();

        System.out.println("Demoing iterator, sit back and enjoy.");

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
        System.out.println("Type in your new main.friend's " + field + ": ");
        return scanner.nextLine();
    }

    /* Main - Starts the application and initializes the input scanner */
    public static void main(String[] args) {
        init();
        runIterator();
        Scanner scanner = new Scanner(System.in);
        runApplication(scanner);
    }
}
