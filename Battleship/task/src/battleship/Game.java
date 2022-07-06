package battleship;

public class Game {

    public static void setInputString(String inputString) {
        Game.inputString = inputString;
    }
    private static String inputString;
    public static String getInputString() {
        return inputString;
    }

    public void play () {

        Field battleField = new Field();
        Validate validate = new Validate();
        battleField.blank();

        boolean condition = true;
        while (condition) {
            System.out.println(InputMessage.aircraftCarrierMessage());
            System.out.print("> ");
            validate.aircraftCarrier();

            if(Coordinates.conditionForValidate && Coordinates.correctLength) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.battleshipMessage());
            System.out.print("> ");
            validate.battleShip();

            if(Coordinates.conditionForValidate && Coordinates.correctLength) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.submarineMessage());
            System.out.print("> ");
            validate.submarine();

            if(Coordinates.conditionForValidate && Coordinates.correctLength) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.destroyerMessage());
            System.out.print("> ");
            validate.destroyer();

            if(Coordinates.conditionForValidate && Coordinates.correctLength) {
                battleField.newField();
                condition = false;
            }
        }

        condition = true;
        while (condition) {
            System.out.println(InputMessage.patrolBoatMessage());
            System.out.print("> ");
            validate.patrolBoat();

            if(Coordinates.conditionForValidate && Coordinates.correctLength) {
                battleField.newField();
                condition = false;
            }
        }
    }
}
