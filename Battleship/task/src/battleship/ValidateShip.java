package battleship;

import java.util.Objects;
import java.util.Scanner;

class ValidateShip {
// Scanning for user input string and passing it to CheckUserInput class.
// Constructing different ships and validating all checks of the input,
// through CheckUserInput class.

    String userInput;
    int currentShipLength;
    boolean loopCondition;

    void aircraftCarrier() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Aircraft Carrier", 5);
            System.out.println("\nEnter the coordinates of the " + ship.name + " (" + ship.length + " cells):");
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            currentShipLength = ship.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, currentShipLength, loopCondition));
                //check.inputMessage();

                if (Objects.equals(check.validate(userInput, currentShipLength, loopCondition), "")) {
                    loopCondition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
            }
        }
    }

    void battleShip() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Battleship", 4);
            System.out.println("\nEnter the coordinates of the " + ship.name + " (" + ship.length + " cells):");
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            currentShipLength = ship.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, currentShipLength, loopCondition));

                if (Objects.equals(check.validate(userInput, currentShipLength, loopCondition), "")) {
                    loopCondition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
            }
        }
    }

    void submarine() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Submarine", 3);
            System.out.println("\nEnter the coordinates of the " + ship.name + " (" + ship.length + " cells):");
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            currentShipLength = ship.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, currentShipLength, loopCondition));

                if (Objects.equals(check.validate(userInput, currentShipLength, loopCondition), "")) {
                    loopCondition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
            }
        }
    }

    void destroyer() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Destroyer", 3);
            System.out.println("\nEnter the coordinates of the " + ship.name + " (" + ship.length + " cells):");
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            currentShipLength = ship.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, currentShipLength, loopCondition));

                if (Objects.equals(check.validate(userInput, currentShipLength, loopCondition), "")) {
                    loopCondition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
            }
        }
    }

    void patrolBoat() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Patrol boat", 2);
            System.out.println("\n Enter the coordinates of the " + ship.name + " (" + ship.length + " cells):");
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            currentShipLength = ship.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, currentShipLength, loopCondition));

                if (Objects.equals(check.validate(userInput, currentShipLength, loopCondition), "")) {
                    loopCondition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
            }
        }
    }
}


