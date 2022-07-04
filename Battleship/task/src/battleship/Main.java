package battleship;

import java.util.Scanner;

public class Main {
    public static String inputCoordinates;
    public static String[][] battleField;
    public static boolean correctLength = true;

    public static void main(String[] args) {
        // Write your code here

        Field field = new Field();
        field.blank();
        battleField = new String[field.field.length][];
        for(int i = 0; i < field.field.length; i++)
            battleField[i] = field.field[i].clone();

        Scanner scanner = new Scanner(System.in);

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
    }
}