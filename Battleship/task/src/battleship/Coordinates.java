package battleship;

class Coordinates {

    static String inputStringCoords;
    private boolean correctLength;
    private boolean conditionForValidate;
    private final int f = inputStringCoords.length();
    private final int spaceIndex = inputStringCoords.indexOf(" ");
    private final String k1 = inputStringCoords.substring(0, spaceIndex);
    private final String k2 = inputStringCoords.substring(spaceIndex + 1, f);
    private final int ascii_A_index = 64;
    private final int k1RowNum = ((byte) k1.charAt(0)) - ascii_A_index;
    private final int k2RowNum = ((byte) k2.charAt(0)) - ascii_A_index;
    private final int k1ColumnNum = Integer.parseInt(k1.substring(1)) * 2;
    private final int k2ColumnNum = Integer.parseInt(k2.substring(1)) * 2;
    private final int rowDiff = Math.abs(k2RowNum - k1RowNum);
    private final int columnDiff = Math.abs(k2ColumnNum - k1ColumnNum) / 2;


    public boolean isConditionForValidate() { return conditionForValidate; }
    public boolean isCorrectLength() {
        return correctLength;
    }
    public void setCorrectLength(boolean correctLength) {
        this.correctLength = correctLength;
    }
    public int getSpaceIndex() {
        return spaceIndex;
    }
    public int getK1RowNum() {
        return k1RowNum;
    }
    public int getK2RowNum() {
        return k2RowNum;
    }
    public int getK1ColumnNum() {
        return k1ColumnNum;
    }
    public int getK2ColumnNum() {
        return k2ColumnNum;
    }
    public int getRowDiff() {
        return rowDiff;
    }
    public int getColumnDiff() {
        return columnDiff;
    }
    public void setConditionForValidate(boolean conditionForValidate) {
        this.conditionForValidate = conditionForValidate;
    }
}


