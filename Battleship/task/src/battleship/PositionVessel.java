package battleship;

import java.util.Scanner;

class PositionVessel extends CheckUserInput {

    static String userInput;
    static int vesselLength;

    static boolean loopCondition;

    void aircraftCarrier() {

        loopCondition = true;

        while (loopCondition) {

            System.out.println(InputMessage.aircraftCarrierMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Aircraft Carrier", 5);
            vesselLength = vessel.length;

            try {

                userInput = scanner.nextLine().toUpperCase().trim();
                new CheckUserInput().validate();

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

            System.out.println(InputMessage.battleshipMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Battleship", 4);
            vesselLength = vessel.length;

            try {

                userInput = scanner.nextLine().toUpperCase().trim();
                new CheckUserInput().validate();

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

            System.out.println(InputMessage.submarineMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Submarine", 3);
            vesselLength = vessel.length;

            try {

                userInput = scanner.nextLine().toUpperCase().trim();
                new CheckUserInput().validate();

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

            System.out.println(InputMessage.destroyerMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Destroyer", 3);
            vesselLength = vessel.length;

            try {

                userInput = scanner.nextLine().toUpperCase().trim();
                new CheckUserInput().validate();

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

            System.out.println(InputMessage.patrolBoatMessage());
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            Vessel vessel = new Vessel("Patrol boat", 2);
            vesselLength = vessel.length;

            try {

                userInput = scanner.nextLine().toUpperCase().trim();
                new CheckUserInput().validate();

            } catch (Exception e) {

                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");

            }
        }
    }
}


