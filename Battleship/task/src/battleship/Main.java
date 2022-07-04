package battleship;

import java.util.Scanner;
public class Main {
    public static String inputCoordinates;
    public static String[][] battleField;
    public static String[][] battleFieldCopy;
    public static boolean correctLength = true;

    public static void main(String[] args) {
        // Write your code here
        Field start = new Field();
        start.blank();

        //copying start.blank field array to battlefield array
        battleField = new String[start.field.length][];
        for(int i = 0; i < start.field.length; i++)
            battleField[i] = start.field[i].clone();

        Scanner scanner = new Scanner(System.in);

        // populating array
        correctLength = true;
        while (correctLength) {
            System.out.println(GamePrinter.aircraftCarrier());
            System.out.print("> ");
            inputCoordinates = scanner.nextLine().toUpperCase().trim();
            Vessel.positionAircraftCarrier();
        }

        correctLength = true;
        while (correctLength) {
            System.out.println(GamePrinter.battleship());
            System.out.print("> ");
            inputCoordinates = scanner.nextLine().toUpperCase().trim();
            Vessel.positionBattleship();
        }

        correctLength = true;
        while (correctLength) {
            System.out.println(GamePrinter.submarine());
            System.out.print("> ");
            inputCoordinates = scanner.nextLine().toUpperCase().trim();
            Vessel.positionSubmarine();
        }

        correctLength = true;
        while (correctLength) {
            System.out.println(GamePrinter.destroyer());
            System.out.print("> ");
            inputCoordinates = scanner.nextLine().toUpperCase().trim();
            Vessel.positionDestroyer();
        }

        correctLength = true;
        while (correctLength) {
            System.out.println(GamePrinter.patrolBoat());
            System.out.print("> ");
            inputCoordinates = scanner.nextLine().toUpperCase().trim();
            Vessel.positionPatrolBoat();
        }
        scanner.close();

    }
}