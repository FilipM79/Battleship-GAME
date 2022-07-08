package battleship;

class CheckUserInput extends PositionVessel {

    boolean correctLength;
    int spaceIndex;
    String k1;
    String k2;


    static int k1RowNum;
    static int k2RowNum;
    static int k1ColumnNum;
    static int k2ColumnNum;
    static int rowDiff;
    static int columnDiff;

     String validate (String userInput, int vesselLength, boolean loopCondition) {

        this.userInput = userInput;
        this.vesselLength = vesselLength;
        this.loopCondition = loopCondition;

        if (userInput == null || "".equals(userInput )
                || userInput.isEmpty() || userInput.isBlank()) {

            return """
                    Error, input coordinates are empty. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else if (!userInput.contains(" ")) {
            return """
                    Error, there is no space between input coordinates. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else {
            int ascii_A_index = 64;
            int inputLength = userInput.length();

            spaceIndex = userInput.indexOf(" ");
            k1 = userInput.substring(0, spaceIndex);
            k2 = userInput.substring(spaceIndex + 1, inputLength);

            k1RowNum = (byte) k1.charAt(0) - ascii_A_index;
            k2RowNum = (byte) k2.charAt(0) - ascii_A_index;
            k1ColumnNum = Integer.parseInt(k1.substring(1)) * 2;
            k2ColumnNum = Integer.parseInt(k2.substring(1)) * 2;

            if (k2RowNum < k1RowNum) {
                int temporary = k1RowNum;
                k1RowNum = k2RowNum;
                k2RowNum = temporary;
            }
            rowDiff = Math.abs(k2RowNum - k1RowNum);

            if (k2ColumnNum < k1ColumnNum) {
                int temporary = k1ColumnNum;
                k1ColumnNum = k2ColumnNum;
                k2ColumnNum = temporary;
            }
            columnDiff = Math.abs(k2ColumnNum - k1ColumnNum) / 2;

            correctLength = (vesselLength - 1 == columnDiff
                    || vesselLength - 1 == rowDiff);

            if (k1ColumnNum > 21 || k2ColumnNum > 21
                    || k1RowNum > 11 || k2RowNum > 11) {

                return """
                        Error, input coordinates out of battleField. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (columnDiff != 0 && rowDiff != 0) {
                return """
                        Error, you can only position a vessel horizontally or vertically. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (!correctLength) {
                return """
                        Error, wrong length. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else {
                return "";
            }
        }
    }
    public void inputMessage() {

        try {

            System.out.println("\nInput coordinates : " + userInput + ".\n"
                    + "K1 (row, column) is " + k1RowNum + ", " + k1ColumnNum + ".\n"
                    + "K2 (row, column) is " + k2RowNum + ", " + k2ColumnNum + ".\n"
                    + "Row difference is: " + rowDiff + "\n"
                    + "Column difference is: " + columnDiff + "\n"
                    + "Correct length is: " + correctLength + "\n"
                    + "Space index is: " + spaceIndex + "\n");

        } catch (Exception e) {
            System.out.println("Something is wrong with printing variables in VesselInputMessage");
        }
    }
}
