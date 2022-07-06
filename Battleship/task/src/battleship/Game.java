package battleship;

import java.util.Scanner;

public class Game {

    private static String inputString;

    public static String getInputString() {
        return inputString;
    }

    public static void setInputString(String inputString) {
        Game.inputString = inputString;
    }

    public void play () {

        Scanner scanner = new Scanner(System.in);
        Field battleField = new Field();
        battleField.blank();

        Coordinates.inputStringCoords = inputString;

        boolean condition;

        condition = true;
        while (condition) {
            System.out.println(InputMessage.aircraftCarrierMessage());
            System.out.print("> ");
            inputString = scanner.nextLine().toUpperCase().trim();

            Coordinates.inputStringCoords = inputString;
            Validate.Checking checking = new Validate.Checking();
            checking.aircraftCarrier();
            checking.isError();
            new InputMessage();
            System.out.println(checking.isError());
            Coordinates coordinates = new Coordinates();

            if(coordinates.isConditionForValidate() && coordinates.isCorrectLength()) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.battleshipMessage());
            System.out.print("> ");
            inputString = scanner.nextLine().toUpperCase().trim();

            Coordinates.inputStringCoords = inputString;
            Validate.Checking checking = new Validate.Checking();
            checking.battleShip();
            Validate validate = new Validate();
            validate.isError();
            new InputMessage();
            Coordinates coordinates = new Coordinates();

            if(coordinates.isConditionForValidate() && coordinates.isCorrectLength()) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.submarineMessage());
            System.out.print("> ");
            inputString = scanner.nextLine().toUpperCase().trim();

            Coordinates.inputStringCoords = inputString;
            Validate.Checking checking = new Validate.Checking();
            checking.submarine();
            Validate validate = new Validate();
            validate.isError();
            new InputMessage();
            Coordinates coordinates = new Coordinates();

            if(coordinates.isConditionForValidate() && coordinates.isCorrectLength()) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.destroyerMessage());
            System.out.print("> ");
            inputString = scanner.nextLine().toUpperCase().trim();

            Coordinates.inputStringCoords = inputString;
            Validate.Checking checking = new Validate.Checking();
            checking.destroyer();
            Validate validate = new Validate();
            validate.isError();
            new InputMessage();
            Coordinates coordinates = new Coordinates();

            if(coordinates.isConditionForValidate() && coordinates.isCorrectLength()) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.patrolBoatMessage());
            System.out.print("> ");
            inputString = scanner.nextLine().toUpperCase().trim();


            Coordinates.inputStringCoords = inputString;
            Validate.Checking checking = new Validate.Checking();
            checking.patrolBoat();
            Validate validate = new Validate();
            validate.isError();
            new InputMessage();
            Coordinates coordinates = new Coordinates();

            if(coordinates.isConditionForValidate() && coordinates.isCorrectLength()) {
                battleField.newField();
                condition = false;
            }
        }
    }
}
