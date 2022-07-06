package battleship;

class Coordinates {

    static String inputStringCoords;
    static boolean correctLength;
    static boolean conditionForValidate;

    private final int f = inputStringCoords.length();
    private final int spaceIndex = inputStringCoords.indexOf(" ");
    private final String k1 = inputStringCoords.substring(0, spaceIndex);
    private final String k2 = inputStringCoords.substring(spaceIndex + 1, f);
    private final int ascii_A_index = 64;
    private int k1RowNum = ((byte) k1.charAt(0)) - ascii_A_index;
    private int k2RowNum = ((byte) k2.charAt(0)) - ascii_A_index;
    private int k1ColumnNum = Integer.parseInt(k1.substring(1)) * 2;
    private int k2ColumnNum = Integer.parseInt(k2.substring(1)) * 2;
    private final int rowDiff = Math.abs(k2RowNum - k1RowNum);
    private final int columnDiff = Math.abs(k2ColumnNum - k1ColumnNum) / 2;


    public void setK1RowNum(int k1RowNum) {
        this.k1RowNum = k1RowNum;
    }
    public void setK2RowNum(int k2RowNum) {
        this.k2RowNum = k2RowNum;
    }
    public void setK1ColumnNum(int k1ColumnNum) {
        this.k1ColumnNum = k1ColumnNum;
    }
    public void setK2ColumnNum(int k2ColumnNum) {
        this.k2ColumnNum = k2ColumnNum;
    }
    public void setCorrectLength(boolean correctLength) {
        Coordinates.correctLength = correctLength;
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
        Coordinates.conditionForValidate = conditionForValidate;
    }

    Coordinates() {

        if (getK1RowNum() > getK2RowNum()) {
            int temporaryRow = getK2RowNum();
            setK2RowNum(getK1RowNum());
            setK1RowNum(temporaryRow);
        }

        if (getK1ColumnNum() > getK2ColumnNum()) {
            int temporaryColumn = getK2ColumnNum();
            setK2ColumnNum(getK1ColumnNum());
            setK1ColumnNum(temporaryColumn);
        }
    }
}

