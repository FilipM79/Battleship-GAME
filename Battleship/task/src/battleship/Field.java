package battleship;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Field extends CheckUserInput {

    String[][] field = new String[11][21];
    String[][] updatedField = new String[11][21];

    void blank() {

        File file = new File("C:\\Users\\Filip\\IdeaProjects" +
                "\\Battleship\\Battleship\\task\\src\\battleship\\battleField.txt");

        try (Scanner fileScanner = new Scanner(file)) {

            for (int rows = 0; rows < field.length; rows++) {
                for (int columns = 0; columns < field[rows].length; columns += 2) {
                    field[rows][columns] = fileScanner.next() + " ";
                }
            } field[0][0] = "  ";

            for (String[] strings : field) {
                for (int j = 0; j < strings.length; j += 2) {
                    System.out.print(strings[j]);
                }
                System.out.println();
            }

            // copying field to updatedField
            for (int i = 0; i < updatedField.length; i++) {
                for (int j = 0; j < updatedField[i].length; j += 2) {
                    updatedField[i][j] = field[i][j];
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void newField() {

        try {

            if (rowDiff == 0) {
                for (int i = k1RowNum; i < k2RowNum + 1; i++) {
                    for (int j = k1ColumnNum; j < k2ColumnNum + 1; j += 2) {
                        updatedField[k1RowNum][j] = "O ";
                    }
                }

                for (String[] strings : updatedField) {
                    for (int j = 0; j < strings.length; j += 2) {
                        System.out.print(strings[j]);
                    }
                    System.out.println();
                }

            } else if (columnDiff == 0) {
                for (int i = k1RowNum; i < k2RowNum + 1; i++) {
                    updatedField[i][k2ColumnNum] = "O ";
                }

                for (String[] strings : updatedField) {
                    for (int j = 0; j < strings.length; j += 2) {
                        System.out.print(strings[j]);
                    }
                    System.out.println();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}