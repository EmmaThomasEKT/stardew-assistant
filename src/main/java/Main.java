// Stardew Valley Assistant.

// FUTURE CHANGES:

//      no lowercase/catch options for inputs
// control what happens when exceptions occur: use a logging framework

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