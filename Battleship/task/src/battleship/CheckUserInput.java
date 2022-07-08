package battleship;

class CheckUserInput extends PositionShip {

    boolean appropriateLength;
    int spaceIndex;
    String c1;
    String c2;

    static int c1RowNum;
    static int c2RowNum;
    static int c1ColumnNum;
    static int c2ColumnNum;

    static int rowDiff;
    static int columnDiff;

     String validate (String userInput, int currentShipLength, boolean loopCondition) {

        this.userInput = userInput;
        this.currentShipLength = currentShipLength;
        this.loopCondition = loopCondition;

        if (userInput == null || "".equals(userInput ) || userInput.isEmpty() || userInput.isBlank()) {
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
            int ascii_A_index = 64;
            int inputLength = userInput.length();

            spaceIndex = userInput.indexOf(" ");
            c1 = userInput.substring(0, spaceIndex);
            c2 = userInput.substring(spaceIndex + 1, inputLength);

            c1RowNum = (byte) c1.charAt(0) - ascii_A_index;
            c2RowNum = (byte) c2.charAt(0) - ascii_A_index;
            c1ColumnNum = Integer.parseInt(c1.substring(1)) * 2;
            c2ColumnNum = Integer.parseInt(c2.substring(1)) * 2;

            if (c2RowNum < c1RowNum) {
                int temporary = c1RowNum;
                c1RowNum = c2RowNum;
                c2RowNum = temporary;
            } rowDiff = Math.abs(c2RowNum - c1RowNum);

            if (c2ColumnNum < c1ColumnNum) {
                int temporary = c1ColumnNum;
                c1ColumnNum = c2ColumnNum;
                c2ColumnNum = temporary;
            } columnDiff = Math.abs(c2ColumnNum - c1ColumnNum) / 2;

            appropriateLength = (currentShipLength - 1 == columnDiff || currentShipLength - 1 == rowDiff);

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

            } else {
                return "";
            }
        }
    }

    public void inputMessage() {

    System.out.println("\nInput coordinates : " + userInput + ".\n"
            + "K1 (row, column) is " + c1RowNum + ", " + c1ColumnNum + ".\n"
            + "K2 (row, column) is " + c2RowNum + ", " + c2ColumnNum + ".\n"
            + "Row difference is: " + rowDiff + "\n"
            + "Column difference is: " + columnDiff + "\n"
            + "Correct length is: " + appropriateLength + "\n"
            + "Space index is: " + spaceIndex + "\n");

    }
}

