package battleship;

import java.util.Objects;
import java.util.Scanner;

class MakeShip extends Field {

    boolean loopCondition;

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
    void cruiser() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Cruiser", 3);
            validateShip(ship.name, ship.length);
        }
    }
    void destroyer() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Destroyer", 2);
            validateShip(ship.name, ship.length);
        }
    }

    void validateShip(String shipName, int shipLength) {

        System.out.println("\nEnter the coordinates of the " + shipName + " (" + shipLength + " cells):");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        currentShipLength = shipLength;

        try {
            userInput = scanner.nextLine().toUpperCase().trim();
            CheckUserInput checkUserInput = new CheckUserInput();
            Surroundings surroundings = new Surroundings();

            if (Objects.equals(checkUserInput.validateInput(userInput, currentShipLength), "")) {
                if (Objects.equals(surroundings.checkForShipsNearby(), "")) {
                    loopCondition = false;
                } else {
                    System.out.println(surroundings.checkForShipsNearby());
                }
            } else {
                System.out.println(checkUserInput.validateInput(userInput, currentShipLength));
            }

        } catch (Exception e) {
            System.out.println("Error. Invalid input. Try again.");
            System.out.println("Input should contain two coordinates with a space between them.");
            System.out.println("Example: 'b2 e2', or 'C1 C5'.");
        }
    }
}


