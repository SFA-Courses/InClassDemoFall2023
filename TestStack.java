public class TestStack {
    public static void main(String[] args) {
        StackReferenceBased<Character> stack = new StackReferenceBased<Character>();

        System.out.println("Test isEmpty: ");
        System.out.println(stack.isEmpty());
        System.out.println();

        for (char i = 'a'; i <= 'j'; i++) 
            stack.push(i);
        System.out.println("Test Push");
        System.out.println(stack.toString());
        System.out.println();

        for (int i = 1; i <= 5; i++)
            stack.pop();

        System.out.println("Test Pop");
        System.out.println(stack.toString());
        System.out.println();
        
        System.out.println("Test Peek");
        System.out.println(stack.peek());
        System.out.println();
               

        System.out.println("Test Pop All");
        stack.popAll();
        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }
}
