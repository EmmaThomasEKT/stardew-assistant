// Stardew Valley Assistant.

// FUTURE CHANGES:

//      no lowercase/catch options for inputs
// control what happens when exceptions occur: use a logging framework

// input total in ur budget seeds for the entire season x2 seed quantity if it has 2 harvests but 2 seeds (eg u need to buy melon twice)
// hashmap : key = seed, value = profit (sell price - seed price = profit) return profit
// input how many seeds you'll buy for the whole season, output profit

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenuManager.mainMenu(scanner);
        scanner.close();
    }

    public static void seasonalBudget(Scanner scanner) {
        MainMenuManager.seasonalBudgetTool(scanner);
    }
}

// get SeedProfitManager.seedInput to print seed option from Helpers.create... instead of SeedDatabase
// Get rid of "... Seeds" / "... Starter" in Helpers