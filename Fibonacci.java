import java.util.HashMap;

public class Fibonacci {

    //Since the Fibonacci numbers are unique integers we could also use a list instead of a hash map

    static HashMap<Integer, Integer> previouslyComputedFibonacciNumbers = new HashMap<>();

    public static int fastfibonnaci(int number){

        if(number == 1 || number == 2){

            return 1;
        }

        //Used to evaluate current fibonnaci and store value in hashmap if it doesn't exist
        if(previouslyComputedFibonacciNumbers.containsKey(number) == false){
            int value = fastfibonnaci(number - 2) + fastfibonnaci(number - 1);
            previouslyComputedFibonacciNumbers.put(number, value);
        }

        return previouslyComputedFibonacciNumbers.get(number);
    }

    public static int slowfibonnaci(int number){

        if(number == 1 || number == 2){

            return 1;
        }

        return slowfibonnaci(number - 2) + slowfibonnaci(number - 1);
    }

    public static void main(String[] args){

        long startTime;
        long endTime;
        long duration;

        int number = 25;


        // Slow method
        startTime = System.nanoTime();
        System.out.println("Slow method: \nFibonacci number of " + number + ": " + Fibonacci.slowfibonnaci(number));
        endTime = System.nanoTime();

        duration = (endTime - startTime)/1000000;
        System.out.println("Time: " + duration + " milliseconds\n");


        // Fast method
        startTime = System.nanoTime();
        System.out.println("Fast method: \nFibonacci number of " + number + ": " + Fibonacci.fastfibonnaci(number));
        endTime = System.nanoTime();

        duration = (endTime - startTime)/1000000;
        System.out.println("Time: " + duration + " milliseconds!\n");
    }
}