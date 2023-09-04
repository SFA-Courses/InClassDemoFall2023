public class Recursive {


    public static void printHello() {
        System.out.println("Hello");
        printHello();
    }
    
    public static int sum(int n) {
        if (n == 0)
            return 0;
        else { // n is not 1            
            int smallerSolution = sum(n-1);  
            return n  +smallerSolution;   
        }
    }


    public static int factorial(int n) {
        if (n == 1)
            return 1;
        else { // n is not 1
            System.out.println("n is " + n);
            int smallerSolution = factorial(n-1);
            System.out.println("smallerSolution: " + smallerSolution);

            return n * smallerSolution;   
        }
    }

    public static int fib(int n) {
        if ( n == 0 || n == 1)
            return 1;
        else
            return fib(n-1) + fib(n-2);
    }

    // prints numbers 0 ... n
    public static void head(int n) {
        if (n == 0)
            System.out.println(0);
        else {
            head(n-1);
            System.out.println(n);
        }
    }

    // prints numbers 0 ... n
    public static void tail(int n) {
        if (n == 0)
            System.out.println(0);
        else {
            System.out.println(n);
            tail(n-1);
            
        }
    }
    public static void main(String[] args) {
        tail(5);
    }
}