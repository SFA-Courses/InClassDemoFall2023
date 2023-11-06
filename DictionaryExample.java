import java.util.HashMap; // adds like a dictionary/table

public class DictionaryExample {
    public static void main(String[] args) {
        // keys are integers  // values are strings
        HashMap<Integer, String> courses = new HashMap<>();  

        // add courses to dictionary
        courses.put(1302, "Principles");
        courses.put(2302, "Programming");
        courses.put(2311, "Event Driven");
        courses.put(2314, "Architecture");
        courses.put(3333, "Discrete");
        courses.put(3302, "Data Structures");
        //courses.put(1302, "Fun with Code");

        System.out.println(courses);

        // contains: Is something in the table?
        System.out.println();
        System.out.println("CONTAINS: ");
        for (int i = 2000; i < 3000; i++)
            if (courses.containsKey(i))
                System.out.println("Course with key " + i + " has value " + courses.get(i));

        // remove
        System.out.println(        );
        System.out.println("REMOVE:");
        courses.remove(3302);

        // traverse
        for (Integer i : courses.keySet())
            System.out.println("Course with key " + i + " has value " + courses.get(i));

        // traverse values
        System.out.println();
        for (String values : courses.values())
            System.out.println(values);

        courses.clear(); // empty the table
        System.out.println(courses);
    }
}
