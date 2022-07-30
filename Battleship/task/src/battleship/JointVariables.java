package battleship;

import java.util.Scanner;

public abstract class JointVariables {

    Scanner scanner = new Scanner(System.in);
    static int c1RowNum;
    static int c2RowNum;
    static int c1ColumnNum;
    static int c2ColumnNum;
    static int rowDiff;
    static int columnDiff;
    static boolean missP1 = false;
    static boolean missP2 = false;

    String shipName;
    int currentShipLength;
    String enter = "0";

    String[][] blankField = new String[11][21];
    String[][] battlefield = new String[11][11];
    String[][] fogField = new String[11][11];
    boolean loopCondition;

    static class Ship {

        Ship(String name, int length) {
            this.name = name;
            this.length = length;
        }

        String name;
        int length;
    }
}
