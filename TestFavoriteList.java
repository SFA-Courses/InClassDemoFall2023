import java.net.MalformedURLException;

public class TestFavoriteList {
    public static void main(String[] args) throws ListException, MalformedURLException {
        FavoriteList favList = new FavoriteList();
        System.out.println("Testing add: ");
        favList.add(0, new Favorite("Grounded", "https://www.youtube.com/watch?v=_BqgJ9nW468"));
        favList.add(1, new Favorite("Vampire Survivor", "https://www.youtube.com/watch?v=6HXNxWbRgsg"));
        favList.add(2, new Favorite("High on Life", "https://www.youtube.com/watch?v=NyfneSMsr5U"));
        System.out.println(favList);

        System.out.println();
        System.out.println("Testing remove: ");
        favList.remove(1);
        System.out.println(favList);

        System.out.println();
        System.out.println("Testing remove all: ");
        favList.removeAll();
        System.out.println(favList);
    }
}
