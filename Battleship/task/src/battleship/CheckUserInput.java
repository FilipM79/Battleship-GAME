package battleship;

class CheckUserInput extends MakeShip {
//    Checking input.

    String validate (String userInput, int currentShipLength, boolean loopCondition) {
//    Validates if input string is ok.

        this.userInput = userInput;
        this.currentShipLength = currentShipLength;
        this.loopCondition = loopCondition;

        Field field = new Field();

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
            field.makeCoordinates(userInput, currentShipLength);
            field.checkSurroundings(currentShipLength);

//            Checking for other errors in input.
            if (field.getC1ColumnNum() > 11 || field.getC2ColumnNum() > 11
                    || field.getC1RowNum() > 11 || field.getC2RowNum() > 11) {
                return """
                        Input coordinates are out of battlefield range. Row range: A-J, column range: 1-10. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (field.getColumnDiff() != 0 && field.getRowDiff() != 0) {
                return """
                        You can only position a ship horizontally or vertically, not diagonally. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (!field.isAppropriateLength()) {
                return """
                        Incorrect length of the ship. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (field.getCheckAroundShip().contains("O ")) {
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

    public void inputMessage() {

//  Printing my checks and tests ...

        Field field = new Field();
/*
    System.out.println("\nInput coordinates : " + userInput + ".\n"
            + "K1 (row, column) is " + c1RowNum + ", " + c1ColumnNum + ".\n"
            + "K2 (row, column) is " + c2RowNum + ", " + c2ColumnNum + ".\n"
            + "Row difference is: " + rowDiff + "\n"
            + "Column difference is: " + columnDiff + "\n"
            + "Correct length is: " + appropriateLength + "\n"
            + "Space index is: " + spaceIndex + "\n");
*/
        for (String[] strings : field.getShipSurroundingField()) {
            for (int j = 0; j < strings.length; j += 2) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }
}


