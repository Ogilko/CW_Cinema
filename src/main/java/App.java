import entity.Context;
import service.MenuService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        parseInput(args);
        MenuService menuService = new MenuService();

        menuService.showMenu();

        while(true){
            try(Scanner scanner = new Scanner(System.in)){
                menuService.applyChoise(scanner.nextInt());
                menuService.showMenu();
            }
        }
    }


    private static void parseInput(String[] args) {
        if (args.length != 0) {
            String fileDirectory = args[0];
            Context context = new Context(fileDirectory);
        } else {
            System.out.println("Wrong input parameter");
            System.exit(0);
        }
    }
}

