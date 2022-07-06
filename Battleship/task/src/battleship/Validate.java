package battleship;

import java.util.Scanner;

public class Validate {

    public void aircraftCarrier() {

        Scanner scanner = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            Game.setInputString(scanner.nextLine().toUpperCase().trim());
            Coordinates.inputStringCoords = Game.getInputString();

            try {
                Coordinates coordinates = new Coordinates();

                Vessel aircraftCarrier = new Vessel("Aircraft Carrier", 5);
                Coordinates.conditionForValidate = true;

                coordinates.setCorrectLength(aircraftCarrier.length - 1 == coordinates.getColumnDiff()
                        || aircraftCarrier.length - 1 == coordinates.getRowDiff());

                if (Game.getInputString() == null || "".equals(Game.getInputString())) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates are empty. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getK1ColumnNum() > 21 || coordinates.getK2ColumnNum() > 21
                        || coordinates.getK1RowNum() > 11 || coordinates.getK2RowNum() > 11) {

                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates out of battleField. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, you can only position a vessel horizontally or vertically. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");


                } else if (!Coordinates.correctLength) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, wrong length. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

//                } else if (coordinates.getSpaceIndex() == -1) {
//                    Coordinates.conditionForValidate = false;
//                    condition = false;
//                    System.out.println("Error, there is no space between input coordinates. Try again.");
//                    System.out.println("Input should contain two coordinates with a space between them.");
//                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else {
                    Coordinates.conditionForValidate = true;
                    System.out.println();
                    condition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
                System.out.println(InputMessage.aircraftCarrierMessage());
                System.out.print("> ");
            }
        }
    }

    public void battleShip() {

        Scanner scanner = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            Game.setInputString(scanner.nextLine().toUpperCase().trim());
            Coordinates.inputStringCoords = Game.getInputString();

            try {
                Coordinates coordinates = new Coordinates();

                Vessel battleShip = new Vessel("Battleship", 4);
                Coordinates.conditionForValidate = true;

                coordinates.setCorrectLength(battleShip.length - 1 == coordinates.getColumnDiff()
                        || battleShip.length - 1 == coordinates.getRowDiff());

                if (Game.getInputString() == null || "".equals(Game.getInputString())) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates are empty. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getK1ColumnNum() > 21 || coordinates.getK2ColumnNum() > 21
                        || coordinates.getK1RowNum() > 11 || coordinates.getK2RowNum() > 11) {

                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates out of battleField. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, you can only position a vessel horizontally or vertically. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");


                } else if (!Coordinates.correctLength) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, wrong length. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

//                } else if (coordinates.getSpaceIndex() == -1) {
//                    Coordinates.conditionForValidate = false;
//                    condition = false;
//                    System.out.println("Error, there is no space between input coordinates. Try again.");
//                    System.out.println("Input should contain two coordinates with a space between them.");
//                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else {
                    Coordinates.conditionForValidate = true;
                    System.out.println();
                    condition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
                System.out.println(InputMessage.aircraftCarrierMessage());
                System.out.print("> ");
            }
        }
    }

    public void submarine() {

        Scanner scanner = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            Game.setInputString(scanner.nextLine().toUpperCase().trim());
            Coordinates.inputStringCoords = Game.getInputString();

            try {
                Coordinates coordinates = new Coordinates();

                Vessel submarine = new Vessel("Submarine", 3);
                Coordinates.conditionForValidate = true;

                coordinates.setCorrectLength(submarine.length - 1 == coordinates.getColumnDiff()
                        || submarine.length - 1 == coordinates.getRowDiff());

                if (Game.getInputString() == null || "".equals(Game.getInputString())) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates are empty. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getK1ColumnNum() > 21 || coordinates.getK2ColumnNum() > 21
                        || coordinates.getK1RowNum() > 11 || coordinates.getK2RowNum() > 11) {

                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates out of battleField. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, you can only position a vessel horizontally or vertically. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");


                } else if (!Coordinates.correctLength) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, wrong length. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

//                } else if (coordinates.getSpaceIndex() == -1) {
//                    Coordinates.conditionForValidate = false;
//                    condition = false;
//                    System.out.println("Error, there is no space between input coordinates. Try again.");
//                    System.out.println("Input should contain two coordinates with a space between them.");
//                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else {
                    Coordinates.conditionForValidate = true;
                    System.out.println();
                    condition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
                System.out.println(InputMessage.aircraftCarrierMessage());
                System.out.print("> ");
            }
        }
    }

    public void destroyer() {

        Scanner scanner = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            Game.setInputString(scanner.nextLine().toUpperCase().trim());
            Coordinates.inputStringCoords = Game.getInputString();

            try {
                Coordinates coordinates = new Coordinates();

                Vessel destroyer = new Vessel("Destroyer", 3);
                Coordinates.conditionForValidate = true;

                coordinates.setCorrectLength(destroyer.length - 1 == coordinates.getColumnDiff()
                        || destroyer.length - 1 == coordinates.getRowDiff());

                if (Game.getInputString() == null || "".equals(Game.getInputString())) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates are empty. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getK1ColumnNum() > 21 || coordinates.getK2ColumnNum() > 21
                        || coordinates.getK1RowNum() > 11 || coordinates.getK2RowNum() > 11) {

                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates out of battleField. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, you can only position a vessel horizontally or vertically. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");


                } else if (!Coordinates.correctLength) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, wrong length. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

//                } else if (coordinates.getSpaceIndex() == -1) {
//                    Coordinates.conditionForValidate = false;
//                    condition = false;
//                    System.out.println("Error, there is no space between input coordinates. Try again.");
//                    System.out.println("Input should contain two coordinates with a space between them.");
//                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else {
                    Coordinates.conditionForValidate = true;
                    System.out.println();
                    condition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
                System.out.println(InputMessage.aircraftCarrierMessage());
                System.out.print("> ");
            }
        }
    }

    void patrolBoat() {

        Scanner scanner = new Scanner(System.in);
        boolean condition = true;



        while (condition) {
            Game.setInputString(scanner.nextLine().toUpperCase().trim());
            Coordinates.inputStringCoords = Game.getInputString();

            try {
                Coordinates coordinates = new Coordinates();

                        Vessel patrolBoat = new Vessel("Patrol Boat", 2);
                Coordinates.conditionForValidate = true;

                coordinates.setCorrectLength(patrolBoat.length - 1 == coordinates.getColumnDiff()
                        || patrolBoat.length - 1 == coordinates.getRowDiff());

                if (Game.getInputString() == null || "".equals(Game.getInputString())) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates are empty. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getK1ColumnNum() > 21 || coordinates.getK2ColumnNum() > 21
                        || coordinates.getK1RowNum() > 11 || coordinates.getK2RowNum() > 11) {

                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, input coordinates out of battleField. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, you can only position a vessel horizontally or vertically. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");


                } else if (!Coordinates.correctLength) {
                    Coordinates.conditionForValidate = false;
                    condition = false;
                    System.out.println("Error, wrong length. Try again.");
                    System.out.println("Input should contain two coordinates with a space between them.");
                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

//                } else if (coordinates.getSpaceIndex() == -1) {
//                    Coordinates.conditionForValidate = false;
//                    condition = false;
//                    System.out.println("Error, there is no space between input coordinates. Try again.");
//                    System.out.println("Input should contain two coordinates with a space between them.");
//                    System.out.println("Example: 'b2 e2', or 'C1 C5'.");

                } else {
                    Coordinates.conditionForValidate = true;
                    System.out.println();
                    condition = false;
                }

            } catch (Exception e) {
                System.out.println("Error, invalid input. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");
                System.out.println(InputMessage.aircraftCarrierMessage());
                System.out.print("> ");
            }
        }
    }
}
