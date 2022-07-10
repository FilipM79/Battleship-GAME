package battleship;

import java.util.Objects;
import java.util.Scanner;

class MakeShip {

    String userInput;
    int currentShipLength;
    boolean loopCondition;


    void validateShip (String shipName, int shipLength) {
        System.out.println("\nEnter the coordinates of the " + shipName + " (" + shipLength + " cells):");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        currentShipLength = shipLength;

        try {
            userInput = scanner.nextLine().toUpperCase().trim();
            CheckUserInput checkUserInput = new CheckUserInput();
            System.out.println(checkUserInput.validate(userInput, currentShipLength, loopCondition));
            //check.inputMessage();

            if (Objects.equals(checkUserInput.validate(userInput, currentShipLength, loopCondition), "")) {
                loopCondition = false;
            }

        } catch (Exception e) {
            System.out.println("Error, invalid input. Try again.");
            System.out.println("Input should contain two coordinates with a space between them.");
            System.out.println("Example: 'b2 e2', or 'C1 C5'.");
        }
    }

    void aircraftCarrier() {

        loopCondition = true;
        while (loopCondition) {
            Ship ship = new Ship("Aircraft Carrier", 5);
            validateShip(ship.name, ship.length);
        }
    }

    void battleShip() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Battleship", 4);
            validateShip(ship.name, ship.length);
        }
    }

    void submarine() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Submarine", 3);
            validateShip(ship.name, ship.length);
        }
    }

    void destroyer() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Destroyer", 3);
            validateShip(ship.name, ship.length);
        }
    }

    void patrolBoat() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Patrol boat", 2);
            validateShip(ship.name, ship.length);
        }
    }



}


