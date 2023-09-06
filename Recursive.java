public class Recursive {
    public static void stupidPrint() {
        System.out.println("Hello Recursion");
        stupidPrint();
    }

    public static int factorial(int n) {
        if (n == 1)
            return 1;
        else {
            int smallerSolution = factorial(n-1);
            return n * smallerSolution;
        }
    }

    public static int sum(int n) {
        if (n == 0)
            return 0;
        else {
            int smallerSolution = sum(n-1); // 0 + 1 + ... + n-1
            return smallerSolution + n;
        }
    }

    public static int fib(int n) {
        if ( n == 0 || n == 1)
            return 1;
        else
            return fib(n-1) + fib(n-2);
    }

    public static void head(int n) {
        if (n == 0)
            System.out.print(0 + " ");
        else {
            head(n-1);  // recursive step is first
            System.out.print(n + " ");  // processing
        }
    }

    public static void tail(int n) {
        if (n == 0)
            System.out.print(0 + " ");
        else {
            System.out.print(n + " ");  // processing the data first
            tail(n-1);            // recursive step
        }
    }

    private static int[] array = {1,2,3,4,5,6,10,7,8,9};

    // find the sum of all elements in the array up to index i
    private static int sumByHead(int i) {
        if (i == 0)
            return array[0];
        else {
            int smallerSum = sumByHead(i-1);
            return smallerSum + array[i];
        }
    }

   

    // finds the sum of array elements from index i to the end
    // of the array and adds it to the currentSum
    private static int sumByTail(int i, int currentSum) {
        if (i == array.length-1)
            return array[i] + currentSum;   
        else {
            currentSum = currentSum + array[i];
            return sumByTail(i+1, currentSum);
        }

    }
    
    // add up all the elements in the array
    public static int sum() {
        //return sumByHead(array.length-1);
        return sumByTail(0, 0);
    }


 // find the max of all elements in the array from index 0 to i
    private static int maxByHead(int i ) {
        if (i == 0)
            return array[0];
        else {
            int previousMax = maxByHead(i-1); // max of elements in index 0 to i-1
            return Math.max(previousMax, array[i]); // new max is the biggest
            // of the previousMax and the ith element
        }
    }
    public static int max() {
        //return maxByHead(array.length-1);
        return maxByTail(0, 0);
    }

    // find the max from the ith element to the end of the array
    // and compare with the currentMax variable
    private static int maxByTail(int i, int currentMax) {
        if (i == array.length -1) 
            return Math.max(currentMax, array[array.length-1]);
        else {
            currentMax = Math.max(currentMax, array[i]);
            return maxByTail(i+1, currentMax);
        }


    }
    public static void main(String[] args) {
        System.out.println(max());
    }
}