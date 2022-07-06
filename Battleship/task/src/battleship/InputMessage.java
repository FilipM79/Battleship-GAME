package battleship;

class InputMessage {

    Coordinates coordinates = new Coordinates();

    InputMessage() {

        System.out.println("Input coordinates : " + Game.getInputString() + ".\n"
                + "K1 (row, column) is " + coordinates.getK1RowNum() + ", " + coordinates.getK1ColumnNum() + ".\n"
                + "K2 (row, column) is " + coordinates.getK2RowNum() + ", " + coordinates.getK2ColumnNum() + ".\n"
                + "Row difference is: " + coordinates.getRowDiff() + "\n"
                + "Column difference is: " + coordinates.getColumnDiff() + "\n"
                + "Correct length is: " + Coordinates.correctLength + "\n"
                + "Space index is: " + coordinates.getSpaceIndex() + "\n"
                + "ConditionForValidate je: " + Coordinates.conditionForValidate);
    }

    static String aircraftCarrierMessage () {
        return "\nEnter the coordinates of the Aircraft Carrier (5 cells):";
    }
    static String battleshipMessage () {
        return "\nEnter the coordinates of the Battleship (4 cells):";
    }
    static String submarineMessage () {
        return "\nEnter the coordinates of the Submarine (3 cells):";
    }
    static String destroyerMessage () {
        return "\nEnter the coordinates of the Destroyer (3 cells):";
    }
    static String patrolBoatMessage () {
        return "Enter the coordinates of the Patrol Boat (2 cells):";
    }
}
