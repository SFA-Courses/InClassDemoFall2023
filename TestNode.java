public class TestNode {
    public static void main(String[] args) {
        Friend f1 = new Friend("Lezduit", false);
        Friend f2 = new Friend("AdamSmasher", true);
        Friend f3 = new Friend("GothBarbie", true);

        Node<Friend> n1 = new Node<Friend>(f1);
        Node<Friend> n2 = new Node<Friend>(f2);
        Node<Friend> n3 = new Node<Friend>(f3);

        n1.setNext(n2);
        n2.setNext(n3);
        
        System.out.println(n1.toString());
    }
    
}
