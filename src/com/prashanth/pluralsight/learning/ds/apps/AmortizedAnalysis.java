import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  The number of operations that you do for a given input size 
 *  is calculated as a time complexity of the code/algorithm. 
 *  These examples will give you clean picture about the complexity analysis of a code.
 */
class AmortizedAnalysis {

    public static void main(String[] args) {

        // O(n) or linear
        int n = 40;
        int x = n;
        int operationCounter = 0;
        while (x > 0) { // for every element in x
            x = x - 1;
            operationCounter++; // for every input
        }

        System.out.println("Number of operations: in O(n) => " + operationCounter);

        // O(n^2) or quadratic - polynomial
        x = n;
        operationCounter = 0;
        while (x > 0) { // for every element in x
            int y = n;
            while (y > 0) { // for every element in y
                y = y - 1;
                operationCounter++; // for every input
            }
            x = x - 1;
        }

        System.out.println("Number of operations: O(n^2) => " + operationCounter);

        // O(log n) or logarithmic
        x = n;
        operationCounter = 0;
        while (x > 0) { // for every element in x operation count is getting reduced over and over.
            x = x / 2;
            operationCounter++; // for every input
        }

        System.out.println("Number of operations: O(log n) => " + operationCounter);

        // O(n log n) or linerarithmic
        x = n;
        operationCounter = 0;
        while (x > 0) { // for every element in x
            int y = n;
            while (y > 0) { // for every element in y operation count is getting reduced over and over.
                y = y / 2;
                operationCounter++; // for every input
            }
            x = x - 1;
        }

        System.out.println("Number of operations: O(n log n) => " + operationCounter);

        // O(n^3) or qubic - polynomial
        x = n;
        operationCounter = 0;
        while (x > 0) { // for every element in x
            int y = n;
            while (y > 0) { // for every element in y 
                int z = n;
                while(z > 0) {
                    z = z - 1;
                    operationCounter++; // for every input
                }
                y = y - 1;
            }
            x = x - 1;
        }

        System.out.println("Number of operations: O(n^3) => " + operationCounter);

        // O(1) or constant
        operationCounter = 0;
        if(n % 2 == 0) {
            operationCounter++;
        } else {
            operationCounter++;
        }

        System.out.println("Number of operations: O(1) => " + operationCounter);
        // If your loop runs for a constant number of time then it is also considered as a constant complexity 

        // O(2^n) or exponential
        atomicIntegerExponential.addAndGet(1);
        exponential(6);
        System.out.println("Number of operations: O(2^n) => " + atomicIntegerExponential);
    
    }

    // O(2^n) 
    static AtomicInteger atomicIntegerExponential = new AtomicInteger(); 
    static int exponential(int num) {
        atomicIntegerExponential.addAndGet(1);
        if(num <= 1) {
            return num;
        } else {
            return exponential(num - 1) + exponential(num - 1);
        }
    }
}
