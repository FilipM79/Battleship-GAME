package battleship;

class GamePrinter extends Coordinates {
    static String inputMessage;

    GamePrinter() {
        System.out.println("Unete koordinate su: " + getInputString() + ".\n"
                + "K1 (row, column) je " + getK1RowNum() + ", " + getK1ColumnNum() + ".\n"
                + "K2 (row, column) je " + getK2RowNum() + ", " + getK2ColumnNum() + ".\n"
                + "Row difference je: " + getRowDiff() + ", " + "column difference je: " + getColumnDiff());
    }

    static String aircraftCarrier () {
        inputMessage = "\nEnter the coordinates of the Aircraft Carrier (5 cells):";
        return inputMessage;
    }

    static String battleship () {
        inputMessage = "\nEnter the coordinates of the Battleship (4 cells):";
        return inputMessage;
    }

    static String submarine () {
        inputMessage = "\nEnter the coordinates of the Submarine (3 cells):";
        return inputMessage;
    }

    static String destroyer () {
        inputMessage = "\nEnter the coordinates of the Destroyer (3 cells):";
        return inputMessage;
    }

    static String patrolBoat () {
        inputMessage = "Enter the coordinates of the Patrol Boat (2 cells):";
        return inputMessage;
    }
}
