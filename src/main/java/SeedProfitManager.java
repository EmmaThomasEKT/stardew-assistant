import java.util.*;

// dont need a helper since each method is usinf
public class SeedProfitManager {
    public static void seedProfitCalculator(Scanner scanner) {
        System.out.println("Welcome to Seed Profit Calculator\nPlease select a tool below (1/2/3):\n");
        System.out.println("""
                1. Input seeds
                2. Calculate Profit
                3. Return
                """);
        int tool = scanner.nextInt();

        switch (tool){
            case 1:
                inputSeeds(scanner);
                break;
            case 2:
                calculateProfit(scanner);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Input.");
        }
    }

    public static boolean inputSeeds(Scanner scanner) {
        // input seed name and quantity
        // parse..
        // append to SeedList.txt
    }

    public static boolean calculateProfit(Scanner scanner) {
        // read SeedList.txt
        // do maths (seed price - seed sell price = seed profit
        // output
    }
}
