package battleship;

class CheckUserInput {
//    Checking input.
    String validateInput(String userInput, int currentShipLength) {
//    Validates if input string is ok.

        Field field = new Field();

//        Checking if input format is ok.
        if (userInput.isBlank()) {
            return """
                    Error. Input coordinates are empty. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else if (!userInput.contains(" ")) {
            return """
                    Error. There is no space between input coordinates. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else {
//
            field.generateCoordinates(userInput, currentShipLength);

//            Checking for other errors in input.
            if (Field.c1ColumnNum > 11 || Field.c2ColumnNum > 11
                    || Field.c1RowNum > 11 || Field.c2RowNum > 11) {
                return """
                        Error. Input coordinates are out of battlefield range.
                        Row range is: A-J, column range is: 1-10. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (Field.columnDiff != 0 && Field.rowDiff != 0) {
                return """
                        Error. You can only position a ship horizontally or vertically, not diagonally. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (!field.appropriateLength) {
                return """
                        Error. Incorrect length of the ship. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else {
//          If everything is ok with the input.
                return "";
            }
        }
    }
}


