package battleship;

class CheckUserInput {

    public static boolean isCorrectLength() {
        return correctLength;
    }
    public static void setCorrectLength(boolean correctLength) {
        CheckUserInput.correctLength = correctLength;
    }
    public static boolean isInputOkCondition() {
        return inputOkCondition;
    }
    public static void setInputOkCondition(boolean inputOkCondition) {
        CheckUserInput.inputOkCondition = inputOkCondition;
    }
    public static int getSpaceIndex() {
        return spaceIndex;
    }
    public static void setSpaceIndex(int spaceIndex) {
        CheckUserInput.spaceIndex = spaceIndex;
    }
    public void setK1(String k1) {
        CheckUserInput.k1 = k1;
    }
    public void setK2(String k2) {
        CheckUserInput.k2 = k2;
    }
    public int getK1RowNum() {
        return k1RowNum;
    }
    public void setK1RowNum(int k1RowNum) {
        CheckUserInput.k1RowNum = k1RowNum;
    }
    public int getK2RowNum() {
        return k2RowNum;
    }
    public void setK2RowNum(int k2RowNum) {
        CheckUserInput.k2RowNum = k2RowNum;
    }
    public int getK1ColumnNum() {
        return k1ColumnNum;
    }
    public void setK1ColumnNum(int k1ColumnNum) {
        CheckUserInput.k1ColumnNum = k1ColumnNum;
    }
    public int getK2ColumnNum() {
        return k2ColumnNum;
    }
    public void setK2ColumnNum(int k2ColumnNum) {
        CheckUserInput.k2ColumnNum = k2ColumnNum;
    }
    public int getRowDiff() {
        return rowDiff;
    }
    public void setRowDiff(int rowDiff) {
        CheckUserInput.rowDiff = rowDiff;
    }
    public int getColumnDiff() {
        return columnDiff;
    }
    public void setColumnDiff(int columnDiff) {
        CheckUserInput.columnDiff = columnDiff;
    }

    private static boolean correctLength;
    private static boolean inputOkCondition;
    private static int spaceIndex;
    private static String k1;
    private static String k2;
    private static int k1RowNum;
    private static int k2RowNum;
    private static int k1ColumnNum;
    private static int k2ColumnNum;
    private static int rowDiff;
    private static int columnDiff;

    void validate() {

        if (PositionVessel.userInput == null || "".equals(PositionVessel.userInput)
                || PositionVessel.userInput.isEmpty() || PositionVessel.userInput.isBlank()) {

            System.out.println("Error, input coordinates are empty. Try again.");
            System.out.println("Input should contain two coordinates with a space between them.");
            System.out.println("Example: 'b2 e2', or 'C1 C5'.");

        } else if (!PositionVessel.userInput.contains(" ")) {
            System.out.println("Error, there is no space between input coordinates. Try again.");
            System.out.println("Input should contain two coordinates with a space between them.");
            System.out.println("Example: 'b2 e2', or 'C1 C5'.");

        } else {
            int ascii_A_index = 64;
            int inputLength = PositionVessel.userInput.length();

            setSpaceIndex(PositionVessel.userInput.indexOf(" "));
            setK1(PositionVessel.userInput.substring(0, spaceIndex));
            setK2(PositionVessel.userInput.substring(spaceIndex + 1, inputLength));

            setK1RowNum((byte) k1.charAt(0) - ascii_A_index);
            setK2RowNum((byte) k2.charAt(0) - ascii_A_index);
            setK1ColumnNum(Integer.parseInt(k1.substring(1)) * 2);
            setK2ColumnNum(Integer.parseInt(k2.substring(1)) * 2);

            if (getK2RowNum() >= getK1RowNum()) {
                setRowDiff(Math.abs(getK2RowNum() - getK1RowNum()));

            } else {
                int temporary = getK1RowNum();
                setK1RowNum(getK2RowNum());
                setK1RowNum(temporary);
                setRowDiff(Math.abs(getK2RowNum() - getK1RowNum()));
            }

            if (getK2ColumnNum() >= getK1ColumnNum()) {
                setColumnDiff(Math.abs(getK2ColumnNum() - getK1ColumnNum()) / 2);

            } else {
                int temporary = getK1ColumnNum();
                setK1ColumnNum(getK2ColumnNum());
                setK2ColumnNum(temporary);
                setColumnDiff(Math.abs(getK2ColumnNum() - getK1ColumnNum()) / 2);
            }

            setCorrectLength((PositionVessel.vesselLength - 1 == getColumnDiff()
                    || PositionVessel.vesselLength - 1 == getRowDiff()));

            if (getK1ColumnNum() > 21 || getK2ColumnNum() > 21
                    || getK1RowNum() > 11 || getK2RowNum() > 11) {

                setInputOkCondition(false);
                System.out.println("Error, input coordinates out of battleField. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");

            } else if (getColumnDiff() != 0 && getRowDiff() != 0) {
                setInputOkCondition(false);
                System.out.println("Error, you can only position a vessel horizontally or vertically. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");

            } else if (!isCorrectLength()) {
                setInputOkCondition(false);
                System.out.println("Error, wrong length. Try again.");
                System.out.println("Input should contain two coordinates with a space between them.");
                System.out.println("Example: 'b2 e2', or 'C1 C5'.");

            } else {
                setInputOkCondition(true);
                PositionVessel.loopCondition = false;
                System.out.println();
            }
        } //new InputMessage();
    }
}
