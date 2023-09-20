public class TestFriendsList {
    public static void main(String[] args) {
        FriendsList friendsList = new FriendsList();
        System.out.println("Testing Add: ");
        friendsList.add(2, new Friend("sktls", false));
        friendsList.add(0, new Friend("DorianALP", true));
        Friend a = new Friend("GothBarbie", false);
        friendsList.add(0, a);
        friendsList.add(0, a);
        friendsList.add(0, a);
        System.out.println(friendsList.toString());

        System.out.println();
        System.out.println("Testing Remove: ");
        friendsList.remove(2);
        System.out.println(friendsList.toString());

        System.out.println();
        System.out.println("Testing Get");
        System.out.println(friendsList.get(0));
        
        System.out.println();
        System.out.println("Testing Remove All");
        friendsList.removeAll();

        System.out.println(friendsList);
        System.out.println(friendsList.isEmpty());


    }
}
