package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheckUserInput extends ValidateShip {
//    Checking input and ships.

    boolean appropriateLength;
    int spaceIndex;
    String c1;
    String c2;

//    these have to be static in order to be accessible from other classes
    static int c1RowNum;
    static int c2RowNum;
    static int c1ColumnNum;
    static int c2ColumnNum;
    static int rowDiff;
    static int columnDiff;
    static String[][] shipSurroundingField;

    List<String> checkAroundShip = new ArrayList<>();

    String validate (String userInput, int currentShipLength, boolean loopCondition) {
//    Validates if input string is ok.

        this.userInput = userInput;
        this.currentShipLength = currentShipLength;
        this.loopCondition = loopCondition;

//        Checking if input format is ok.
        if (userInput.isBlank()) {
            return """
                    Input coordinates are empty. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else if (!userInput.contains(" ")) {
            return """
                    There is no space between input coordinates. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else {
//
            makeCoordinates();
            checkSuroundings();

//            Checking for other errors in input.
            if (c1ColumnNum > 21 || c2ColumnNum > 21 || c1RowNum > 11 || c2RowNum > 11) {

                return """
                        Input coordinates are out of battlefield range. Row range: A-J, column range: 1-10. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (columnDiff != 0 && rowDiff != 0) {
                return """
                        You can only position a ship horizontally or vertically, not diagonally. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (!appropriateLength) {
                return """
                        Incorrect length of the ship. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (checkAroundShip.contains("O")) {
                return """
                        Too close to existing ship. Ships cannot touch. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else {
//          If everything is ok with the input.
                return "";
            }
        }
    }

    void makeCoordinates () {

        int ascii_A_index = 64;
        int inputLength = userInput.length();

        spaceIndex = userInput.indexOf(" ");
        c1 = userInput.substring(0, spaceIndex);
        c2 = userInput.substring(spaceIndex + 1, inputLength);

        c1RowNum = (byte) c1.charAt(0) - ascii_A_index;
        c2RowNum = (byte) c2.charAt(0) - ascii_A_index;
        c1ColumnNum = Integer.parseInt(c1.substring(1)) * 2;
        c2ColumnNum = Integer.parseInt(c2.substring(1)) * 2;

//            Switching places if first input value is bigger than second.
        if (c2RowNum < c1RowNum) {
            int temporary = c1RowNum;
            c1RowNum = c2RowNum;
            c2RowNum = temporary;
        } rowDiff = Math.abs(c2RowNum - c1RowNum);
//            Switching places if first input value is bigger than second.
        if (c2ColumnNum < c1ColumnNum) {
            int temporary = c1ColumnNum;
            c1ColumnNum = c2ColumnNum;
            c2ColumnNum = temporary;
        } columnDiff = Math.abs(c2ColumnNum - c1ColumnNum) / 2;

//            Confirming that the length of the ship is correct.
        appropriateLength = (currentShipLength - 1 == columnDiff || currentShipLength - 1 == rowDiff);

    }

    public void checkSuroundings () {

        //            Making a small array field that surrounds a ship.
//            * horizontally or ...
        if (rowDiff == 0) {
            shipSurroundingField = new String[3][(currentShipLength + 2) * 2];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < (currentShipLength + 2) * 2; j += 2) {
                    shipSurroundingField[i][j] = GameField.updatedFieldCopy[i + c1RowNum][j + c1ColumnNum];
                }
            }
        }
//            * ... vertically.
        if (columnDiff == 0) {
            shipSurroundingField = new String[currentShipLength + 2][6];
            for (int i = 0; i < currentShipLength + 2; i++) {
                for (int j = 0; j < 6; j += 2) {
                    shipSurroundingField[i][j] = GameField.updatedFieldCopy[i + c1RowNum][j + c1ColumnNum];
                }
            }
        }

//            List for checking around ship.
        for (String[] array : shipSurroundingField) {
            checkAroundShip.addAll(Arrays.asList(array));
        }

    }

    public void inputMessage() {

//        Printing my checks and tests ...
/*
    System.out.println("\nInput coordinates : " + userInput + ".\n"
            + "K1 (row, column) is " + c1RowNum + ", " + c1ColumnNum + ".\n"
            + "K2 (row, column) is " + c2RowNum + ", " + c2ColumnNum + ".\n"
            + "Row difference is: " + rowDiff + "\n"
            + "Column difference is: " + columnDiff + "\n"
            + "Correct length is: " + appropriateLength + "\n"
            + "Space index is: " + spaceIndex + "\n");
*/
        for (String[] strings : shipSurroundingField) {
            for (int j = 0; j < strings.length; j += 2) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }
}


