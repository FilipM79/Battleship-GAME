package battleship;

import java.util.Objects;
import java.util.Scanner;

class PositionVessel {

    String userInput;
    int vesselLength;
    boolean loopCondition;

    void aircraftCarrier() {

        VesselInputMessage vesselInputMessage = new VesselInputMessage();
        loopCondition = true;

        while (loopCondition) {
            System.out.println(vesselInputMessage.aircraftCarrierMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Aircraft Carrier", 5);
            vesselLength = vessel.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, vesselLength, loopCondition));
                //check.inputMessage();

                if (Objects.equals(check.validate(userInput, vesselLength, loopCondition), "")) {
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

        VesselInputMessage vesselInputMessage = new VesselInputMessage();
        loopCondition = true;

        while (loopCondition) {
            System.out.println(vesselInputMessage.battleshipMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Battleship", 4);
            vesselLength = vessel.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, vesselLength, loopCondition));

                if (Objects.equals(check.validate(userInput, vesselLength, loopCondition), "")) {
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

        VesselInputMessage vesselInputMessage = new VesselInputMessage();
        loopCondition = true;

        while (loopCondition) {
            System.out.println(vesselInputMessage.submarineMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Submarine", 3);
            vesselLength = vessel.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, vesselLength, loopCondition));

                if (Objects.equals(check.validate(userInput, vesselLength, loopCondition), "")) {
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

        VesselInputMessage vesselInputMessage = new VesselInputMessage();
        loopCondition = true;

        while (loopCondition) {
            System.out.println(vesselInputMessage.destroyerMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Destroyer", 3);
            vesselLength = vessel.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, vesselLength, loopCondition));

                if (Objects.equals(check.validate(userInput, vesselLength, loopCondition), "")) {
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

        VesselInputMessage vesselInputMessage = new VesselInputMessage();
        loopCondition = true;

        while (loopCondition) {
            System.out.println(vesselInputMessage.patrolBoatMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Patrol boat", 2);
            vesselLength = vessel.length;

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
                CheckUserInput check = new CheckUserInput();
                System.out.println(check.validate(userInput, vesselLength, loopCondition));

                if (Objects.equals(check.validate(userInput, vesselLength, loopCondition), "")) {
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


