package battleship;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class GameField extends CheckUserInput {
//  Making game fields and positioning ships in it

    String[][] field = new String[11][21];
    String[][] updatedField = new String[11][21];
    static String[][] updatedFieldCopy = new String[13][25];


    void printBlankField() {
//    Making blank game field from file
        File file = new File("C:\\Users\\Filip\\IdeaProjects" +
                "\\Battleship\\Battleship\\task\\src\\battleship\\battleField.txt");

        try (Scanner fileScanner = new Scanner(file)) {
//            Populating blank field from file
            for (int rows = 0; rows < field.length; rows++) {
                for (int columns = 0; columns < field[rows].length; columns += 2) {
                    field[rows][columns] = fileScanner.next() + " ";
                }
            } field[0][0] = "  ";

//            Printing blank field
            for (String[] strings : field) {
                for (int j = 0; j < strings.length; j += 2) {
                    System.out.print(strings[j]);
                }
                System.out.println();
            }

//            Populating updatedField from blank field.
            for (int i = 0; i < updatedField.length; i++) {
                for (int j = 0; j < updatedField[i].length; j += 2) {
                    updatedField[i][j] = field[i][j];
                }
            }

//            Populating updatedFieldCopy with "~ "
            for(String[] arr1 : updatedFieldCopy)
                Arrays.fill(arr1, "* ");

//            Populating updatedFieldCopy from blank field.
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 21; j += 2) {
                    updatedFieldCopy[i + 1][j + 2] = field[i][j];
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void printUpdatedField() {
//  Updating and printing game field and position ships in turns

        try {
//            Making a copy of updatedField
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 21; j += 2) {
                    updatedFieldCopy[i + 1][j + 2] = updatedField[i][j];
                }
            }
//            Putting the ship in the field.
//            *horizontally or ...
            if (rowDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    for (int j = c1ColumnNum; j < c2ColumnNum + 1; j += 2) {
                        updatedField[c1RowNum][j] = "O ";
                    }
                }
//            * ...vertically
            } else if (columnDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    updatedField[i][c2ColumnNum] = "O ";
                }
            }

//            printing updatedField with a new ship
            for (String[] strings : updatedField) {
                for (int j = 0; j < strings.length; j += 2) {
                    System.out.print(strings[j]);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void printUpdatedFieldCopy () {

        for (String[] strings : updatedFieldCopy) {
            for (int j = 0; j < strings.length; j += 2) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }

    }
    void makeCoordinates () {

        int ascii_A_index = 64;
        int inputLength = userInput.length();

        spaceIndex = userInput.indexOf(" ");
        c1 = userInput.substring(0, spaceIndex);
        c2 = userInput.substring(spaceIndex + 1, inputLength);

        c1RowNum = (byte) c1.charAt(0) - ascii_A_index;
        c2RowNum = (byte) c2.charAt(0) - ascii_A_index;
        c1ColumnNum = Integer.parseInt(c1.substring(1)) * 2;
        c2ColumnNum = Integer.parseInt(c2.substring(1)) * 2;

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
        } columnDiff = Math.abs(c2ColumnNum - c1ColumnNum) / 2;

//            Confirming that the length of the ship is correct.
        appropriateLength = (currentShipLength - 1 == columnDiff || currentShipLength - 1 == rowDiff);

    }
}