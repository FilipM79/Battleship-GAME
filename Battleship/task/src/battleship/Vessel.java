package battleship;

import java.util.Scanner;

class Vessel extends Main {
    String name;
    int length;
    static Vessel aircraftCarrier = new Vessel("Aircraft Carrier", 5);
    static Vessel battleship = new Vessel("Battleship", 4);
    static Vessel submarine = new Vessel("Submarine", 3);
    static Vessel destroyer = new Vessel("Destroyer", 3);
    static Vessel patrolBoat = new Vessel("Patrol Boat", 2);

    public Vessel(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public static void positionAircraftCarrier() {
        Coordinates coordinates = new Coordinates();
        Field field = new Field();
        coordinates.setInputString(inputCoordinates);

        if (aircraftCarrier.length == coordinates.getColumnDiff() + 1 ||
                aircraftCarrier.length == coordinates.getRowDiff() + 1) {
            //new GamePrinter();
            System.out.println();
            field.newField();
            correctLength = false;

        } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
            System.out.println("Wrong direction, try again.");

        } else {
            System.out.println("Wrong length, try again.");
        }
    }

    public static void positionBattleship() {
        Coordinates coordinates = new Coordinates();
        Field field = new Field();
        coordinates.setInputString(inputCoordinates);

        if (battleship.length == coordinates.getColumnDiff() + 1 ||
                battleship.length == coordinates.getRowDiff() + 1) {
            //new GamePrinter();
            System.out.println();
            field.newField();
            correctLength = false;

        } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
            System.out.println("Wrong direction, try again.");

        } else {
            System.out.println("Wrong length, try again.");
        }
    }

    public static void positionSubmarine() {
        Coordinates coordinates = new Coordinates();
        Field field = new Field();
        coordinates.setInputString(inputCoordinates);

        if (submarine.length == coordinates.getColumnDiff() + 1 ||
                submarine.length == coordinates.getRowDiff() + 1) {
            //new GamePrinter();
            System.out.println();
            field.newField();
            correctLength = false;

        } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
            System.out.println("Wrong direction, try again.");

        } else {
            System.out.println("Wrong length, try again.");

        }
    }

    public static void positionDestroyer() {
        Coordinates coordinates = new Coordinates();
        Field field = new Field();
        coordinates.setInputString(inputCoordinates);

        if (destroyer.length == coordinates.getColumnDiff() + 1 ||
                destroyer.length == coordinates.getRowDiff() + 1) {
            //new GamePrinter();
            System.out.println();
            field.newField();
            correctLength = false;

        } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
            System.out.println("Wrong direction, try again.");

        } else {
            System.out.println("Wrong length, try again.");
        }
    }

    public static void positionPatrolBoat() {
        Coordinates coordinates = new Coordinates();
        Field field = new Field();
        coordinates.setInputString(inputCoordinates);

        if (patrolBoat.length == coordinates.getColumnDiff() + 1 ||
                patrolBoat.length == coordinates.getRowDiff() + 1) {
            //new GamePrinter();
            System.out.println();
            field.newField();
            correctLength = false;

        } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
            System.out.println("Wrong direction, try again.");

        } else {
            System.out.println("Wrong length, try again.");
        }
    }
}
