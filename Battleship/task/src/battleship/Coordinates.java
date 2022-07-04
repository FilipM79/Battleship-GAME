package battleship;

class Coordinates extends Main {

    private String inputString = inputCoordinates;
    private final int f = inputString.length();
    private final int spaceIndex = inputString.indexOf(" ");
    private final String k1 = inputString.substring(0, spaceIndex);
    private final String k2 = inputString.substring(spaceIndex + 1, f);
    private final int ascii_A_index = 64;
    private final int k1RowNum = ((byte) k1.charAt(0)) - ascii_A_index;
    private final int k2RowNum = ((byte) k2.charAt(0)) - ascii_A_index;
    private final int k1ColumnNum = Integer.parseInt(k1.substring(1)) * 2;
    private final int k2ColumnNum = Integer.parseInt(k2.substring(1)) * 2;
    private final int rowDiff = Math.abs(k2RowNum - k1RowNum);
    private final int columnDiff = Math.abs(k2ColumnNum - k1ColumnNum) / 2;

    public Coordinates() {
        int columnDiff = Math.abs(k2ColumnNum - k1ColumnNum) / 2;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
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
}


