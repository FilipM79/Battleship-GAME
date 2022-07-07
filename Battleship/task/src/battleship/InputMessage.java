package battleship;

class InputMessage {

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

    InputMessage() {

        CheckUserInput check = new CheckUserInput();

        try {

            System.out.println("\nInput coordinates : " + PositionVessel.userInput + ".\n"
                    + "K1 (row, column) is " + check.getK1RowNum() + ", " + check.getK1ColumnNum() + ".\n"
                    + "K2 (row, column) is " + check.getK2RowNum() + ", " + check.getK2ColumnNum() + ".\n"
                    + "Row difference is: " + check.getRowDiff() + "\n"
                    + "Column difference is: " + check.getColumnDiff() + "\n"
                    + "Correct length is: " + CheckUserInput.isCorrectLength() + "\n"
                    + "Space index is: " + CheckUserInput.getSpaceIndex() + "\n"
                    + "ConditionForValidate je: " + CheckUserInput.isInputOkCondition() + "\n");

        } catch (Exception e) {
            System.out.println("Something is wrong with printing variables in InputMessage");
        }
    }
}

