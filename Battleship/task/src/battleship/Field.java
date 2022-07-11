package battleship;

import java.io.File;
import java.io.IOException;
import java.util.*;

class Field {

    String userInput;
    static int currentShipLength;
    String[][] blankField = new String[11][21];
    String[][] battlefield = new String[11][11];
    static String[][] testField = new String[13][13];

    static int counter = 0;
    static int c1RowNum;
    static int c2RowNum;
    static int c1ColumnNum;
    static int c2ColumnNum;
    static int rowDiff;
    static int columnDiff;
    boolean appropriateLength;


    void makeBlankField() {
//    Making blank game field from file
        File file = new File("C:\\Users\\Filip\\IdeaProjects" +
                "\\Battleship\\Battleship\\task\\src\\battleship\\battleField.txt");

        try (Scanner fileScanner = new Scanner(file)) {

            for(String[] arr1 : blankField)
                Arrays.fill(arr1, " ");

//            Populating blank field from file
            for (int rows = 0; rows < blankField.length; rows++) {
                for (int columns = 0; columns < blankField[rows].length; columns += 2) {
                    blankField[rows][columns] = fileScanner.next() + " ";
                }
            } blankField[0][0] = "  ";

//            Populating battlefield from blank field.
            for (int i = 0; i < battlefield.length; i++) {
                for (int j = 0; j < battlefield[i].length; j++) {
                    battlefield[i][j] = blankField[i][j * 2];
                }
            }
//
//            Populating previousStateField with "* "
            for(String[] arr1 : testField)
                Arrays.fill(arr1, "* ");

//            Populating updatedFieldCopy from updated field.
            for (int i = 0; i < 11; i++) {
                System.arraycopy(battlefield[i], 0, testField[i + 1], 1, 11);
            }

            testField[1][1] = "* ";

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    void generateCoordinates(String userInput, int currentShipLength) {

        int ascii_A_index = 64;
        int inputLength = userInput.length();

        int spaceIndex = userInput.indexOf(" ");
        String c1 = userInput.substring(0, spaceIndex);
        String c2 = userInput.substring(spaceIndex + 1, inputLength);

        c1RowNum = (byte) c1.charAt(0) - ascii_A_index;
        c2RowNum = (byte) c2.charAt(0) - ascii_A_index;
        c1ColumnNum = Integer.parseInt(c1.substring(1));
        c2ColumnNum = Integer.parseInt(c2.substring(1));

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
        } columnDiff = Math.abs(c2ColumnNum - c1ColumnNum);

//            Confirming that the length of the ship is correct.
        appropriateLength = (currentShipLength - 1 == columnDiff || currentShipLength - 1 == rowDiff);

    }
    void addNewShip() {

        try {
//          Putting the ship in the field horizontally or ...
            if (rowDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    for (int j = c1ColumnNum; j < c2ColumnNum + 1; j++) {
                        battlefield[c1RowNum][j] = "O ";
                    }
                }

//          * ...vertically
            } else if (columnDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    battlefield[i][c2ColumnNum] = "O ";
                }
            }

            //            Populating updatedFieldCopy from updated field.
            for (int i = 0; i < 11; i++) {
                System.arraycopy(battlefield[i], 0, testField[i + 1], 1, 11);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            counter++;
        }

    }

    void printBlankField() {
        System.out.println();
        for (String[] strings : blankField) {
            for (int j = 0; j < strings.length; j += 2) {
                System.out.print(strings[j]);
            } System.out.println();
        }
    }
    void printBattlefield() {
        System.out.println();
        for (String[] strings : battlefield) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }
}